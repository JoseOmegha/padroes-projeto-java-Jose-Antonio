package exercicio03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import exercicio03.refatorado.EventoPedido;
import exercicio03.refatorado.ObservadorHistoricoPedido;
import exercicio03.refatorado.ObservadorPedido;
import exercicio03.refatorado.Pedido;
import org.junit.jupiter.api.Test;

/** Testa inscrição, remoção, histórico e falhas no padrão Observer. */
class PedidoObserverTest {
    /** Confirma a notificação de todos os inscritos e a remoção de um observador. */
    @Test
    void deveNotificarTodosEPararDeNotificarQuemFoiRemovido() {
        Pedido pedido = new Pedido(7, "a@b.com", "9999");
        ContadorObservador primeiro = new ContadorObservador();
        ContadorObservador segundo = new ContadorObservador();
        pedido.adicionarObservador(primeiro);
        pedido.adicionarObservador(segundo);
        pedido.alterarStatus("ENVIADO");
        assertEquals("ENVIADO", pedido.getStatus());
        assertEquals(1, primeiro.quantidade());
        assertEquals(1, segundo.quantidade());
        pedido.removerObservador(primeiro);
        pedido.alterarStatus("ENTREGUE");
        assertEquals(1, primeiro.quantidade());
        assertEquals(2, segundo.quantidade());
    }

    /** Confirma que o observador guarda cada evento na ordem em que foi recebido. */
    @Test
    void deveRegistrarHistoricoDeAlteracoesDeStatus() {
        Pedido pedido = new Pedido(7, "a@b.com", "9999");
        ObservadorHistoricoPedido historico = new ObservadorHistoricoPedido();
        pedido.adicionarObservador(historico);

        pedido.alterarStatus("ENVIADO");
        pedido.alterarStatus("ENTREGUE");

        assertEquals(
                List.of(
                        new EventoPedido(7, "ENVIADO"),
                        new EventoPedido(7, "ENTREGUE")),
                historico.getEventos());
    }

    /** Verifica que falhas são reportadas depois de tentar notificar os demais. */
    @Test
    void deveNotificarTodosMesmoQuandoAlgunsObservadoresFalham() {
        Pedido pedido = new Pedido(7, "a@b.com", "9999");
        RuntimeException primeiraFalha = new RuntimeException("Falha no primeiro observador");
        RuntimeException segundaFalha = new RuntimeException("Falha no segundo observador");
        ContadorObservador contador = new ContadorObservador();
        pedido.adicionarObservador(evento -> {
            throw primeiraFalha;
        });
        pedido.adicionarObservador(contador);
        pedido.adicionarObservador(evento -> {
            throw segundaFalha;
        });

        IllegalStateException erro = assertThrows(
                IllegalStateException.class, () -> pedido.alterarStatus("ENVIADO"));

        assertEquals("ENVIADO", pedido.getStatus());
        assertEquals(1, contador.quantidade());
        assertSame(primeiraFalha, erro.getCause());
        assertEquals(1, erro.getSuppressed().length);
        assertSame(segundaFalha, erro.getSuppressed()[0]);
    }

    /** Observador de teste que conta quantas notificações recebeu. */
    static class ContadorObservador implements ObservadorPedido {
        private int quantidade;
        @Override
        public void atualizar(EventoPedido evento) { quantidade++; }
        int quantidade() { return quantidade; }
    }
}
