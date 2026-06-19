package unlar.com.PrimerParcialProg3.Estado;

import unlar.com.PrimerParcialProg3.models.Vehiculo;

public interface EstadoVehiculo {

    void alquilar(Vehiculo vehiculo);

    void enviarAMantenimiento(Vehiculo vehiculo);

    void finalizarViaje(Vehiculo vehiculo);

    void finalizarReparacion(Vehiculo vehiculo);

    String getNombre();
}