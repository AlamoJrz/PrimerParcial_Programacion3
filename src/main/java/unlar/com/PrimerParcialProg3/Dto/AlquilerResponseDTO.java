package unlar.com.PrimerParcialProg3.Dto;

public class AlquilerResponseDTO {

    private String patente;
    private double costoFinal;
    private int tiempoTranscurridoMinutos;
    private String fase;

    public AlquilerResponseDTO(String patente, double costoFinal, int tiempoTranscurridoMinutos, String fase) {
        this.patente = patente;
        this.costoFinal = costoFinal;
        this.tiempoTranscurridoMinutos = tiempoTranscurridoMinutos;
        this.fase = fase;
    }

    public String getPatente() {
        return patente;
    }

    public double getCostoFinal() {
        return costoFinal;
    }

    public int getTiempoTranscurridoMinutos() {
        return tiempoTranscurridoMinutos;
    }

    public String getFase() {
        return fase;
    }
}