package co.edu.uniquindio.poo;

abstract class Vehiculo {
    protected String placa;
    protected String modelo;
    protected String propietario;
    protected double tarifaPorHora;



    

    public Vehiculo(String placa, String modelo, String propietario) {
        if (placa == null) {
            throw new IllegalArgumentException("Placa no puede ser nulo");
        }
        if (modelo == null) {
            throw new IllegalArgumentException("Modelo no puede ser nulo");
        }
        if (propietario == null) {
            throw new IllegalArgumentException("Propietario no puede ser nulo");
        }

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

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public void setTarifaPorHora(double tarifaPorHora) {
        if (tarifaPorHora < 0) {
            throw new IllegalArgumentException("La tarifa por hora no puede ser negativa.");
        }
        this.tarifaPorHora = tarifaPorHora;
    }

    @Override
    public String toString() {
        return "Placa: " + placa + ", Modelo: " + modelo + ", Propietario: " + propietario;
    }
}