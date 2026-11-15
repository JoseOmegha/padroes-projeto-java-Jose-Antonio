package exercicio10;

import static org.junit.jupiter.api.Assertions.*;
import exercicio10.refatorado.ApagarUltimoCommand;
import exercicio10.refatorado.Editor;
import exercicio10.refatorado.HistoricoComandos;
import exercicio10.refatorado.InserirTextoCommand;
import org.junit.jupiter.api.Test;

/** Verifica a execução dos comandos e a reversão em ordem LIFO. */
class CommandTest {
    /** Confirma que cada comando desfaz sua própria alteração no editor. */
    @Test
    void deveExecutarEDesfazerHistorico() {
        Editor editor = new Editor();
        HistoricoComandos historico = new HistoricoComandos();

        InserirTextoCommand inserirJava = new InserirTextoCommand(editor, "Java");
        inserirJava.executar();
        historico.registrar(inserirJava);

        InserirTextoCommand inserirExclamacao = new InserirTextoCommand(editor, "!");
        inserirExclamacao.executar();
        historico.registrar(inserirExclamacao);

        ApagarUltimoCommand apagar = new ApagarUltimoCommand(editor);
        apagar.executar();
        historico.registrar(apagar);

        assertEquals("Java", editor.getTexto());

        historico.desfazerUltimo();
        assertEquals("Java!", editor.getTexto());
        historico.desfazerUltimo();
        assertEquals("Java", editor.getTexto());
        historico.desfazerUltimo();
        assertEquals("", editor.getTexto());
    }
}
