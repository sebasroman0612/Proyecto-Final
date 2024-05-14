package co.edu.uniquindio.poo;
/**
 *
 * @author Sebastian Román - Yefry Fajardo - Santiago Gordillo
 */
import java.time.LocalDateTime;

class Puesto {
    private int i;
    private int j;
    private Vehiculo vehiculo;
    private LocalDateTime fechaIngreso;

    public Puesto(int i, int j) {
        this.i = i;
        this.j = j;
        this.vehiculo = null;
        this.fechaIngreso = null;
    }

    public boolean estaOcupado() {
        return vehiculo != null;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void ocupar(Vehiculo vehiculo, LocalDateTime fechaIngreso) {
        if (estaOcupado()) {
            throw new IllegalStateException("El puesto ya está ocupado.");
        }
        this.vehiculo = vehiculo;
        this.fechaIngreso = fechaIngreso;
    }

    public void liberar() {
        if (!estaOcupado()) {
            throw new IllegalStateException("El puesto no está ocupado, no se puede liberar.");
        }
        this.vehiculo = null;
        this.fechaIngreso = null;
    }

    public int getPosicionI() {
        return i;
    }

    public int getPosicionJ() {
        return j;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }
}
