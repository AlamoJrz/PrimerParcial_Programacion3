package unlar.com.PrimerParcialProg3.models;

import java.util.Comparator;

public class ComparadorPorTarifa implements Comparator<Vehiculo> {

    @Override
    public int compare(Vehiculo v1, Vehiculo v2) {
        return Double.compare(v2.getTarifabase(), v1.getTarifabase());
    }
}