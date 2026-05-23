package unlar.com.PrimerParcialProg3.pago;

import org.springframework.stereotype.Component;

@Component
public class FabricaPago {
    public ProcesadorPago crear(String tipo) {
        if (tipo.equalsIgnoreCase("TARJETA")) {
            return new TarjetaCredito();
        } else if (tipo.equalsIgnoreCase("BILLETERA")) {
            return new BilleteraVirtual();
        }
        throw new IllegalArgumentException("Método de pago desconocido: " + tipo);
    }
}