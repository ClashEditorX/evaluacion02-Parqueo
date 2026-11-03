public abstract class Vehiculo {

    private String placa;
    private int minutos;

    // Constructor
    public Vehiculo(String placa, int minutos) {
        this.placa = placa;
        this.minutos = minutos;
    }

    // Getters
    public String getPlaca() {
        return placa;
    }

    public int getMinutos() {
        return minutos;
    }

    // Calcular las horas que se deben cobrar
    public int calcularHoras() {

        if (minutos <= 15) {
            return 0;
        }

        return (int) Math.ceil(minutos / 60.0);
    }

    // Método abstracto: cada vehículo define su tarifa
    public abstract double getTarifaPorHora();

    // Calcular el cobro
    public double calcularCobro() {
        return calcularHoras() * getTarifaPorHora();
    }

    // Imprimir el ticket
    public void imprimirTicket() {

        System.out.println("\n===== TICKET DE PARQUEO =====");
        System.out.println("Tipo: " + getClass().getSimpleName());
        System.out.println("Placa: " + placa);
        System.out.println("Minutos estacionado: " + minutos);
        System.out.println("Horas cobradas: " + calcularHoras());

        System.out.printf(
            "Tarifa por hora: C$%.2f%n",
            getTarifaPorHora()
        );

        System.out.printf(
            "Total a pagar: C$%.2f%n",
            calcularCobro()
        );

        System.out.println("=============================");
    }
}