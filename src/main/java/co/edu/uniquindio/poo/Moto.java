
package co.edu.uniquindio.poo;

/**
 *
 * @author Sebastian Román - Yefry Fajardo - Santiago Gordillo
 */
class Moto extends Vehiculo {
    private final double velocidadMaxima;
    
    public Moto (String modelo, String placa, String propietario, double velocidadMaxima){
        super(modelo,placa,propietario);
        this.velocidadMaxima = velocidadMaxima;
        
    }
    public double getvelocidadMaxima(){ // Obtener velocidad de la moto
        return velocidadMaxima;
}

    @Override
    public double getTarifaporHora() { // Obtener el valor a pagar de la moto
       
        return 1.000;
       
    }
    
    
    
    
}
