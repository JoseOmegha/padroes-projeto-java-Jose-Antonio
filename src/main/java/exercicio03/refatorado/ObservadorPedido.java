package exercicio03.refatorado;

/** Contrato para qualquer componente que reaja a eventos de um pedido. */
public interface ObservadorPedido {
    /** Processa uma alteração de status publicada pelo pedido. */
    void atualizar(EventoPedido evento);
}
