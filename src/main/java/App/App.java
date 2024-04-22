package co.edu.uniquindio.poo;
import java.util.List;

public class App {
    public static void main(String[] args) { // Crear nuevos vehiculos
        Parqueadero parqueadero = new Parqueadero(4);
        Carro carro = new Carro("KMO477", "Spark", "Sebastian Villalobos");
        Moto motoClasica = new Moto("WYZ532", "Yamaha", "Sofia Aranzazu", 150, "Clasica");
        Moto motoHibrida = new Moto("DAF587", "Honda", "Carl Benson", 100, "Hibrida");

        parqueadero.estaOcupado(0, 0, carro); // Ocupa el puesto (0,0) en carro
        parqueadero.estaOcupado(0, 1, motoClasica); // Ocupa puesto (0,1) en moto clasica

        // Verifica si el puesto esta ocupado
        boolean puestoOcupado = parqueadero.estaOcupado(0, 0);
        System.out.println("El puesto (0,0) está ocupado: " + puestoOcupado);

        // Obtener el propietario de un vehiculo en un puesto especifico
        String propietario = parqueadero.obtenerPropietario(0, 0);
        System.out.println("El propietario del puesto (0,0): " + propietario);

        // Intentar ubicar vehiculo en puesto ocupado
        // Debe fallar porque el puesto esta ocupado
        parqueadero.estaOcupado(0, 0, motoHibrida);

        // Libera un puesto en el parqueadero
        parqueadero.liberarPuesto(0, 0);
        System.out.println("Puesto (0,0) liberado");

        parqueadero.estaOcupado(0, 0, motoHibrida); // Ubicar vehiculo en puesto libre

        // Obtener todos los vehiculos parqueados
        List<Vehiculo> vehiculosParqueados = parqueadero.obtenerVehiculosParqueados();
        System.out.println("Vehiculos parqueados: ");
        vehiculosParqueados.forEach(vehiculo -> {
            System.out.println("Placa: " + vehiculo.getPlaca() + ", Modelo: " + vehiculo.getModelo() + ", Propietario: " + vehiculo.getPropietario());
        });
    }
}

