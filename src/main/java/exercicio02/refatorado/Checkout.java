package exercicio02.refatorado;

/** Calcula o total usando o contrato de frete independente da API legada. */
public class Checkout {
    /** Serviço que fornece o frete em reais para um peso em quilogramas. */
    private final ServicoFrete servicoFrete;

    /** Recebe o serviço, permitindo substituir sua implementação. */
    public Checkout(ServicoFrete servicoFrete) {
        this.servicoFrete = servicoFrete;
    }

    /** Soma o custo dos produtos ao frete retornado pelo serviço. */
    public double calcularTotal(double produtos, double pesoKg) {
        return produtos + servicoFrete.calcular(pesoKg);
    }

    /** Monta a integração com o adaptador e exibe o total calculado. */
    public static void main(String[] args) {
        Checkout checkout = new Checkout(new TransportadoraAdapter());
        System.out.println(checkout.calcularTotal(100.00, 2));
    }
}
