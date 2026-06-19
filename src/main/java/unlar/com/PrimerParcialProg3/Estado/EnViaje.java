package unlar.com.PrimerParcialProg3.Estado;

import unlar.com.PrimerParcialProg3.models.Vehiculo;

public class EnViaje implements EstadoVehiculo {

    @Override
    public void alquilar(Vehiculo vehiculo) {
        throw new IllegalStateException(
            "No se puede alquilar: el vehículo " + vehiculo.getPatente() + " ya está En Viaje."
        );
    }

    @Override
    public void enviarAMantenimiento(Vehiculo vehiculo) {
        throw new IllegalStateException(
            "No se puede enviar a mantenimiento: el vehículo " + vehiculo.getPatente() + " está En Viaje. Debe finalizar el viaje primero."
        );
    }

    @Override
    public void finalizarViaje(Vehiculo vehiculo) {
        vehiculo.setEstado(new EnEspera());
    }

    @Override
    public void finalizarReparacion(Vehiculo vehiculo) {
        throw new IllegalStateException(
            "No se puede finalizar una reparación: el vehículo " + vehiculo.getPatente() + " está En Viaje, no En Reparación."
        );
    }

    @Override
    public String getNombre() {
        return "En Viaje";
    }
}