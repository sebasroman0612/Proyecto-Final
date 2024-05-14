package co.edu.uniquindio.poo;

/**
 * Clase que representa un vehículo de tipo Carro.
 */
class Carro extends Vehiculo {

    public Carro(String placa, String modelo, String propietario) {
        super(placa, modelo, propietario);
    }

    @Override
    public double getTarifaporHora() {
        return 3.500;
    }
}
