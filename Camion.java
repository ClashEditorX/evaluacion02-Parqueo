public class Camion extends Vehiculo {

    private static final double RECARGO = 50.0;

    public Camion(String placa, int minutos) {
        super(placa, minutos);
    }

    @Override
    public double getTarifaPorHora() {
        return 35.0;
    }

    @Override
    public double calcularCobro() {

        double cobro = super.calcularCobro();

        if (calcularHoras() >= 1) {
            cobro += RECARGO;
        }

        return cobro;
    }
}