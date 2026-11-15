package exercicio04.refatorado;

/** Decorador que acrescenta chantilly à bebida encapsulada. */
public class Chantilly extends DecoradorBebida {
    /** Encapsula a bebida que receberá o adicional. */
    public Chantilly(Bebida bebida) {
        super(bebida);
    }

    /** Soma o preço do chantilly ao preço da bebida encapsulada. */
    @Override
    public double calcularPreco() {
        return bebida.calcularPreco() + 2.50;
    }

    /** Acrescenta chantilly à descrição da bebida. */
    @Override
    public String obterDescricao() {
        return bebida.obterDescricao() + ", chantilly";
    }
}
