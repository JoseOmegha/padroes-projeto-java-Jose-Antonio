package exercicio08;

import static org.junit.jupiter.api.Assertions.*;
import exercicio08.refatorado.BotaoClaro;
import exercicio08.refatorado.BotaoEscuro;
import exercicio08.refatorado.CaixaSelecaoClara;
import exercicio08.refatorado.CaixaSelecaoEscura;
import exercicio08.refatorado.FabricaClara;
import exercicio08.refatorado.FabricaEscura;
import org.junit.jupiter.api.Test;

/** Verifica que cada fábrica cria componentes da família visual correta. */
class AbstractFactoryTest {
    /** Confirma que botões e caixas de seleção mantêm o mesmo tema. */
    @Test
    void deveCriarComponentesDaMesmaFamilia() {
        assertInstanceOf(BotaoClaro.class, new FabricaClara().criarBotao());
        assertInstanceOf(CaixaSelecaoClara.class, new FabricaClara().criarCaixaSelecao());
        assertInstanceOf(BotaoEscuro.class, new FabricaEscura().criarBotao());
        assertInstanceOf(CaixaSelecaoEscura.class, new FabricaEscura().criarCaixaSelecao());
    }
}
