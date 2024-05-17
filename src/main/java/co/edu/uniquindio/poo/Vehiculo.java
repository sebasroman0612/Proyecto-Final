package co.edu.uniquindio.poo;

/**
 *
 * @author Sebastian Román - Yefry Fajardo - Santiago Gordillo
 */

abstract class Vehiculo {
    protected String placa;
    protected String modelo;
    protected String propietario;
    protected double tarifaPorHora;

    public Vehiculo(String placa, String modelo, String propietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.propietario = propietario;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPropietario() {
        return propietario;
    }

    public double getTarifaPorHora() {
        return tarifaPorHora;
    }

    public void setTarifaPorHora(double tarifaPorHora) {
        this.tarifaPorHora = tarifaPorHora;
    }

    @Override
    public String toString() {
        return "Placa: " + placa + ", Modelo: " + modelo + ", Propietario: " + propietario;
    }
}

