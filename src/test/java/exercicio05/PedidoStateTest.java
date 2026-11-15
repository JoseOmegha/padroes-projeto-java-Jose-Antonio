package exercicio05;

import static org.junit.jupiter.api.Assertions.*;
import exercicio05.refatorado.Pedido;
import org.junit.jupiter.api.Test;

/** Verifica as transições permitidas e a rejeição de uma operação inválida. */
class PedidoStateTest {
    /** Confirma o fluxo novo para pago para enviado e bloqueia novo pagamento. */
    @Test
    void devePermitirTransicoesCorretas() {
        Pedido pedido = new Pedido();
        assertEquals("NOVO", pedido.getStatus());
        pedido.pagar();
        assertEquals("PAGO", pedido.getStatus());
        pedido.enviar();
        assertEquals("ENVIADO", pedido.getStatus());
        assertThrows(IllegalStateException.class, pedido::pagar);
    }
}
