package exercicio05.refatorado;

/** Estado final de cancelamento, no qual novas operações são inválidas. */
public class Cancelado implements EstadoPedido {
    /** Pagamento não é permitido após o cancelamento. */
    @Override public void pagar(Pedido pedido) { throw new IllegalStateException("Pagamento inválido"); }
    /** Envio não é permitido após o cancelamento. */
    @Override public void enviar(Pedido pedido) { throw new IllegalStateException("Envio inválido"); }
    /** Um pedido já cancelado não pode ser cancelado novamente. */
    @Override public void cancelar(Pedido pedido) { throw new IllegalStateException("Cancelamento inválido"); }
    /** Informa o nome deste estado. */
    @Override public String getNome() { return "CANCELADO"; }
}
