package exercicio09.original;

/** Versão original: recebe todos os campos do relatório em um único construtor. */
public class Relatorio {
    /** Dados e opções que compõem o relatório. */
    private final String titulo, autor, formato;
    private final boolean graficos, rodape;
    private final int limiteLinhas;

    /** Inicializa todos os campos de uma vez, exigindo muitos argumentos posicionais. */
    public Relatorio(String titulo, String autor, String formato, boolean graficos, boolean rodape, int limiteLinhas) {
        this.titulo = titulo;
        this.autor = autor;
        this.formato = formato;
        this.graficos = graficos;
        this.rodape = rodape;
        this.limiteLinhas = limiteLinhas;
    }

    /** Formata os campos do relatório em uma representação textual. */
    public String resumo() {
        return titulo + " | " + autor + " | " + formato + " | " + graficos + " | " + rodape + " | " + limiteLinhas;
    }
}
