package co.edu.uniquindio.poo;

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

            boolean continuar = true;
            while (continuar) {
                mostrarMenu();
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

<<<<<<< HEAD
                switch (opcion) {
                    case 1:
                        registrarVehiculo(scanner, parqueadero);
                        break;
                    case 2:
                        mostrarEstadoParqueadero(parqueadero);
                        break;
                    case 3:
                        liberarPuesto(scanner, parqueadero);
                        break;
                    case 4:
                        imprimirVehiculosParqueados(parqueadero);
                        break;
                    case 5:
                        buscarVehiculo(scanner, parqueadero);
                        break;
                    case 6:
                        generarReporteGanancias(parqueadero);
                        break;
                    case 7:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opción no válida.");
=======
                if (opcion == 1) {
                    registrarCarro(scanner, parqueadero);
                } else if (opcion == 2) {
                    registrarMoto(scanner, parqueadero);
                } else {
                    System.out.println("Opción no válida.");
>>>>>>> f771173a79d8e65e0cd8683133ef27097d9ed186
                }

                if (continuar) {
                    System.out.print("¿Desea regresar al menú principal? (Si/No): ");
                    String respuesta = scanner.next();
                    continuar = respuesta.equalsIgnoreCase("Si");
                }
            }
        }
    }

<<<<<<< HEAD
    private static void mostrarMenu() {
        System.out.println("\n¿Qué desea realizar?");
        System.out.println("1. Registrar un nuevo vehículo");
        System.out.println("2. Ver el estado del parqueadero");
        System.out.println("3. Liberar un puesto");
        System.out.println("4. Imprimir la lista de vehículos parqueados");
        System.out.println("5. Buscar un vehículo registrado");
        System.out.println("6. Generar reporte de ganancias");
        System.out.println("7. Finalizar el programa");
        System.out.print("Seleccione una opción: ");
    }

    private static void registrarVehiculo(Scanner scanner, Parqueadero parqueadero) {
        System.out.println("¿Qué tipo de vehículo desea registrar?");
        System.out.println("1. Carro");
        System.out.println("2. Moto");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        if (opcion == 1) {
            registrarCarro(scanner, parqueadero);
        } else if (opcion == 2) {
            registrarMoto(scanner, parqueadero);
        } else {
            System.out.println("Opción no válida.");
        }
    }

    private static void registrarCarro(Scanner scanner, Parqueadero parqueadero) {
        System.out.print("Ingrese la placa del carro: ");
        String placaCarro = scanner.nextLine();
        System.out.print("Ingrese el modelo del carro: ");
        String modeloCarro = scanner.nextLine();
        System.out.print("Ingrese el nombre del propietario del carro: ");
        String propietarioCarro = scanner.nextLine();

        Carro carro = new Carro(placaCarro, modeloCarro, propietarioCarro);
        ocuparPuesto(scanner, parqueadero, carro);
    }

    private static void registrarMoto(Scanner scanner, Parqueadero parqueadero) {
        System.out.println("¿Qué tipo de moto desea registrar?");
        System.out.println("1. Moto Clásica");
        System.out.println("2. Moto Híbrida");
        System.out.print("Seleccione una opción: ");
        int opcionMoto = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Ingrese la placa de la moto: ");
        String placaMoto = scanner.nextLine();
        System.out.print("Ingrese el modelo de la moto: ");
        String modeloMoto = scanner.nextLine();
        System.out.print("Ingrese el nombre del propietario de la moto: ");
        String propietarioMoto = scanner.nextLine();
        System.out.print("Ingrese la velocidad máxima de la moto: ");
        double velocidadMaximaMoto = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        if (opcionMoto == 1) {
            MotoClasica motoClasica = new MotoClasica(placaMoto, modeloMoto, propietarioMoto, velocidadMaximaMoto);
            ocuparPuesto(scanner, parqueadero, motoClasica);
        } else if (opcionMoto == 2) {
            MotoHibrida motoHibrida = new MotoHibrida(placaMoto, modeloMoto, propietarioMoto, velocidadMaximaMoto);
            ocuparPuesto(scanner, parqueadero, motoHibrida);
        } else {
            System.out.println("Opción no válida.");
=======
            mostrarEstadoParqueadero(parqueadero);

            System.out.println("¿Desea liberar un puesto? (Si/No)");
            String respuesta = scanner.next();
            if (respuesta.equalsIgnoreCase("Si")) {
                System.out.println("Ingrese la posición del puesto que desea liberar:");
                System.out.print("I: ");
                int i = scanner.nextInt();
                System.out.print("J: ");
                int j = scanner.nextInt();

                double costo = parqueadero.liberarPuesto(i, j);
                if (costo >= 0) {
                    System.out.println("El costo del tiempo de estacionamiento es: $" + costo);
                }
            }

            List<Vehiculo> vehiculosParqueados = parqueadero.obtenerVehiculosParqueados();
            System.out.println("Vehículos parqueados:");
            for (Vehiculo vehiculo : vehiculosParqueados) {
                Puesto puesto = parqueadero.obtenerPuestoPorVehiculo(vehiculo);
                LocalDateTime fechaIngreso = puesto.getFechaIngreso();
                System.out.println(vehiculo);
                if (vehiculo instanceof Moto) {
                    Moto moto = (Moto) vehiculo;
                    System.out.println("Velocidad máxima: " + moto.getVelocidadMaxima());
                }
                System.out.println("Posición: (" + puesto.getPosicionI() + ", " + puesto.getPosicionJ() + "), Fecha de ingreso: " + fechaIngreso);
                System.out.println("Tarifa por hora: " + vehiculo.getTarifaPorHora());
            }
>>>>>>> f771173a79d8e65e0cd8683133ef27097d9ed186
        }
    }

    private static void registrarCarro(Scanner scanner, Parqueadero parqueadero) {
        System.out.print("Ingrese la placa del carro: ");
        String placaCarro = scanner.next();
        System.out.print("Ingrese el modelo del carro: ");
        String modeloCarro = scanner.next();
        System.out.print("Ingrese el nombre del propietario del carro: ");
        String propietarioCarro = scanner.next();

        Carro carro = new Carro(placaCarro, modeloCarro, propietarioCarro);
        ocuparPuesto(scanner, parqueadero, carro);
    }

    private static void registrarMoto(Scanner scanner, Parqueadero parqueadero) {
        System.out.println("¿Qué tipo de moto desea registrar?");
        System.out.println("1. Moto Clásica");
        System.out.println("2. Moto Híbrida");
        System.out.print("Seleccione una opción: ");
        int opcionMoto = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Ingrese la placa de la moto: ");
        String placaMoto = scanner.nextLine();
        System.out.print("Ingrese el modelo de la moto: ");
        String modeloMoto = scanner.nextLine();
        System.out.print("Ingrese el nombre del propietario de la moto: ");
        String propietarioMoto = scanner.nextLine();
        System.out.print("Ingrese la velocidad máxima de la moto: ");
        double velocidadMaximaMoto = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        if (opcionMoto == 1) {
            MotoClasica motoClasica = new MotoClasica(placaMoto, modeloMoto, propietarioMoto, velocidadMaximaMoto);
            ocuparPuesto(scanner, parqueadero, motoClasica);
        } else if (opcionMoto == 2) {
            MotoHibrida motoHibrida = new MotoHibrida(placaMoto, modeloMoto, propietarioMoto, velocidadMaximaMoto);
            ocuparPuesto(scanner, parqueadero, motoHibrida);
        } else {
            System.out.println("Opción no válida.");
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
<<<<<<< HEAD
=======
            // Establecer la tarifa por hora en el objeto de la moto
>>>>>>> f771173a79d8e65e0cd8683133ef27097d9ed186
            if (vehiculo instanceof Moto) {
                Moto moto = (Moto) vehiculo;
                vehiculo.setTarifaPorHora(parqueadero.obtenerTarifaPorTipo(moto)); // Establecer la tarifa correspondiente
            }
            System.out.println("Vehículo registrado con éxito.");
        } else {
            System.out.println("La posición especificada no es válida.");
        }
    }

<<<<<<< HEAD
    private static void liberarPuesto(Scanner scanner, Parqueadero parqueadero) {
        System.out.println("Ingrese la posición del puesto que desea liberar:");
        System.out.print("I: ");
        int i = scanner.nextInt();
        System.out.print("J: ");
        int j = scanner.nextInt();

        double costo = parqueadero.liberarPuesto(i, j);
        if (costo >= 0) {
            System.out.println("El costo del tiempo de estacionamiento es: $" + costo);
        }
    }

    private static void imprimirVehiculosParqueados(Parqueadero parqueadero) {
        List<Vehiculo> vehiculosParqueados = parqueadero.obtenerVehiculosParqueados();
        System.out.println("Vehículos parqueados:");
        for (Vehiculo vehiculo : vehiculosParqueados) {
            Puesto puesto = parqueadero.obtenerPuestoPorVehiculo(vehiculo);
            LocalDateTime fechaIngreso = puesto.getFechaIngreso();
            System.out.println(vehiculo);
            if (vehiculo instanceof Moto) {
                Moto moto = (Moto) vehiculo;
                System.out.println("Velocidad máxima: " + moto.getVelocidadMaxima());
            }
            System.out.println("Posición: (" + puesto.getPosicionI() + ", " + puesto.getPosicionJ() + "), Fecha de ingreso: " + fechaIngreso);
            System.out.println("Tarifa por hora: " + vehiculo.getTarifaPorHora());
        }
    }

=======
>>>>>>> f771173a79d8e65e0cd8683133ef27097d9ed186
    private static void mostrarEstadoParqueadero(Parqueadero parqueadero) {
        System.out.println("Estado del parqueadero:");
        for (int i = 0; i < parqueadero.getMaxI(); i++) {
            for (int j = 0; j < parqueadero.getMaxJ(); j++) {
                Puesto puesto = parqueadero.obtenerPuesto(i, j);
                if (puesto.estaOcupado()) {
                    Vehiculo vehiculo = puesto.getVehiculo();
                    if (vehiculo instanceof Carro) {
                        System.out.print("C ");
                    } else if (vehiculo instanceof MotoClasica) {
                        System.out.print("MC ");
                    } else if (vehiculo instanceof MotoHibrida) {
                        System.out.print("MH ");
                    }
                } else {
                    System.out.print("L ");
                }
            }
            System.out.println();
        }
    }
<<<<<<< HEAD

    private static void buscarVehiculo(Scanner scanner, Parqueadero parqueadero) {
        System.out.println("¿Cómo desea buscar el vehículo?");
        System.out.println("1. Búsqueda por propietario");
        System.out.println("2. Búsqueda por placa");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el nombre del propietario: ");
                String propietario = scanner.nextLine();
                List<Vehiculo> vehiculosPorPropietario = parqueadero.buscarVehiculosPorPropietario(propietario);
                if (vehiculosPorPropietario.isEmpty()) {
                    System.out.println("No se encontraron vehículos para el propietario especificado.");
                } else {
                    System.out.println("Vehículos encontrados:");
                    for (Vehiculo vehiculo : vehiculosPorPropietario) {
                        System.out.println(vehiculo);
                    }
                }
                break;
            case 2:
                System.out.print("Ingrese la placa del vehículo: ");
                String placa = scanner.nextLine();
                Vehiculo vehiculo = parqueadero.buscarVehiculoPorPlaca(placa);
                if (vehiculo == null) {
                    System.out.println("No se encontró un vehículo con la placa especificada.");
                } else {
                    System.out.println("Vehículo encontrado: " + vehiculo);
                }
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    private static void generarReporteGanancias(Parqueadero parqueadero) {
        double totalGanado = parqueadero.calcularTotalGanancias();
        double totalGanadoMotosClasicas = parqueadero.calcularGananciasPorTipo(MotoClasica.class);
        double totalGanadoMotosHibridas = parqueadero.calcularGananciasPorTipo(MotoHibrida.class);
        double totalGanadoCarros = parqueadero.calcularGananciasPorTipo(Carro.class);

        System.out.println("Reporte de ganancias del parqueadero:");
        System.out.println("Total ganado: $" + totalGanado);
        System.out.println("Total ganado por motos clásicas: $" + totalGanadoMotosClasicas);
        System.out.println("Total ganado por motos híbridas: $" + totalGanadoMotosHibridas);
        System.out.println("Total ganado por carros: $" + totalGanadoCarros);
    }
=======
>>>>>>> f771173a79d8e65e0cd8683133ef27097d9ed186
}
