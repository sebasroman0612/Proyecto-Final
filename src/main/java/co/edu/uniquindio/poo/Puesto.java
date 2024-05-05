package co.edu.uniquindio.poo;
/**
 *
 * @author Sebastian Román - Yefry Fajardo - Santiago Gordillo
 */
class Puesto {
    private int i;
    private int j;
    private Vehiculo vehiculo; // El vehículo que ocupa el puesto.

    public Puesto(int i, int j) {
        this.i = i;
        this.j = j;
        this.vehiculo = null; // El puesto empieza vacío.
    }

    public boolean estaOcupado() {
        return vehiculo != null; // El puesto está ocupado si tiene un vehículo.
    }

    public Vehiculo getVehiculo() {
        return vehiculo; // Retorna el vehículo que ocupa el puesto.
    }

    public void ocupar(Vehiculo vehiculo) {
        this.vehiculo = vehiculo; // Ocupa el puesto con un vehículo.
    }

    public void liberar() {
        this.vehiculo = null; // Libera el puesto.
    }

    public int getPosicionI() {
        return i;
    }

    public int getPosicionJ() {
        return j;
    }
}

