package exercicio01.refatorado;

/** Calculadora Strategy que delega o preço à modalidade recebida. */
public class CalculadoraFrete {
    /** Regra de frete escolhida pelo código cliente. */
    private final EstrategiaFrete estrategia;

    /** Guarda a estratégia que será usada nos cálculos desta instância. */
    public CalculadoraFrete(EstrategiaFrete estrategia) {
        this.estrategia = estrategia;
    }

    /** Delega o cálculo do preço à estratégia configurada. */
    public double calcular(double pesoKg) {
        return estrategia.calcular(pesoKg);
    }

    /** Demonstra a escolha das quatro estratégias fora do método de cálculo. */
    public static void main(String[] args) {
        CalculadoraFrete pac = new CalculadoraFrete(new FretePac());
        CalculadoraFrete sedex = new CalculadoraFrete(new FreteSedex());
        CalculadoraFrete retirada = new CalculadoraFrete(new RetiradaNaLoja());
        CalculadoraFrete expresso = new CalculadoraFrete(new FreteExpresso());
        System.out.println(pac.calcular(3));
        System.out.println(sedex.calcular(3));
        System.out.println(retirada.calcular(3));
        System.out.println(expresso.calcular(3));
    }
}
