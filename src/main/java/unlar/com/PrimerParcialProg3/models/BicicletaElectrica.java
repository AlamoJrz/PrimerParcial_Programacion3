package unlar.com.PrimerParcialProg3.models;

public class BicicletaElectrica extends Vehiculo {
    private int canasto;

    public BicicletaElectrica(String patente, int bateria, double tarifabase, int canasto) {
        super(patente, bateria, tarifabase);
        this.canasto = canasto;
    }

    public int getCanasto() {
        return canasto;
    }



}
