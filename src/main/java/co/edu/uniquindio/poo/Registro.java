
package co.edu.uniquindio.poo;

import java.time.LocalDateTime;

/**
 *
 * @author Sebastian Román - Yefry Fajardo - Santiago Gordillo
 */
public class Registro {
    private final Puesto puesto;
    private final Vehiculo vehiculo;
    private final LocalDateTime fechaIngreso;
    
    public Registro(Puesto puesto, Vehiculo vehiculo, LocalDateTime fechaIngreso) {
        this.puesto = puesto;
        this.vehiculo = vehiculo;
        this.fechaIngreso = fechaIngreso;
    }
    
    public Puesto getPuesto() {
        return puesto; // Retorna el puesto relacionado con el registro.
    }
    
    public Vehiculo getVehiculo() {
        return vehiculo; // Retorna el vehículo relacionado con el registro.
    }

    public LocalDateTime getFechaIngreso() { // Corregida capitalización
        return fechaIngreso; // Retorna la fecha y hora del ingreso.
    }
}
