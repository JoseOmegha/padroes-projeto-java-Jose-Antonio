package exercicio05.refatorado;

/** Define as operações cujo comportamento varia conforme o estado do pedido. */
public interface EstadoPedido {
    /** Processa uma tentativa de pagamento neste estado. */
    void pagar(Pedido pedido);
    /** Processa uma tentativa de envio neste estado. */
    void enviar(Pedido pedido);
    /** Processa uma tentativa de cancelamento neste estado. */
    void cancelar(Pedido pedido);
    /** Retorna o nome usado para representar este estado. */
    String getNome();
}
