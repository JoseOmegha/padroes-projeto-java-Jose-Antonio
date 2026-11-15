package exercicio03.refatorado;

import java.util.ArrayList;
import java.util.List;

/** Publica mudanças de status sem depender de serviços concretos de notificação. */
public class Pedido {
    /** Identificador enviado junto com cada evento de status. */
    private final int id;
    /** Dados de contato disponíveis aos consumidores do pedido. */
    private final String email;
    private final String telefone;
    /** Estado atual, atualizado antes da publicação do evento. */
    private String status = "CRIADO";
    /** Componentes inscritos para receber as alterações do pedido. */
    private final List<ObservadorPedido> observadores = new ArrayList<>();

    /** Cria um pedido com identificador e dados de contato. */
    public Pedido(int id, String email, String telefone) {
        this.id = id;
        this.email = email;
        this.telefone = telefone;
    }

    /** Inscreve um componente para receber eventos futuros. */
    public void adicionarObservador(ObservadorPedido observador) {
        observadores.add(observador);
    }

    /** Remove a inscrição do componente, se ele estiver registrado. */
    public void removerObservador(ObservadorPedido observador) {
        observadores.remove(observador);
    }

    /**
     * Notifica todos os observadores e reporta as falhas depois de tentar cada um.
     * O status permanece atualizado mesmo quando uma notificação falha.
     */
    public void alterarStatus(String novoStatus) {
        this.status = novoStatus;
        // Um único evento é compartilhado por todos os observadores desta mudança.
        EventoPedido evento = new EventoPedido(id, novoStatus);
        RuntimeException falhaNotificacao = null;
        // A cópia permite que observadores alterem inscrições sem modificar esta iteração.
        for (ObservadorPedido observador : new ArrayList<>(observadores)) {
            try {
                observador.atualizar(evento);
            } catch (RuntimeException erro) {
                // Registra a falha e continua para que os demais observadores sejam chamados.
                if (falhaNotificacao == null) {
                    falhaNotificacao = new IllegalStateException(
                            "Falha ao notificar observadores do pedido " + id, erro);
                } else {
                    falhaNotificacao.addSuppressed(erro);
                }
            }
        }
        if (falhaNotificacao != null) {
            throw falhaNotificacao;
        }
    }

    /** Retorna o status atual do pedido. */
    public String getStatus() {
        return status;
    }

    /** Retorna o e-mail associado ao pedido. */
    public String getEmail() {
        return email;
    }

    /** Retorna o telefone associado ao pedido. */
    public String getTelefone() {
        return telefone;
    }

    /** Retorna o identificador do pedido. */
    public int getId() {
        return id;
    }

    /** Registra os observadores da demonstração e publica uma alteração. */
    public static void main(String[] args) {
        Pedido pedido = new Pedido(101, "cliente@exemplo.com", "62999990000");
        pedido.adicionarObservador(new EmailObserver());
        pedido.adicionarObservador(new SmsObserver());
        pedido.adicionarObservador(new PainelObserver());
        ObservadorHistoricoPedido historico = new ObservadorHistoricoPedido();
        pedido.adicionarObservador(historico);
        pedido.alterarStatus("ENVIADO");
        System.out.println("Histórico: " + historico.getEventos());
    }

    /** Observador de demonstração que simula uma notificação por e-mail. */
    static class EmailObserver implements ObservadorPedido {
        @Override
        public void atualizar(EventoPedido evento) {
            System.out.println("E-mail: " + evento.id() + " | " + evento.novoStatus());
        }
    }

    /** Observador de demonstração que simula uma notificação por SMS. */
    static class SmsObserver implements ObservadorPedido {
        @Override
        public void atualizar(EventoPedido evento) {
            System.out.println("SMS: " + evento.id() + " | " + evento.novoStatus());
        }
    }

    /** Observador de demonstração que simula a atualização de um painel. */
    static class PainelObserver implements ObservadorPedido {
        @Override
        public void atualizar(EventoPedido evento) {
            System.out.println("Painel: " + evento.id() + " | " + evento.novoStatus());
        }
    }
}
