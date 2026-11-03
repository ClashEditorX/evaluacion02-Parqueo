public class Bicicleta extends Vehiculo {

    public Bicicleta(String placa, int minutos) {
        super(placa, minutos);
    }

    @Override
    public double getTarifaPorHora() {
        return 0.0;
    }

    @Override
    public double calcularCobro() {
        return 0.0;
    }
}