package unlar.com.PrimerParcialProg3.Gps;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GpsService {

    // Hace una sola pasada O(n)
    public Set<CoordenadaGPS> deduplicar(List<CoordenadaGPS> reportes) {
        Set<CoordenadaGPS> unicas = new HashSet<>();
        for (CoordenadaGPS coordenada : reportes) {
            unicas.add(coordenada);
        }
        return unicas;
    }
}