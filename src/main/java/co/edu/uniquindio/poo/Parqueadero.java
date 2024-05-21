package co.edu.uniquindio.poo;

/**
 *
 * @author Sebastian Román - Yefry Fajardo - Santiago Gordillo
 */
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;

public class Parqueadero {
    private Puesto[][] puestos; // Matriz que representa los puestos del parqueadero.
    private int maxI; // Número máximo de filas y columnas en el parqueadero
    private int maxJ;
    private double tarifaMotoClasica; // Tarifas por hora para diferentes tipos de vehículos.
    private double tarifaMotoHibrida;
    private double tarifaCarro;
    private double gananciasTotales;
    private Map<LocalDate, Map<String, Double>> registroPagos; // Registro de pagos por fecha.

    public Parqueadero(int maxI, int maxJ, double tarifaMotoClasica, double tarifaMotoHibrida, double tarifaCarro) {
        this.maxI = maxI;
        this.maxJ = maxJ;
        this.tarifaMotoClasica = tarifaMotoClasica;
        this.tarifaMotoHibrida = tarifaMotoHibrida;
        this.tarifaCarro = tarifaCarro;
        this.gananciasTotales = 0.0;
        this.puestos = new Puesto[maxI][maxJ];
        this.registroPagos = new HashMap<>();
        for (int i = 0; i < maxI; i++) {
            for (int j = 0; j < maxJ; j++) {
                puestos[i][j] = new Puesto(i, j);
            }
        }
    }

    public void ocuparPuesto(Vehiculo vehiculo, LocalDateTime horaIngreso, int i, int j) {
        if (i >= 0 && i < maxI && j >= 0 && j < maxJ) {
            puestos[i][j].ocuparPuesto(vehiculo, horaIngreso);  // Ajustar nombre del método
        } else {
            System.out.println("Posición inválida.");
        }
    }

    public double liberarPuesto(int i, int j, LocalDateTime horaSalida) {
        if (i >= 0 && i < maxI && j >= 0 && j < maxJ) {
            Puesto puesto = puestos[i][j];
            if (puesto.estaOcupado()) {
                Vehiculo vehiculo = puesto.getVehiculo();
                if (vehiculo != null) {
                    double costo = calcularCosto(puesto.getFechaIngreso(), horaSalida, vehiculo);
                    puesto.liberarPuesto();
                    registrarPago(LocalDate.now(), vehiculo.getClass().getSimpleName(), costo);
                    return costo;
                } else {
                    System.out.println("El puesto está ocupado pero no tiene un vehículo asociado.");
                }
            } else {
                System.out.println("El puesto está vacío.");
            }
        } else {
            System.out.println("Posición inválida.");
        }
        return -1;
    }

    private double calcularCosto(LocalDateTime horaIngreso, LocalDateTime horaSalida, Vehiculo vehiculo) {
        System.out.println("Hora de ingreso: " + horaIngreso);
        System.out.println("Hora de salida: " + horaSalida);
        System.out.println("Vehículo: " + vehiculo);

        Duration duracion = Duration.between(horaIngreso, horaSalida);
        long horas = duracion.toHours(); // Extraemos las horas completas
        long minutosRestantes = duracion.toMinutes() % 60; // Calculamos los minutos restantes
        if (minutosRestantes > 0) {
            horas++; // Si hay minutos restantes, redondeamos hacia arriba
        }
        if (horas == 0 && minutosRestantes > 0) {
            horas = 1; // Si no hay horas completas pero hay minutos restantes, cobramos al menos una hora
        }
        double tarifa = 0.0;
        if (vehiculo instanceof Carro) {
            tarifa = tarifaCarro;
        } else if (vehiculo instanceof MotoClasica) {
            tarifa = tarifaMotoClasica;
        } else if (vehiculo instanceof MotoHibrida) {
            tarifa = tarifaMotoHibrida;
        }
        return horas * tarifa;
    }

    private void registrarPago(LocalDate fecha, String tipoVehiculo, double monto) {
        Map<String, Double> pagosDiarios = registroPagos.getOrDefault(fecha, new HashMap<>());
        pagosDiarios.put(tipoVehiculo, pagosDiarios.getOrDefault(tipoVehiculo, 0.0) + monto);
        registroPagos.put(fecha, pagosDiarios);
        gananciasTotales += monto;
    }

    public void imprimirEstadoParqueadero() {
        for (int i = 0; i < maxI; i++) {
            for (int j = 0; j < maxJ; j++) {
                Puesto puesto = puestos[i][j];
                if (puesto.estaOcupado()) {
                    Vehiculo vehiculo = puesto.getVehiculo();
                    if (vehiculo instanceof Carro) {
                        System.out.print("C ");
                    } else if (vehiculo instanceof MotoClasica) {
                        System.out.print("MC ");
                    } else if (vehiculo instanceof MotoHibrida) {
                        System.out.print("MH ");
                    }
                } else {
                    System.out.print("L ");
                }
            }
            System.out.println();
        }
    }

    public void imprimirListaVehiculos() {
        for (int i = 0; i < maxI; i++) {
            for (int j = 0; j < maxJ; j++) {
                Puesto puesto = puestos[i][j];
                if (puesto.estaOcupado()) {
                    System.out.println(puesto.getVehiculo());
                }
            }
        }
    }

    public void buscarVehiculo(String placa) {
        for (int i = 0; i < maxI; i++) {
            for (int j = 0; j < maxJ; j++) {
                Puesto puesto = puestos[i][j];
                if (puesto.estaOcupado() && puesto.getVehiculo().getPlaca().equals(placa)) {
                    System.out.println("Vehículo encontrado en el puesto: (" + i + ", " + j + ")");
                    System.out.println(puesto.getVehiculo());
                    return;
                }
            }
        }
        System.out.println("Vehículo no encontrado.");
    }

    public void generarReporteGanancias(int opcion, LocalDate fecha, YearMonth mesAnio) {
        if (opcion == 1) {
            generarReporteDeHoy();
        } else if (opcion == 2 && fecha != null) {
            generarReporteDiario(fecha);
        } else if (opcion == 3 && mesAnio != null) {
            generarReporteMensual(mesAnio);
        } else {
            System.out.println("Opción o datos inválidos.");
        }
    }

    private void generarReporteDeHoy() {
        LocalDate hoy = LocalDate.now();
        generarReporteDiario(hoy);
    }

    private void generarReporteDiario(LocalDate fecha) {
        if (registroPagos.containsKey(fecha)) {
            Map<String, Double> pagosDiarios = registroPagos.get(fecha);
            System.out.println("Reporte de ganancias del día " + fecha + ":");
            double totalGananciasDiarias = 0.0;
            for (Map.Entry<String, Double> entry : pagosDiarios.entrySet()) {
                System.out.println(entry.getKey() + ": $" + entry.getValue());
                totalGananciasDiarias += entry.getValue();
            }
            System.out.println("Total de ganancias del día: $" + totalGananciasDiarias);
        } else {
            System.out.println("No hay datos de pagos para el día " + fecha + ".");
        }
    }

    private void generarReporteMensual(YearMonth mesAnio) {
        Map<String, Double> pagosMensuales = new HashMap<>();
        double totalGananciasMensuales = 0.0;
        for (LocalDate fecha : registroPagos.keySet()) {
            if (YearMonth.from(fecha).equals(mesAnio)) {
                Map<String, Double> pagosDiarios = registroPagos.get(fecha);
                for (Map.Entry<String, Double> entry : pagosDiarios.entrySet()) {
                    String tipoVehiculo = entry.getKey();
                    double monto = entry.getValue();
                    pagosMensuales.put(tipoVehiculo, pagosMensuales.getOrDefault(tipoVehiculo, 0.0) + monto);
                    totalGananciasMensuales += monto;
                }
            }
        }

        if (!pagosMensuales.isEmpty()) {
            System.out.println("Reporte de ganancias del mes " + mesAnio + ":");
            for (Map.Entry<String, Double> entry : pagosMensuales.entrySet()) {
                System.out.println(entry.getKey() + ": $" + entry.getValue());
            }
            System.out.println("Total de ganancias del mes: $" + totalGananciasMensuales);
        } else {
            System.out.println("No hay datos de pagos para el mes " + mesAnio + ".");
        }
    }
}
