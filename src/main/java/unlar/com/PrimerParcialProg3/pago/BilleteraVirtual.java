package unlar.com.PrimerParcialProg3.pago;

public class BilleteraVirtual implements ProcesadorPago {
    @Override
    public void cobrar(double monto) {
        System.out.println("Cobro exitoso de $" + monto + " realizado con Billetera Virtual");
    }
    @Override
    public String getNombre() { return "Billetera Virtual"; }
}