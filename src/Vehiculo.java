public class Vehiculo {
    private String placa;

    public Vehiculo(String placa) {
        this.placa = placa;
    }

    public String getUltimoDigito() {
        return placa.substring(placa.length() - 1);
    }

    public String getPlaca() {
        return placa;
    }
}
