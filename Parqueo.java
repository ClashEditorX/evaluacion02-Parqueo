import java.util.Scanner;

public class Parqueo {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int motos = 0;
        int autos = 0;
        int camiones = 0;
        int bicicletas = 0;

        double totalRecaudado = 0;
        double mayorCobro = 0;

        String placaMayorCobro = "";

        String continuar;

        do {

            // Seleccionar el tipo de vehículo
            int tipo;

            while (true) {
                System.out.println("\n===== PARQUEO DEL CENTRO =====");
                System.out.println("1. Moto");
                System.out.println("2. Auto");
                System.out.println("3. Camión");
                System.out.println("4. Bicicleta");
                System.out.println("==============================");

                tipo = leerEntero("Seleccione el tipo de vehículo: ");

                if (tipo >= 1 && tipo <= 4) {
                    break;
                }

                System.out.println(
                    "Tipo inválido. Seleccione una opción del 1 al 4."
                );
            }

            // Pedir la placa
            String placa;

            do {
                System.out.print("Ingrese la placa: ");
                placa = sc.nextLine().trim();

                if (placa.isEmpty()) {
                    System.out.println(
                        "Error: la placa no puede estar vacía."
                    );
                }

            } while (placa.isEmpty());

            // Pedir los minutos estacionados
            int minutos;

            do {
                minutos = leerEntero(
                    "Ingrese los minutos estacionados: "
                );

                if (minutos <= 0) {
                    System.out.println(
                        "Error: los minutos deben ser mayores que 0."
                    );
                }

            } while (minutos <= 0);

            // Crear el vehículo correspondiente
            Vehiculo vehiculo;

            switch (tipo) {

                case 1:
                    vehiculo = new Moto(placa, minutos);
                    motos++;
                    break;

                case 2:
                    vehiculo = new Auto(placa, minutos);
                    autos++;
                    break;

                case 3:
                    vehiculo = new Camion(placa, minutos);
                    camiones++;
                    break;

                default:
                    vehiculo = new Bicicleta(placa, minutos);
                    bicicletas++;
                    break;
            }

            // Imprimir el ticket
            vehiculo.imprimirTicket();

            // Obtener el importe de la salida
            double cobro = vehiculo.calcularCobro();

            // Acumular la recaudación
            totalRecaudado += cobro;

            // Identificar al vehículo que pagó más.
            // Las bicicletas no participan en esta comparación.
            if (!(vehiculo instanceof Bicicleta)
                    && cobro > mayorCobro) {

                mayorCobro = cobro;
                placaMayorCobro = vehiculo.getPlaca();
            }

            // Preguntar si desea registrar otro vehículo
            do {
                System.out.print(
                    "\n¿Registrar otro vehículo? (s/n): "
                );

                continuar = sc.nextLine().trim().toLowerCase();

                if (!continuar.equals("s")
                        && !continuar.equals("n")) {

                    System.out.println(
                        "Respuesta inválida. Escriba s o n."
                    );
                }

            } while (!continuar.equals("s")
                    && !continuar.equals("n"));

        } while (continuar.equals("s"));

        // Reporte final del día
        System.out.println("\n===== REPORTE DEL DÍA =====");

        System.out.println("Motos: " + motos);
        System.out.println("Autos: " + autos);
        System.out.println("Camiones: " + camiones);
        System.out.println("Bicicletas: " + bicicletas);

        System.out.printf(
            "Total recaudado: C$%.2f%n",
            totalRecaudado
        );

        if (!placaMayorCobro.isEmpty()) {

            System.out.println(
                "Placa del vehículo que pagó más: "
                + placaMayorCobro
            );

            System.out.printf(
                "Mayor cobro individual: C$%.2f%n",
                mayorCobro
            );

        } else {
            System.out.println(
                "Ningún vehículo generó un cobro positivo."
            );
        }

        System.out.println("===========================");
        System.out.println("Cierre del parqueo.");

        sc.close();
    }

    // Leer un número entero y validar la entrada
    public static int leerEntero(String mensaje) {

        while (true) {

            System.out.print(mensaje);

            try {
                return Integer.parseInt(sc.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.println(
                    "Error: debe ingresar un número entero."
                );
            }
        }
    }
}