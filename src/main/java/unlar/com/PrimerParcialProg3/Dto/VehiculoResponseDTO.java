package unlar.com.PrimerParcialProg3.Dto;

public class VehiculoResponseDTO {

    private String patente;
    private int bateria;
    private double tarifabase;
    private String fase;

    public VehiculoResponseDTO(String patente, int bateria, double tarifabase, String fase) {
        this.patente = patente;
        this.bateria = bateria;
        this.tarifabase = tarifabase;
        this.fase = fase;
    }

    public String getPatente() {
        return patente;
    }

    public int getBateria() {
        return bateria;
    }

    public double getTarifabase() {
        return tarifabase;
    }

    public String getFase() {
        return fase;
    }
}