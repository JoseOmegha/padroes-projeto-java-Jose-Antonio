package exercicio05.refatorado;

/** Estado de pedido enviado, que rejeita novas operações de pagamento e envio. */
public class Enviado implements EstadoPedido {
    /** Pagamento não é permitido depois do envio. */
    @Override public void pagar(Pedido pedido) { throw new IllegalStateException("Pagamento inválido"); }
    /** O pedido não pode ser enviado novamente. */
    @Override public void enviar(Pedido pedido) { throw new IllegalStateException("Envio inválido"); }
    /** Cancelamento não é permitido depois do envio. */
    @Override public void cancelar(Pedido pedido) { throw new IllegalStateException("Cancelamento inválido"); }
    /** Informa o nome deste estado. */
    @Override public String getNome() { return "ENVIADO"; }
}
