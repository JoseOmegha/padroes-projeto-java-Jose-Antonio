package exercicio10.refatorado;

/** Comando que insere um trecho e guarda o texto necessário para desfazer. */
public class InserirTextoCommand implements Comando {
    /** Editor que receberá a alteração. */
    private final Editor editor;
    /** Trecho inserido quando o comando é executado. */
    private final String trecho;
    /** Conteúdo anterior do editor, usado na operação de desfazer. */
    private final String textoAntes;

    /** Guarda o editor, o trecho e o estado anterior para reversão. */
    public InserirTextoCommand(Editor editor, String trecho) {
        this.editor = editor;
        this.trecho = trecho;
        this.textoAntes = editor.getTexto();
    }

    /** Acrescenta o trecho ao texto do editor. */
    @Override
    public void executar() { editor.inserir(trecho); }

    /** Restaura o texto que existia antes da inserção. */
    @Override
    public void desfazer() { editor.setTexto(textoAntes); }
}
