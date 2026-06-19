package unlar.com.PrimerParcialProg3.Estado;

import unlar.com.PrimerParcialProg3.models.Vehiculo;

public class EnReparacion implements EstadoVehiculo {

    @Override
    public void alquilar(Vehiculo vehiculo) {
        throw new IllegalStateException(
            "No se puede alquilar: el vehículo " + vehiculo.getPatente() + " está En Reparación."
        );
    }

    @Override
    public void enviarAMantenimiento(Vehiculo vehiculo) {
        throw new IllegalStateException(
            "El vehículo " + vehiculo.getPatente() + " ya está En Reparación."
        );
    }

    @Override
    public void finalizarViaje(Vehiculo vehiculo) {
        throw new IllegalStateException(
            "No se puede finalizar un viaje: el vehículo " + vehiculo.getPatente() + " está En Reparación, no En Viaje."
        );
    }

    @Override
    public void finalizarReparacion(Vehiculo vehiculo) {
        vehiculo.setEstado(new EnEspera());
    }

    @Override
    public String getNombre() {
        return "En Reparación";
    }
}