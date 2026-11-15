package exercicio05.refatorado;

/** Estado inicial: permite pagar ou cancelar, mas ainda não enviar. */
public class Novo implements EstadoPedido {
    /** Pagamento leva o pedido ao estado pago. */
    @Override
    public void pagar(Pedido pedido) { pedido.setEstado(new Pago()); }
    /** Envio antes do pagamento é rejeitado. */
    @Override
    public void enviar(Pedido pedido) { throw new IllegalStateException("Envio inválido"); }
    /** Cancelamento leva diretamente ao estado cancelado. */
    @Override
    public void cancelar(Pedido pedido) { pedido.setEstado(new Cancelado()); }
    /** Informa o nome deste estado. */
    @Override
    public String getNome() { return "NOVO"; }
}
