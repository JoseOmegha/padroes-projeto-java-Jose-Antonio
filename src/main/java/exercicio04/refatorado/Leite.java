package exercicio04.refatorado;

/** Decorador que acrescenta leite à bebida encapsulada. */
public class Leite extends DecoradorBebida {
    /** Encapsula a bebida que receberá o adicional. */
    public Leite(Bebida bebida) {
        super(bebida);
    }

    /** Soma o preço do leite ao preço da bebida encapsulada. */
    @Override
    public double calcularPreco() {
        return bebida.calcularPreco() + 2.00;
    }

    /** Acrescenta leite à descrição da bebida. */
    @Override
    public String obterDescricao() {
        return bebida.obterDescricao() + ", leite";
    }
}
