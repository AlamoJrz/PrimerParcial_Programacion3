package unlar.com.PrimerParcialProg3.Tarifa;

public class CriterioHoraPico implements CriterioTarifa {

    private static final double RECARGO_HORA_PICO = 0.40;

    @Override
    public double calcularCosto(int minutos, double tarifaBase) {
        double costoEstandar = minutos * tarifaBase;
        double recargo = costoEstandar * RECARGO_HORA_PICO;
        return costoEstandar + recargo;
    }

    @Override
    public String getNombre() {
        return "Hora Pico";
    }
}