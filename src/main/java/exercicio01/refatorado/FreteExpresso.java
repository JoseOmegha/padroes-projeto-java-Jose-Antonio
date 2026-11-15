package exercicio01.refatorado;

/** Estratégia de frete expresso, com taxa base e valor por quilograma. */
public class FreteExpresso implements EstrategiaFrete {
    @Override
    public double calcular(double pesoKg) {
        return 30.00 + pesoKg * 6.00;
    }
}
