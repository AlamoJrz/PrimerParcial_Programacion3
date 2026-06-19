package unlar.com.PrimerParcialProg3.Tarifa;

public class CriterioTemporalClimatico implements CriterioTarifa {

    private static final double RECARGO_CLIMATICO = 150.0;

    @Override
    public double calcularCosto(int minutos, double tarifaBase) {
        double costoEstandar = minutos * tarifaBase;
        return costoEstandar + RECARGO_CLIMATICO;
    }

    @Override
    public String getNombre() {
        return "Temporal Climático";
    }
}