package unlar.com.PrimerParcialProg3.Estacion;

import java.util.ArrayList;
import java.util.List;

import unlar.com.PrimerParcialProg3.models.Vehiculo;

public class EstacionAnclaje {
    private String nombre;
    private List<Vehiculo> vehiculos = new ArrayList<>();

    public EstacionAnclaje(String nombre) { this.nombre = nombre; }

    public void agregarVehiculo(Vehiculo v) { vehiculos.add(v); }
    public String getNombre() { return nombre; }
    public List<Vehiculo> getVehiculos() { return vehiculos; }

    // Búsqueda MANUAL elemento por elemento (examen lo pide así)
    public Vehiculo buscarPorPatente(String patente) {
        for (Vehiculo v : vehiculos) {
            if (v.getPatente().equals(patente)) {
                return v;
            }
        }
        return null; // no encontrado
    }
}


