/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniquindio.poo;

/**
 *
 * @author Sebastian Román - Yefry Fajardo - Santiago Gordillo
 */
public class Registro {
    private final Puesto puesto;
    private final Vehiculo vehiculo;
    private final LocalDateTime fechaIngreso;
    
    public Registro(Puesto puesto, Vehiculo vehiculo, LocalDateTime fechaIngreso){
        this.puesto = puesto;
        this.vehiculo = vehiculo;
        this.fechaIngreso = fechaIngreso;
    } 
    
    public Puesto getPuesto(){
        return puesto;              //Retorna el puesto relacionado con el registro.  
    }
    public Vehiculo getVehiculo(){
        return vehiculo;             //Retorna el vehiculo relacionado con el registro.
    }

    public LocalDateTime getfechaIngreso(){
        return fechaIngreso;                    //Retorna la fecha y hora del ingreso.
    }
}
