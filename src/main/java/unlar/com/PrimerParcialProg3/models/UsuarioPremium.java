package unlar.com.PrimerParcialProg3.models;

public class UsuarioPremium extends Usuario {
    private double descuento;

    public UsuarioPremium(String id, String nombre, double descuento) {
        super(id, nombre);
        this.descuento = descuento;
    }

    @Override
    public double calcularDescuento() {
        return descuento; // Retorna el descuento específico para usuarios premium
    }


}
