package co.edu.uniquindio.poo;

/**
 *
 * @author Sebastian Román - Yefry Fajardo - Santiago Gordillo
 */
class Moto extends Vehiculo {
    private final double velocidadMaxima;
    private final String tipo;

    public Moto(String placa, String modelo, String propietario, double velocidadMaxima, String tipo) {
        super(placa, modelo, propietario);
        this.velocidadMaxima = velocidadMaxima;
        this.tipo = tipo;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public double getTarifaporHora() {
        return 1.000;
    }

    @Override
    public String toString() {
        return super.toString() + ", Velocidad máxima: " + velocidadMaxima + ", Tipo: " + tipo;
    }
}
