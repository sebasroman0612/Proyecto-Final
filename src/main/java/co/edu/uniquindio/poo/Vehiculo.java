
package co.edu.uniquindio.poo;

/**
 *
 * @author Sebastian Román - Yefry Fajardo - Santiago Gordillo
 */
abstract class Vehiculo {
    protected String placa;
    protected String modelo;
    protected String propietario;
    
    public Vehiculo (String placa, String modelo, String propietario){
        this.placa = placa;
        this.modelo = modelo;
        this.propietario = propietario;
    }
    public String getPlaca (){ // Obtenemos la placa del vehiculo
        return placa;
        
    }
    public String getModelo (){ // Obtenemos el modelo del vehiculo
        return modelo;
       
    }
    public String getPropietario (){ // Obtenemos al propietario del vehiculo
        return propietario;
    }
    
    public abstract double getTarifaporHora(); // Tarifa de cada vehiculo
    
}
