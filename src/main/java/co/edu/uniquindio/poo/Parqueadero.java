package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
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
        Puesto puesto = puestos.get(i * maxJ + j);
        if (puesto.estaOcupado()) {
            System.out.println("El puesto en la posición (" + i + "," + j + ") ya está ocupado.");
            return;
        }
        puesto.ocupar(vehiculo, fechaIngreso);
        vehiculo.setTarifaporHora(obtenerTarifaPorTipo(vehiculo)); // Guardar la tarifa correspondiente al vehículo
        vehiculos.add(vehiculo);
        System.out.println("Vehículo registrado con éxito.");
    }

    private double obtenerTarifaPorTipo(Vehiculo vehiculo) {
        if (vehiculo instanceof Moto) {
            Moto moto = (Moto) vehiculo;
            if (moto.getTipo().equalsIgnoreCase("Clásica")) {
                return tarifaMotoClasica;
            } else if (moto.getTipo().equalsIgnoreCase("Híbrida")) {
                return tarifaMotoHibrida;
            }
        } else if (vehiculo instanceof Carro) {
            return tarifaCarro;
        }
        return 0.0; // Tarifa por defecto si el tipo de vehículo no coincide
    }


    public void liberarPuesto(int i, int j) {
        if (!validarPosicion(i, j)) {
            System.out.println("La posición especificada no es válida.");
            return;
        }
        Puesto puesto = puestos.get(i * maxJ + j);
        if (!puesto.estaOcupado()) {
            System.out.println("El puesto en la posición (" + i + "," + j + ") no está ocupado.");
            return;
        }
        puesto.liberar();
        System.out.println("Puesto en la posición (" + i + "," + j + ") liberado.");
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

    public String obtenerPropietario(int i, int j) {
        if (!validarPosicion(i, j)) {
            return "Posición no válida.";
        }
        Puesto puesto = puestos.get(i * maxJ + j);
        if (puesto == null || !puesto.estaOcupado()) {
            return "No hay vehículo en el puesto.";
        }
        return puesto.getVehiculo().getPropietario();
    }
}
