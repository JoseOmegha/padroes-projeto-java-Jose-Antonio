package exercicio05.refatorado;

/** Estado pago: permite envio ou cancelamento com solicitação de estorno. */
public class Pago implements EstadoPedido {
    /** Pagamento duplicado é rejeitado. */
    @Override
    public void pagar(Pedido pedido) { throw new IllegalStateException("Pagamento inválido"); }
    /** Envio leva o pedido ao estado enviado. */
    @Override
    public void enviar(Pedido pedido) { pedido.setEstado(new Enviado()); }
    /** Cancela o pedido após solicitar o estorno. */
    @Override
    public void cancelar(Pedido pedido) { System.out.println("Solicitando estorno..."); pedido.setEstado(new Cancelado()); }
    /** Informa o nome deste estado. */
    @Override
    public String getNome() { return "PAGO"; }
}
