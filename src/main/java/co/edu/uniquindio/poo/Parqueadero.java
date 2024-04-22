
package co.edu.uniquindio.poo;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sebastian Román - Yefry Fajardo - Santiago Gordillo
 */
class Parqueadero {
    
    private final List<Puesto> puestos; // Lista de puestos del parqueadero.
    private final List<Vehiculo> vehiculos; // Lista de todos los vehículos que han parqueado.
    private final List<Registro> registros; // Lista de registros de ingresos.

    public Parqueadero(int numPuestos) {
        
        this.puestos = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
        this.registros = new ArrayList<>();

        // Inicializar la lista de puestos con posiciones (i, j) únicas.
        for (int i = 0; i < Math.sqrt(numPuestos); i++) {
            for (int j = 0; j < Math.sqrt(numPuestos); j++) {
                puestos.add(new Puesto(i, j));
            }
        }
    }

    public boolean estaOcupado(int i, int j) {
        return getPuesto(i, j).estaOcupado(); // Verifica si el puesto está ocupado.
    }

    public Puesto getPuesto(int i, int j) {
        return puestos.stream()
                .filter(puesto -> puesto.getPosicionI() == i && puesto.getPosicionJ() == j)
                .findFirst()
                .orElse(null); // Retorna el puesto con la posición especificada.
    }

    public void estaOcupado(int i, int j, Vehiculo vehiculo) {
    Puesto puesto = getPuesto(i, j);
    if (puesto != null && !puesto.estaOcupado()) {
        puesto.ocupar(vehiculo);
        vehiculos.add(vehiculo); // Registrar el vehículo en el parqueadero.
        registros.add(new Registro(puesto, vehiculo, LocalDateTime.now())); // Agregar registro.
    } else {
        System.out.println("El puesto en la posición (" + i + "," + j + ") está ocupado o no existe.");
    }
}


    public String obtenerPropietario(int i, int j) {
        Puesto puesto = getPuesto(i, j);
        if (puesto != null && puesto.estaOcupado()) {
            return puesto.getVehiculo().getPropietario(); // Retorna el propietario del vehículo en el puesto.
        } else {
            return "No hay vehículo en el puesto.";
        }
    }

    public List<Vehiculo> obtenerVehiculosParqueados() {
        return vehiculos; // Retorna todos los vehículos parqueados.
    }

    public void liberarPuesto(int i, int j) {
        Puesto puesto = getPuesto(i, j);
        if (puesto != null && puesto.estaOcupado()) {
            puesto.libre(); // Liberar el puesto.
        }
    }
}
            
