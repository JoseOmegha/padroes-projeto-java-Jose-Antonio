package exercicio05.refatorado;

/** Pedido que delega cada operação às regras do seu estado atual. */
public class Pedido {
    /** Estado responsável por validar e executar a próxima transição. */
    private EstadoPedido estado = new Novo();

    /** Delega o pagamento ao estado atual. */
    public void pagar() { estado.pagar(this); }
    /** Delega o envio ao estado atual. */
    public void enviar() { estado.enviar(this); }
    /** Delega o cancelamento ao estado atual. */
    public void cancelar() { estado.cancelar(this); }
    /** Retorna o nome fornecido pelo estado atual. */
    public String getStatus() { return estado.getNome(); }
    /** Atualiza o estado como resultado de uma transição válida. */
    public void setEstado(EstadoPedido estado) { this.estado = estado; }
}
