package unlar.com.PrimerParcialProg3.Dto;

import java.time.LocalDateTime;

public class ErrorResponseDTO {

    private String mensaje;
    private int codigoEstado;
    private LocalDateTime timestamp;

    public ErrorResponseDTO(String mensaje, int codigoEstado) {
        this.mensaje = mensaje;
        this.codigoEstado = codigoEstado;
        this.timestamp = LocalDateTime.now();
    }

    public String getMensaje() {
        return mensaje;
    }

    public int getCodigoEstado() {
        return codigoEstado;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}