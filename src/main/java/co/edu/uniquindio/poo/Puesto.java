
package co.edu.uniquindio.poo;
/**
 *
 * @author Sebastian Román - Yefry Fajardo - Santiago Gordillo
 */

class Puesto {
    private final int i;
    private final int j;
    private Vehiculo vehiculo; // Vehículo que ocupa un puesto, es null si está vacío

    public Puesto(int i, int j) {
        this.i = i;
        this.j = j;
        this.vehiculo = null; // Puesto inicia sin vehículo
    }

    public boolean estaOcupado() { // Indica si el puesto está ocupado
        return vehiculo != null;
    }

    public Vehiculo getVehiculo() { // Retorna el vehículo ubicado en el puesto
        return vehiculo;
    }

    public void ocupar(Vehiculo vehiculo) { // Ubica un vehículo en puesto disponible
        this.vehiculo = vehiculo;
    }

    public void libre() { // Deja el puesto libre, para otro vehículo
        this.vehiculo = null;
    }

    public int getPosicionI() {
        return i;
    }

    public int getPosicionJ() {
        return j;
    }
}
