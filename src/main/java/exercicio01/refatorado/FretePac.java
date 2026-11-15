package exercicio01.refatorado;

/** Estratégia PAC: R$ 12,00 de taxa base mais R$ 2,00 por quilograma. */
public class FretePac implements EstrategiaFrete {
    @Override
    public double calcular(double pesoKg) {
        return 12.00 + pesoKg * 2.00;
    }
}
