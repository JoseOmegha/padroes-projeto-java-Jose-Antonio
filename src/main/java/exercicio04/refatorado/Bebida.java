package exercicio04.refatorado;

/** Abstração comum para o café base e as bebidas decoradas. */
public abstract class Bebida {
    /** Retorna o preço da bebida e dos adicionais aplicados. */
    public abstract double calcularPreco();
    /** Retorna a descrição da bebida e dos adicionais aplicados. */
    public abstract String obterDescricao();
}
