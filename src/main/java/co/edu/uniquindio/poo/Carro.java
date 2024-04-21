
package co.edu.uniquindio.poo;

/**
 *
 * @author Sebastian Román - Yefry Fajardo - Santiago Gordillo
 */
class Carro extends Vehiculo {
    
    public Carro (String placa, String modelo, String propietario){
        super (placa,modelo,propietario);
        
    }

    @Override
    public double getTarifaporHora() { // Metodo para tarifa de carro
        return 3.500;
       
    }
   
    
}
