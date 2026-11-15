package exercicio04.refatorado;

/** Bebida base, sem adicionais, com preço e descrição próprios. */
public class CafeSimples extends Bebida {
    /** Retorna o preço do café simples. */
    @Override
    public double calcularPreco() {
        return 5.00;
    }

    /** Retorna o nome da bebida base. */
    @Override
    public String obterDescricao() {
        return "Café";
    }
}
