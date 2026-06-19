package unlar.com.PrimerParcialProg3.Tarifa;

import org.springframework.stereotype.Service;

@Service
public class TarifaService {

    private CriterioTarifa criterioActivo;

    public TarifaService() {
        this.criterioActivo = new CriterioEstandar();
    }

    public void cambiarCriterio(CriterioTarifa nuevoCriterio) {
        this.criterioActivo = nuevoCriterio;
    }

    public double calcularCosto(int minutos, double tarifaBase) {
        return criterioActivo.calcularCosto(minutos, tarifaBase);
    }

    public String getCriterioActivoNombre() {
        return criterioActivo.getNombre();
    }
}