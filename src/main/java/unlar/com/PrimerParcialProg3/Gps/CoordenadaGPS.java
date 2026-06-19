package unlar.com.PrimerParcialProg3.Gps;

import java.util.Objects;

public class CoordenadaGPS {

    private double latitud;
    private double longitud;

    public CoordenadaGPS(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordenadaGPS otra = (CoordenadaGPS) o;
        return Double.compare(latitud, otra.latitud) == 0
            && Double.compare(longitud, otra.longitud) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitud, longitud);
    }
}