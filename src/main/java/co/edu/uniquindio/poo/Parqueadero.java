package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

class Parqueadero {
    private final int maxI;
    private final int maxJ;
    private final List<Puesto> puestos;
    private final List<Vehiculo> vehiculos;
    private final double tarifaMotoClasica;
    private final double tarifaMotoHibrida;
    private final double tarifaCarro;

    public Parqueadero(int maxI, int maxJ, double tarifaMotoClasica, double tarifaMotoHibrida, double tarifaCarro) {
        this.maxI = maxI;
        this.maxJ = maxJ;
        this.tarifaMotoClasica = tarifaMotoClasica;
        this.tarifaMotoHibrida = tarifaMotoHibrida;
        this.tarifaCarro = tarifaCarro;
        this.puestos = new ArrayList<>();
        this.vehiculos = new ArrayList<>();

        for (int i = 0; i < maxI; i++) {
            for (int j = 0; j < maxJ; j++) {
                puestos.add(new Puesto(i, j));
            }
        }
    }

    public boolean validarPosicion(int i, int j) {
        return i >= 0 && i < maxI && j >= 0 && j < maxJ;
    }

    public void ocuparPuesto(Vehiculo vehiculo, LocalDateTime fechaIngreso, int i, int j) {
        if (!validarPosicion(i, j)) {
            System.out.println("La posición especificada no es válida.");
            return;
        }
        Puesto puesto = obtenerPuesto(i, j);
        if (puesto.estaOcupado()) {
            System.out.println("El puesto en la posición (" + i + "," + j + ") ya está ocupado.");
            return;
        }
        puesto.ocupar(vehiculo, fechaIngreso);
        vehiculo.setTarifaPorHora(obtenerTarifaPorTipo(vehiculo)); // Guardar la tarifa correspondiente al vehículo
        vehiculos.add(vehiculo);
        System.out.println("Vehículo registrado con éxito.");
    }

    public double liberarPuesto(int i, int j) {
        if (!validarPosicion(i, j)) {
            System.out.println("La posición especificada no es válida.");
            return -1;
        }
        Puesto puesto = obtenerPuesto(i, j);
        if (!puesto.estaOcupado()) {
            System.out.println("El puesto en la posición (" + i + "," + j + ") no está ocupado.");
            return -1;
        }
        Vehiculo vehiculo = puesto.getVehiculo();
        LocalDateTime fechaIngreso = puesto.getFechaIngreso();
        LocalDateTime fechaSalida = LocalDateTime.now();
        long horas = ChronoUnit.HOURS.between(fechaIngreso, fechaSalida);
        if (horas == 0) {
            horas = 1; // Si el vehículo estuvo menos de una hora, cobramos una hora mínima
        }
        double costo = horas * vehiculo.getTarifaPorHora();
        puesto.liberar();
        vehiculos.remove(vehiculo);
        System.out.println("Vehículo liberado con éxito. Costo: $" + costo);
        return costo;
    }

    double obtenerTarifaPorTipo(Vehiculo vehiculo) {
        if (vehiculo instanceof Moto) {
            Moto moto = (Moto) vehiculo;
            if (moto instanceof MotoClasica) {
                return tarifaMotoClasica;
            } else if (moto instanceof MotoHibrida) {
                return tarifaMotoHibrida;
            }
        } else if (vehiculo instanceof Carro) {
            return tarifaCarro;
        }
        return 0.0; // Tarifa por defecto si el tipo de vehículo no coincide
    }

    public List<Vehiculo> obtenerVehiculosParqueados() {
        return vehiculos;
    }

    public Puesto obtenerPuestoPorVehiculo(Vehiculo vehiculo) {
        for (Puesto puesto : puestos) {
            if (puesto.getVehiculo() != null && puesto.getVehiculo().equals(vehiculo)) {
                return puesto;
            }
        }
        return null;
    }

    public int getMaxI() {
        return maxI;
    }

    public int getMaxJ() {
        return maxJ;
    }

    public Puesto obtenerPuesto(int i, int j) {
        return puestos.get(i * maxJ + j);
<<<<<<< HEAD
    }

    public List<Vehiculo> buscarVehiculosPorPropietario(String propietario) {
        List<Vehiculo> vehiculosEncontrados = new ArrayList<>();
        for (Puesto puesto : puestos) {
            if (puesto.estaOcupado() && puesto.getVehiculo().getPropietario().equalsIgnoreCase(propietario)) {
                vehiculosEncontrados.add(puesto.getVehiculo());
            }
        }
        return vehiculosEncontrados;
    }

    public Vehiculo buscarVehiculoPorPlaca(String placa) {
        for (Puesto puesto : puestos) {
            if (puesto.estaOcupado() && puesto.getVehiculo().getPlaca().equalsIgnoreCase(placa)) {
                return puesto.getVehiculo();
            }
        }
        return null;
    }

    public double calcularTotalGanancias() {
        double total = 0;
        for (Puesto puesto : puestos) {
            total += puesto.getGanancias();
        }
        return total;
    }

    public double calcularGananciasPorTipo(Class<? extends Vehiculo> tipo) {
        double total = 0;
        for (Puesto puesto : puestos) {
            Vehiculo vehiculo = puesto.getVehiculo();
            if (tipo.isInstance(vehiculo)) {
                total += puesto.getGanancias();
            }
        }
        return total;
=======
>>>>>>> f771173a79d8e65e0cd8683133ef27097d9ed186
    }
}
