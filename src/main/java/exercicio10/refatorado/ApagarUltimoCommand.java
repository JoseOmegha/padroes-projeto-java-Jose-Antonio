package exercicio10.refatorado;

/** Comando que remove o último caractere e pode restaurar o estado anterior. */
public class ApagarUltimoCommand implements Comando {
    /** Editor alterado por este comando. */
    private final Editor editor;
    /** Texto salvo antes da execução para permitir desfazer a ação. */
    private final String textoAntes;

    /** Captura o texto atual do editor como ponto de restauração. */
    public ApagarUltimoCommand(Editor editor) {
        this.editor = editor;
        this.textoAntes = editor.getTexto();
    }

    /** Executa a remoção do último caractere. */
    @Override
    public void executar() { editor.apagarUltimo(); }

    /** Restaura o texto que existia antes da execução. */
    @Override
    public void desfazer() { editor.setTexto(textoAntes); }
}
