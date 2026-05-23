package unlar.com.PrimerParcialProg3.models;

public class Monopatin extends Vehiculo {
    private boolean amortiguacionReforzada;

    public Monopatin(String patente, int bateria, double tarifabase, boolean amortiguacionReforzada) {
        super(patente, bateria, tarifabase);
        this.amortiguacionReforzada = amortiguacionReforzada;
    }

    public boolean isAmortiguacionReforzada() {
        return amortiguacionReforzada;
    }

}
