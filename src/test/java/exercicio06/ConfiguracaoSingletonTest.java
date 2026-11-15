package exercicio06;

import static org.junit.jupiter.api.Assertions.*;
import exercicio06.refatorado.Configuracao;
import org.junit.jupiter.api.Test;

/** Verifica identidade e compartilhamento de estado da instância Singleton. */
class ConfiguracaoSingletonTest {
    /** Confirma que chamadas independentes retornam a mesma configuração. */
    @Test
    void deveCompartilharMesmaInstancia() {
        Configuracao vendas = Configuracao.getInstancia();
        Configuracao estoque = Configuracao.getInstancia();
        vendas.setAmbiente("PRODUCAO");
        assertSame(vendas, estoque);
        assertEquals("PRODUCAO", estoque.getAmbiente());
    }
}
