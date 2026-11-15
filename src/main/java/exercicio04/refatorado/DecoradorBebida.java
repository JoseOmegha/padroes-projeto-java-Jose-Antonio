package exercicio04.refatorado;

/** Base dos decoradores: mantém a bebida que será complementada. */
public abstract class DecoradorBebida extends Bebida {
    /** Bebida interna cujo preço e descrição são reutilizados pelo adicional. */
    protected final Bebida bebida;

    /** Guarda a bebida que este decorador irá envolver. */
    public DecoradorBebida(Bebida bebida) {
        this.bebida = bebida;
    }
}
