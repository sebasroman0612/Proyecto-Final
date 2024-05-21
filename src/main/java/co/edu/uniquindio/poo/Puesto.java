package co.edu.uniquindio.poo;

/**
 *
 * @author Sebastian Román - Yefry Fajardo - Santiago Gordillo
 */
import java.time.LocalDateTime;

public class Puesto {
    private int posicionI;
    private int posicionJ;
    private Vehiculo vehiculo;
    private LocalDateTime fechaIngreso;

    public Puesto(int posicionI, int posicionJ) {
        this.posicionI = posicionI;
        this.posicionJ = posicionJ;
    }

    public int getPosicionI() {
        return posicionI;
    }

    public int getPosicionJ() {
        return posicionJ;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void ocuparPuesto(Vehiculo vehiculo, LocalDateTime fechaIngreso) {
        this.vehiculo = vehiculo;
        this.fechaIngreso = fechaIngreso;
    }

    public void liberarPuesto() {
        this.vehiculo = null;
        this.fechaIngreso = null;
    }

    public boolean estaOcupado() {
        return vehiculo != null;
    }
}
