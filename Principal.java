import java.util.Scanner;

/**
 * @author Álvarez Galicia Raúl Alexander
 * Clase Principal que Gestiona un menú de tasas de cambio
 */
public class Principal {
    public static void main(String[] args) {
        ConsultaTasaDeCambio consulta = new ConsultaTasaDeCambio();
        Scanner scanner = new Scanner(System.in);

        System.out.println("**************************** Bienvenido ************************");
        while (true) {
            System.out.println("=== Menú de Tasas de Cambio ===");
            System.out.println("1) Dolar >> Peso Argentino");
            System.out.println("2) Peso Argentino >> Dolar");
            System.out.println("3) Dolar >> Real Brasileiro");
            System.out.println("4) Real Brasileiro >> Dolar");
            System.out.println("5) Dolar >> Peso Mexicano");
            System.out.println("6) Peso Mexicano >> Dolar");
            System.out.println("7) Salir");
            System.out.print("Elige una opción: ");
            int opcion;
            try {
                opcion = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Por favor, ingresa un número válido.");
                scanner.nextLine();
                continue;
            }
            // Salir del menú
            if (opcion == 7) {
                System.out.println("Gracias por usar el programa. ¡Hasta luego!");
                break;
            }
            // Manejo de opciones
            try {
                switch (opcion) {
                    case 1 -> {
                        Moneda dolarApesoArgentino = consulta.tipoDeMoneda("USD", "ARS");
                        System.out.println("Ingresa la cantidad a convertir: ");
                        double cantidad = scanner.nextDouble();
                        double conversion = cantidad * dolarApesoArgentino.getConversionRate("ARS");
                        System.out.printf("El valor de %.2f [USD] equivale a %.2f [ARS].\n", cantidad, conversion);
                    }
                    case 2 -> {
                        Moneda pesoArgentinoAdolar = consulta.tipoDeMoneda("ARS", "USD");
                        System.out.println("Ingresa la cantidad a convertir: ");
                        double cantidad = scanner.nextDouble();
                        double conversion = cantidad * pesoArgentinoAdolar.getConversionRate("USD");
                        System.out.printf("El valor de %.2f [ARS] equivale a %.2f [USD].\n", cantidad, conversion);
                    }
                    case 3 -> {
                        Moneda realBrasileiroAdolar = consulta.tipoDeMoneda("BRL", "USD");
                        System.out.println("Ingresa la cantidad a convertir: ");
                        double cantidad = scanner.nextDouble();
                        double conversion = cantidad * realBrasileiroAdolar.getConversionRate("BRL");
                        System.out.printf("El valor de %.2f [BRL] equivale a %.2f [USD].\n", cantidad, conversion);

                    }
                    default -> System.out.println("Opción no válida. Intenta nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Error al realizar la conversión. Inténtalo nuevamente.");
            }

            System.out.println("--------------------------------------------------");
        }
    }
}
