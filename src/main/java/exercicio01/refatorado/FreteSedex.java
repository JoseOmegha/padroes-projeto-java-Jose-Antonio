package exercicio01.refatorado;

/** Estratégia SEDEX: R$ 20,00 de taxa base mais R$ 4,00 por quilograma. */
public class FreteSedex implements EstrategiaFrete {
    @Override
    public double calcular(double pesoKg) {
        return 20.00 + pesoKg * 4.00;
    }
}
