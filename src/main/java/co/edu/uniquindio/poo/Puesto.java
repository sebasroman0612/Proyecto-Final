
package co.edu.uniquindio.poo;

/**
 *
 * @author Sebastian Román - Yefry Fajardo - Santiago Gordillo
 */
class Puesto {
    private final int i;
    private final int j;
    private Vehiculo vehiculo; // Vehiculo que ocupa un puesto, es null si esta vacío
    
    public Puesto (int i, int j){
        this.i = i;
        this.j= j;
        this.vehiculo = null; // Puesto inicia sin vehiculo
        
    }
    public boolean puestoOcupado(){ // Indica si el puesto esta ocupado
        return vehiculo!= null;
    }
    
    public Vehiculo getVehiculo (){ // Retorna el vehiculo ubicado en el puesto
        return vehiculo;
    }
    public void libre (){ // Deja el puesto libre, para otro vehiculo
        this.vehiculo = null;
    }
    
    public int getPosicionI(){
        return i;
    }
    public int getPosicionJ(){
        return j;
    }
    

    
}
