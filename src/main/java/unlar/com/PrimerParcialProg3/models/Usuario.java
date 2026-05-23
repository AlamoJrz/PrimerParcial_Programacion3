package unlar.com.PrimerParcialProg3.models;

import lombok.Getter;

@Getter

public abstract class Usuario {
    
    
    private String id;
    private String nombre;

    public Usuario(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public abstract double calcularDescuento();


}
