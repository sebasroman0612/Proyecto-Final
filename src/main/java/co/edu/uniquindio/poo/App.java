package co.edu.uniquindio.poo;
/**
 *
 * @author Sebastian Román - Yefry Fajardo - Santiago Gordillo
 */
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Obtener el número de puestos para el parqueadero
        try (Scanner scanner = new Scanner(System.in)) {
            // Obtener el número de puestos para el parqueadero
            System.out.print("Ingrese el número de puestos para el parqueadero: ");
            int numeroPuestos = scanner.nextInt();
            Parqueadero parqueadero = new Parqueadero(numeroPuestos);
            // Información del carro
            System.out.print("Ingrese la placa del carro: ");
            String placaCarro = scanner.next();
            System.out.print("Ingrese el modelo del carro: ");
            String modeloCarro = scanner.next();
            System.out.print("Ingrese el nombre del propietario del carro: ");
            String propietarioCarro = scanner.next();
            Carro carro = new Carro(placaCarro, modeloCarro, propietarioCarro);
            // Información de la moto clásica
            System.out.print("Ingrese la placa de la moto clásica: ");
            String placaMotoClasica = scanner.next();
            System.out.print("Ingrese el modelo de la moto clásica: ");
            String modeloMotoClasica = scanner.next();
            System.out.print("Ingrese el nombre del propietario de la moto clásica: ");
            String propietarioMotoClasica = scanner.next();
            System.out.print("Ingrese la velocidad máxima de la moto clásica: ");
            double velocidadMaximaClasica = scanner.nextDouble();
            Moto motoClasica = new Moto(placaMotoClasica, modeloMotoClasica, propietarioMotoClasica, velocidadMaximaClasica);
            // Información de la moto híbrida
            System.out.print("Ingrese la placa de la moto híbrida: ");
            String placaMotoHibrida = scanner.next();
            System.out.print("Ingrese el modelo de la moto híbrida: ");
            String modeloMotoHibrida = scanner.next();
            System.out.print("Ingrese el nombre del propietario de la moto híbrida: ");
            String propietarioMotoHibrida = scanner.next();
            System.out.print("Ingrese la velocidad máxima de la moto híbrida: ");
            double velocidadMaximaHibrida = scanner.nextDouble();
            Moto motoHibrida = new Moto(placaMotoHibrida, modeloMotoHibrida, propietarioMotoHibrida, velocidadMaximaHibrida);
            // Ocupa puestos con vehículos
            parqueadero.ocuparPuesto(0, 0, carro); // Ocupa el puesto (0, 0) con carro
            parqueadero.ocuparPuesto(0, 1, motoClasica); // Ocupa el puesto (0, 1) con moto clásica
            // Verifica si el puesto está ocupado
            boolean puestoOcupado = parqueadero.estaOcupado(0, 0);
            System.out.println("El puesto (0, 0) está ocupado: " + puestoOcupado);
            // Obtener el propietario del vehículo en un puesto específico
            String propietario = parqueadero.obtenerPropietario(0, 0);
            System.out.println("El propietario del puesto (0, 0) es: " + propietario);
            // Liberar un puesto antes de ocuparlo de nuevo
            parqueadero.liberarPuesto(0, 0);
            System.out.println("Puesto (0, 0) liberado.");
            // Ocupa el puesto liberado con la moto híbrida
            parqueadero.ocuparPuesto(0, 0, motoHibrida);
            // Obtener todos los vehículos parqueados
            List<Vehiculo> vehiculosParqueados = parqueadero.obtenerVehiculosParqueados();
            System.out.println("Vehículos parqueados:");
            vehiculosParqueados.forEach(vehiculo -> {
                System.out.println("Placa: " + vehiculo.getPlaca() + ", Modelo: " + vehiculo.getModelo() + ", Propietario: " + vehiculo.getPropietario());
            });
            // Cierra el Scanner
        }
    }
}
