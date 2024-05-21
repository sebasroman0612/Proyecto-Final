// Clase principal que ejecuta el programa
package co.edu.uniquindio.poo;

/**
 *
 * @author Sebastian Román - Yefry Fajardo - Santiago Gordillo
 */
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita al usuario las configuraciones iniciales del parqueadero
        System.out.print("Ingrese el número máximo de filas para el parqueadero: ");
        int filas = scanner.nextInt();
        System.out.print("Ingrese el número máximo de columnas para el parqueadero: ");
        int columnas = scanner.nextInt();
        System.out.print("Ingrese la tarifa por hora para motos clásicas: ");
        double tarifaMotoClasica = scanner.nextDouble();
        System.out.print("Ingrese la tarifa por hora para motos híbridas: ");
        double tarifaMotoHibrida = scanner.nextDouble();
        System.out.print("Ingrese la tarifa por hora para carros: ");
        double tarifaCarro = scanner.nextDouble();

        // Crea un objeto Parqueadero con las configuraciones dadas
        Parqueadero parqueadero = new Parqueadero(filas, columnas, tarifaMotoClasica, tarifaMotoHibrida, tarifaCarro);

        boolean continuar = true;
        // Bucle principal del menú
        while (continuar) {
            System.out.println("\n-------Menu--------");
            System.out.println("\n¿Qué desea realizar?");
            System.out.println("1. Registrar un nuevo vehículo");
            System.out.println("2. Ver el estado del parqueadero");
            System.out.println("3. Liberar un puesto");
            System.out.println("4. Imprimir la lista de vehículos parqueados");
            System.out.println("5. Buscar un vehículo registrado");
            System.out.println("6. Generar reporte de ganancias");
            System.out.println("7. Finalizar el programa");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            // Ejecuta la opción seleccionada
            switch (opcion) {
                case 1:
                    registrarVehiculo(scanner, parqueadero);
                    break;
                case 2:
                    parqueadero.imprimirEstadoParqueadero();
                    break;
                case 3:
                    liberarPuesto(scanner, parqueadero);
                    break;
                case 4:
                    parqueadero.imprimirListaVehiculos();
                    break;
                case 5:
                    buscarVehiculo(scanner, parqueadero);
                    break;
                case 6:
                    generarReporteGanancias(scanner, parqueadero);
                    break;
                case 7:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
            }
        }

        scanner.close();
    }

    // Método para registrar un nuevo vehículo
    private static void registrarVehiculo(Scanner scanner, Parqueadero parqueadero) {
        System.out.println("¿Qué tipo de vehículo desea registrar?");
        System.out.println("1. Carro");
        System.out.println("2. Moto");
        System.out.print("Seleccione una opción: ");
        int tipoVehiculo = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        // Registro de carro
        if (tipoVehiculo == 1) {
            System.out.print("Ingrese la placa del carro: ");
            String placa = scanner.nextLine();
            System.out.print("Ingrese el modelo del carro: ");
            String modelo = scanner.nextLine();
            System.out.print("Ingrese el nombre del propietario del carro: ");
            String propietario = scanner.nextLine();

            System.out.print("Ingrese la posición donde desea guardar el vehículo:\nI: ");
            int i = scanner.nextInt();
            System.out.print("J: ");
            int j = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            Vehiculo carro = new Carro(placa, modelo, propietario);
            parqueadero.ocuparPuesto(carro, LocalDateTime.now(), i, j);
            System.out.println("Vehículo registrado con éxito.");
        } else if (tipoVehiculo == 2) {
            // Registro de moto
            System.out.println("¿Qué tipo de moto desea registrar?");
            System.out.println("1. Moto Clásica");
            System.out.println("2. Moto Híbrida");
            System.out.print("Seleccione una opción: ");
            int tipoMoto = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            System.out.print("Ingrese la placa de la moto: ");
            String placa = scanner.nextLine();
            System.out.print("Ingrese el modelo de la moto: ");
            String modelo = scanner.nextLine();
            System.out.print("Ingrese el nombre del propietario de la moto: ");
            String propietario = scanner.nextLine();
            System.out.print("Ingrese la velocidad máxima de la moto: ");
            int velocidadMaxima = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            Vehiculo moto;
            if (tipoMoto == 1) {
                moto = new MotoClasica(placa, modelo, propietario, velocidadMaxima);
            } else {
                moto = new MotoHibrida(placa, modelo, propietario, velocidadMaxima);
            }

            System.out.print("Ingrese la posición donde desea guardar el vehículo:\nI: ");
            int i = scanner.nextInt();
            System.out.print("J: ");
            int j = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            parqueadero.ocuparPuesto(moto, LocalDateTime.now(), i, j);
            System.out.println("Vehículo registrado con éxito.");
        } else {
            System.out.println("Opción inválida.");
        }
    }

    // Método para liberar un puesto ocupado en el parqueadero
    private static void liberarPuesto(Scanner scanner, Parqueadero parqueadero) {
        System.out.print("Ingrese la posición del puesto que desea liberar:\nI: ");
        int i = scanner.nextInt();
        System.out.print("J: ");
        int j = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        LocalDateTime horaSalida = null;
        // Solicita y valida la hora de salida ingresada
        while (horaSalida == null) {
            System.out.print("Ingrese la hora de salida en el formato (AAAA-MM-DDTHH:MM:SS), por ejemplo, 2024-05-21T15:30:00: ");
            String horaSalidaStr = scanner.nextLine();
            try {
                horaSalida = LocalDateTime.parse(horaSalidaStr);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha y hora inválido. Por favor, intente nuevamente.");
            }
        }

        // Calcula y muestra el costo del estacionamiento
        double costo = parqueadero.liberarPuesto(i, j, horaSalida);
        if (costo >= 0) {
            System.out.println("El costo del tiempo de estacionamiento es: $" + costo);
        } else {
            System.out.println("El puesto ya está vacío.");
        }
    }

    // Método para buscar un vehículo por su placa
    private static void buscarVehiculo(Scanner scanner, Parqueadero parqueadero) {
        System.out.print("Ingrese la placa del vehículo: ");
        String placa = scanner.nextLine();
        parqueadero.buscarVehiculo(placa);
    }

    // Método para generar un reporte de ganancias
    private static void generarReporteGanancias(Scanner scanner, Parqueadero parqueadero) {
        System.out.println("Seleccione el tipo de reporte:");
        System.out.println("1. Reporte de hoy");
        System.out.println("2. Reporte diario");
        System.out.println("3. Reporte mensual");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        LocalDate fecha = null;
        YearMonth mesAnio = null;
        // Solicita y valida la fecha o mes/año para el reporte
        if (opcion == 2) {
            System.out.print("Ingrese la fecha (AAAA-MM-DD): ");
            String fechaStr = scanner.nextLine();
            fecha = LocalDate.parse(fechaStr);
        } else if (opcion == 3) {
            System.out.print("Ingrese el año (AAAA): ");
            int anio = scanner.nextInt();
            System.out.print("Ingrese el mes (MM): ");
            int mes = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            mesAnio = YearMonth.of(anio, mes);
        }

        parqueadero.generarReporteGanancias(opcion, fecha, mesAnio);
    }
}