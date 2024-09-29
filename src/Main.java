import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario la placa
        System.out.println("Ingrese el número de placa del vehículo:");
        String placa = scanner.nextLine();

        // Pedir al usuario la fecha
        System.out.println("Ingrese la fecha (formato: yyyy-MM-dd):");
        String fecha = scanner.nextLine();

        // Pedir al usuario la hora
        System.out.println("Ingrese la hora (formato: HH:mm):");
        String hora = scanner.nextLine();

        Vehiculo vehiculo = new Vehiculo(placa);
        Predictor predictor = new Predictor();

        // boolean puedeCircular = predictor.puedeCircular(vehiculo, "2024-09-28", "08:00");
        boolean puedeCircular = predictor.puedeCircular(vehiculo, fecha, hora);
        System.out.println("Cicula: " + (puedeCircular ? "Sí" : "No"));
    }
}