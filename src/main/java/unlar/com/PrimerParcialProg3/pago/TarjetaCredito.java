package unlar.com.PrimerParcialProg3.pago;

public class TarjetaCredito implements ProcesadorPago {
    @Override
    public void cobrar(double monto) {
        System.out.println("Cobro exitoso de $" + monto + " realizado con Tarjeta de Crédito");
    }
    @Override
    public String getNombre() { return "Tarjeta de Crédito"; }
}