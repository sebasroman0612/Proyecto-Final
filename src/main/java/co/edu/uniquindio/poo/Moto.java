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
class Moto extends Vehiculo {
    private final double velocidadMaxima;
    
    public Moto (String modelo, String placa, String propietario, double velocidadMaxima){
        super(modelo,placa,propietario);
        this.velocidadMaxima = velocidadMaxima;
        
    }
    public double getvelocidadMaxima(){
        return velocidadMaxima;
}

    @Override
    public double getTarifaporHora() {
       
        return 1.000;
       
    }
    
    
    
    
}
