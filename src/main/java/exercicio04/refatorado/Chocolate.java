package exercicio04.refatorado;

/** Decorador que acrescenta uma porção de chocolate à bebida encapsulada. */
public class Chocolate extends DecoradorBebida {
    /** Encapsula a bebida que receberá o adicional. */
    public Chocolate(Bebida bebida) {
        super(bebida);
    }

    /** Soma o preço de uma porção de chocolate. */
    @Override
    public double calcularPreco() {
        return bebida.calcularPreco() + 3.00;
    }

    /** Acrescenta chocolate à descrição da bebida. */
    @Override
    public String obterDescricao() {
        return bebida.obterDescricao() + ", chocolate";
    }
}
