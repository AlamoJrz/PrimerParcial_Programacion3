package unlar.com.PrimerParcialProg3.models;

import lombok.Getter;

@Getter
public  abstract class Vehiculo {
    private String patente;
    private int bateria;
    private double tarifabase;

    public Vehiculo(String patente, int bateria, double tarifabase) {
        this.patente = patente;
        this.bateria = bateria;
        this.tarifabase = tarifabase;
    }
    
}
