package exercicio02;

import static org.junit.jupiter.api.Assertions.*;
import exercicio02.refatorado.Checkout;
import exercicio02.refatorado.ServicoFrete;
import exercicio02.refatorado.TransportadoraAdapter;
import org.junit.jupiter.api.Test;

/** Verifica a integração do checkout com o adaptador da transportadora. */
class CheckoutTest {
    @Test
    void deveCalcularTotal() {
        // O adaptador transforma 2 kg em R$ 55,00 de frete; o total esperado é R$ 155,00.
        ServicoFrete frete = new TransportadoraAdapter();
        Checkout checkout = new Checkout(frete);
        assertEquals(155.00, checkout.calcularTotal(100.00, 2), 0.001);
    }
}
