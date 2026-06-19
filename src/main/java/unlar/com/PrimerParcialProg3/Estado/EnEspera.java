package unlar.com.PrimerParcialProg3.Estado;

import unlar.com.PrimerParcialProg3.models.Vehiculo;

public class EnEspera implements EstadoVehiculo {

    @Override
    public void alquilar(Vehiculo vehiculo) {
        vehiculo.setEstado(new EnViaje());
    }

    @Override
    public void enviarAMantenimiento(Vehiculo vehiculo) {
        vehiculo.setEstado(new EnReparacion());
    }

    @Override
    public void finalizarViaje(Vehiculo vehiculo) {
        throw new IllegalStateException(
            "No se puede finalizar un viaje: el vehículo " + vehiculo.getPatente() + " está En Espera, no En Viaje."
        );
    }

    @Override
    public void finalizarReparacion(Vehiculo vehiculo) {
        throw new IllegalStateException(
            "No se puede finalizar una reparación: el vehículo " + vehiculo.getPatente() + " está En Espera, no En Reparación."
        );
    }

    @Override
    public String getNombre() {
        return "En Espera";
    }
}