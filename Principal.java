import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConsultaTasaDeCambio consulta = new ConsultaTasaDeCambio();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido");
        consulta.tipoDeMoneda("cdc");
    }
}
