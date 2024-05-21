package co.edu.uniquindio.poo;

/**
 *
 * @author Sebastian Román - Yefry Fajardo - Santiago Gordillo
 */
class Moto extends Vehiculo {
    private String tipo;
    private double velocidadMaxima; //  variable para la velocidad máxima

    public Moto(String placa, String modelo, String propietario, double velocidadMaxima, String tipo) {
        super(placa, modelo, propietario);
        this.velocidadMaxima = velocidadMaxima;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }
}