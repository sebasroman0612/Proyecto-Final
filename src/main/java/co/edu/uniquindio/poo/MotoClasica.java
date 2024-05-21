package co.edu.uniquindio.poo;

/**
 *
 * @author Sebastian Román - Yefry Fajardo - Santiago Gordillo
 */
class MotoClasica extends Moto {
    public MotoClasica(String placa, String modelo, String propietario, double velocidadMaxima) {
        super(placa, modelo, propietario, velocidadMaxima, "clásica"); // Establecer el tipo como "clásica"
    }
}