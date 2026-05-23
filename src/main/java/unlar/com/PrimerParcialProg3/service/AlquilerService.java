package unlar.com.PrimerParcialProg3.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import unlar.com.PrimerParcialProg3.Estacion.EstacionAnclaje;
import unlar.com.PrimerParcialProg3.models.*;
import unlar.com.PrimerParcialProg3.pago.FabricaPago;
import unlar.com.PrimerParcialProg3.pago.ProcesadorPago;

@Service
public class AlquilerService {
    private List<Usuario> usuarios = new ArrayList<>();
    private EstacionAnclaje estacion;
    private final FabricaPago fabricaPago;

    public AlquilerService(FabricaPago fabricaPago) {
        this.fabricaPago = fabricaPago;
        cargarDatos();
    }

    private void cargarDatos() {
        usuarios.add(new UsuarioRegular("U1", "Ana Gomez"));
        usuarios.add(new UsuarioPremium("U2", "Carlos Lopez", 0.15));
        estacion = new EstacionAnclaje("Estacion Centro");
        estacion.agregarVehiculo(new Monopatin("ABC123", 80, 500.0, true));
        estacion.agregarVehiculo(new Monopatin("DEF456", 10, 500.0, false));
        estacion.agregarVehiculo(new BicicletaElectrica("GHI789", 60, 450.0, 5000));
    }

    public String desbloquear(String idUsuario, String patente, String metodoPago) {
        Usuario usuario = null;
        for (Usuario u : usuarios) {
            if (u.getId().equals(idUsuario)) { usuario = u; break; }
        }
        if (usuario == null) throw new RuntimeException("Usuario no encontrado");

        Vehiculo vehiculo = estacion.buscarPorPatente(patente);
        if (vehiculo == null) throw new RuntimeException("Vehículo No Encontrado");

        if (vehiculo.getBateria() < 15) throw new RuntimeException("Batería Insuficiente");

        double tarifa = vehiculo.getTarifabase();
        double total  = tarifa - (tarifa * usuario.calcularDescuento());

        ProcesadorPago procesador = fabricaPago.crear(metodoPago);
        procesador.cobrar(total);

        return "Rodado desbloqueado: " + vehiculo.getPatente()
             + " | Monto cobrado: $" + total
             + " | Método: " + procesador.getNombre();
    }
}