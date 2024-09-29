public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Vehiculo vehiculo = new Vehiculo("PJA1234");
        Predictor predictor = new Predictor();
        boolean puedeCircular = predictor.puedeCircular(vehiculo, "2024-09-28", "08:00");
        System.out.println("Cicula: " + (puedeCircular ? "Sí" : "No"));
    }
}