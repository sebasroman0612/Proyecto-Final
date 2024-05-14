package co.edu.uniquindio.poo;
/**
 *
 * @author Sebastian Román - Yefry Fajardo - Santiago Gordillo
 */
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ingrese el número máximo de filas para el parqueadero: ");
            int maxI = scanner.nextInt();
            System.out.print("Ingrese el número máximo de columnas para el parqueadero: ");
            int maxJ = scanner.nextInt();

            System.out.print("Ingrese la tarifa por hora para motos clásicas: ");
            double tarifaMotoClasica = scanner.nextDouble();
            System.out.print("Ingrese la tarifa por hora para motos híbridas: ");
            double tarifaMotoHibrida = scanner.nextDouble();
            System.out.print("Ingrese la tarifa por hora para carros: ");
            double tarifaCarro = scanner.nextDouble();

            Parqueadero parqueadero = new Parqueadero(maxI, maxJ, tarifaMotoClasica, tarifaMotoHibrida, tarifaCarro);

            boolean seguirRegistrando = true;
            while (seguirRegistrando) {
                System.out.println("¿Qué tipo de vehículo desea registrar?");
                System.out.println("1. Carro");
                System.out.println("2. Moto");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                if (opcion == 1) {
                    System.out.print("Ingrese la placa del carro: ");
                    String placaCarro = scanner.nextLine();
                    System.out.print("Ingrese el modelo del carro: ");
                    String modeloCarro = scanner.nextLine();
                    System.out.print("Ingrese el nombre del propietario del carro: ");
                    String propietarioCarro = scanner.nextLine();

                    Carro carro = new Carro(placaCarro, modeloCarro, propietarioCarro);
                    ocuparPuesto(scanner, parqueadero, carro);
                } else if (opcion == 2) {
                    System.out.print("Ingrese la placa de la moto: ");
                    String placaMoto = scanner.nextLine();
                    System.out.print("Ingrese el modelo de la moto: ");
                    String modeloMoto = scanner.nextLine();
                    System.out.print("Ingrese el nombre del propietario de la moto: ");
                    String propietarioMoto = scanner.nextLine();
                    System.out.print("Ingrese la velocidad máxima de la moto: ");
                    double velocidadMaximaMoto = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea
                    
                    System.out.print("Ingrese el tipo de moto (Clásica/Híbrida): ");
                    String tipoMoto = scanner.nextLine();

                    Moto moto = new Moto(placaMoto, modeloMoto, propietarioMoto, velocidadMaximaMoto, tipoMoto);
                    ocuparPuesto(scanner, parqueadero, moto);
                } else {
                    System.out.println("Opción no válida.");
                }

                System.out.println("¿Desea registrar otro vehículo? (Si/No)");
                String respuesta = scanner.next();
                seguirRegistrando = respuesta.equalsIgnoreCase("Si");
            }

            List<Vehiculo> vehiculosParqueados = parqueadero.obtenerVehiculosParqueados();
            System.out.println("Vehículos parqueados:");
            for (Vehiculo vehiculo : vehiculosParqueados) {
                Puesto puesto = parqueadero.obtenerPuestoPorVehiculo(vehiculo);
                LocalDateTime fechaIngreso = puesto.getFechaIngreso();
                System.out.println(vehiculo);
                System.out.println("Posición: (" + puesto.getPosicionI() + ", " + puesto.getPosicionJ() + "), Fecha de ingreso: " + fechaIngreso);
                System.out.println("Tarifa por hora: " + vehiculo.getTarifaporHora());
            }
        }
    }

    private static void ocuparPuesto(Scanner scanner, Parqueadero parqueadero, Vehiculo vehiculo) {
        System.out.println("Ingrese la posición donde desea guardar el vehículo:");
        System.out.print("I: ");
        int i = scanner.nextInt();
        System.out.print("J: ");
        int j = scanner.nextInt();

        if (parqueadero.validarPosicion(i, j)) {
            LocalDateTime fechaIngreso = LocalDateTime.now();
            parqueadero.ocuparPuesto(vehiculo, fechaIngreso, i, j);
            System.out.println("Vehículo registrado con éxito.");
        } else {
            System.out.println("La posición especificada no es válida.");
        }
    }
}
