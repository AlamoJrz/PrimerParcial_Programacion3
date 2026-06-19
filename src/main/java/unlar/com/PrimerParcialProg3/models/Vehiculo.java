package unlar.com.PrimerParcialProg3.models;

import lombok.Getter;
import unlar.com.PrimerParcialProg3.Estado.EstadoVehiculo;
import unlar.com.PrimerParcialProg3.Estado.EnEspera;

@Getter
public abstract class Vehiculo implements Comparable<Vehiculo> {
    private String patente;
    private int bateria;
    private double tarifabase;
    private EstadoVehiculo estado;

    public Vehiculo(String patente, int bateria, double tarifabase) {
        this.patente = patente;
        this.bateria = bateria;
        this.tarifabase = tarifabase;
        this.estado = new EnEspera();
    }

    public void setEstado(EstadoVehiculo nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void alquilar() {
        estado.alquilar(this);
    }

    public void enviarAMantenimiento() {
        estado.enviarAMantenimiento(this);
    }

    public void finalizarViaje() {
        estado.finalizarViaje(this);
    }

    public void finalizarReparacion() {
        estado.finalizarReparacion(this);
    }

    @Override
    public int compareTo(Vehiculo otro) {
        return Integer.compare(this.bateria, otro.bateria);
    }
}