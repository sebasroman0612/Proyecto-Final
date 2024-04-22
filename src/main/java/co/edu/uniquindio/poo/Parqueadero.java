
package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sebastian Román - Yefry Fajardo - Santiago Gordillo
 */
public class Parqueadero {
    private final int numPuestos;    //Numero total de puestos. 
    private List<Puesto> puestos;   //Lista de puestos del parqueadero. 
    private List<Vehiculo> vehiculos;  //Lista de todos los vehiculos que han parqueado.
    private List<Registro> registros;  // Lista de registros de ingresos.

    public Parqueadero(int numPuestos) {
        this.numPuestos = numPuestos;
        this.puestos = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
        this.registros = new ArrayList<>();

        for(int i = 0; i< Math.sqrt(numPuestos);i++){
            for(int j=0;j<Math.sqrt(numPuestos);j++){
                puestos.add(new Puesto(i, j));
            }
        }
    }

    public boolean estaOcupado(int i, int j) {
        return getPuesto(i, j).estaOcupado(); // Verifica si el puesto esta ocupado.
    }

    public Puesto getPuesto(int i, int j) {
        return puestos.stream()
                .filter(puesto -> puesto.getPosicionI() == i && puesto.getPosicionJ() == j)
                .findFirst()
                .orElse(null);      // Retorna el puesto con la posicion especificada.
    }

    public void ocuparPuesto(int i, int j, Vehiculo vehiculo) {
        Puesto puesto = getPuesto(i, j);
        if (puesto != null && !puesto.estaOcupado()) {
            puesto.ocupar(vehiculo);
            vehiculos.add(vehiculo);      // Registra el vehiculo en el parqueadero.
            registros.add(new Registro(puesto, vehiculo, LocalDateTime.now()));    // Agrega registro.
        } else {
            System.out.println("El puesto esta ocupado.");
        }
    }

    public String obtenerPropietario(int i, int j) {
        Puesto puesto = getPuesto(i, j);
        if (puesto != null && puesto.estaOcupado()) {
            return puesto.getVehiculo().getPropietario(); // Retorna el propietario del vehiculo en el puesto.
        } else {
            return "El puesto esta libre.";
        }
    }

    public List<Vehiculo> obtenerVehiculosParqueados() {
        return vehiculos; // Retorna todos los vehiculos parqueados.
    }

    public void libre(int i, int j) {
        Puesto puesto = getPuesto(i, j);
        if (puesto != null && puesto.estaOcupado()) {
            puesto.libre(); // Puesto libre.
        }
    }
}
            
