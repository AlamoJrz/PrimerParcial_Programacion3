package unlar.com.PrimerParcialProg3.Estacion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import unlar.com.PrimerParcialProg3.models.ComparadorPorTarifa;
import unlar.com.PrimerParcialProg3.models.Vehiculo;

public class EstacionAnclaje {
    private String nombre;
    private Map<String, Vehiculo> vehiculos = new HashMap<>();

    public EstacionAnclaje(String nombre) {
        this.nombre = nombre;
    }

    public void agregarVehiculo(Vehiculo v) {
        vehiculos.put(v.getPatente(), v);
    }

    public String getNombre() {
        return nombre;
    }

    public Collection<Vehiculo> getVehiculos() {
        return vehiculos.values();
    }

    // Búsqueda por HashMap: acceso directo en tiempo constante O(1)
    public Vehiculo buscarPorPatente(String patente) {
        return vehiculos.get(patente);
    }

    // Orden natural (Comparable): por batería, de menor a mayor
    public List<Vehiculo> listarPorPrioridadCarga() {
        List<Vehiculo> lista = new ArrayList<>(vehiculos.values());
        Collections.sort(lista);
        return lista;
    }

    // Orden externo (Comparator): por tarifa, de mayor a menor
    public List<Vehiculo> listarPorTarifaDescendente() {
        List<Vehiculo> lista = new ArrayList<>(vehiculos.values());
        Collections.sort(lista, new ComparadorPorTarifa());
        return lista;
    }
}