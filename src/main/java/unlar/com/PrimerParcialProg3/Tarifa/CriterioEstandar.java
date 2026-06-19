package unlar.com.PrimerParcialProg3.Tarifa;

public class CriterioEstandar implements CriterioTarifa {

    @Override
    public double calcularCosto(int minutos, double tarifaBase) {
        return minutos * tarifaBase;
    }

    @Override
    public String getNombre() {
        return "Estándar";
    }
}