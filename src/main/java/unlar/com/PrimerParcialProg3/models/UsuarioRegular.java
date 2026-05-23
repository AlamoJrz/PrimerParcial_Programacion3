package unlar.com.PrimerParcialProg3.models;

public class UsuarioRegular extends Usuario {

    public UsuarioRegular(String id, String nombre) {
        super(id, nombre);
    }

    @Override
    public double calcularDescuento() {
        return 0.0; // No hay descuento para usuarios regulares
    }

}
