package unlar.com.PrimerParcialProg3.Tarifa;

public interface CriterioTarifa {

    double calcularCosto(int minutos, double tarifaBase);

    String getNombre();
}