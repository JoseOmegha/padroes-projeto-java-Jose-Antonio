package exercicio09.refatorado;

/** Relatório imutável construído por meio da API encadeada Builder. */
public class Relatorio {
    /** Dados e opções finais do relatório. */
    private final String titulo;
    private final String autor;
    private final String formato;
    private final boolean graficos;
    private final boolean rodape;
    private final int limiteLinhas;

    /** Copia para o relatório os valores validados e preparados pelo builder. */
    private Relatorio(Builder builder) {
        this.titulo = builder.titulo;
        this.autor = builder.autor;
        this.formato = builder.formato;
        this.graficos = builder.graficos;
        this.rodape = builder.rodape;
        this.limiteLinhas = builder.limiteLinhas;
    }

    /** Inicia a configuração fluente de um novo relatório. */
    public static Builder builder() { return new Builder(); }

    /** Formata os campos do relatório em uma representação textual. */
    public String resumo() {
        return titulo + " | " + autor + " | " + formato + " | " + graficos + " | " + rodape + " | " + limiteLinhas;
    }

    /** Guarda valores configuráveis e fornece operações encadeadas de montagem. */
    public static class Builder {
        /** Campos obrigatórios e valores padrão opcionais do relatório. */
        private String titulo;
        private String autor;
        private String formato = "PDF";
        private boolean graficos = false;
        private boolean rodape = false;
        private int limiteLinhas = 100;

        /** Define o título e devolve o builder para encadear opções. */
        public Builder titulo(String titulo) { this.titulo = titulo; return this; }
        /** Define o autor e devolve o builder para encadear opções. */
        public Builder autor(String autor) { this.autor = autor; return this; }

        /** Aceita apenas PDF ou CSV e normaliza o valor para maiúsculas. */
        public Builder formato(String formato) {
            if (!"PDF".equalsIgnoreCase(formato) && !"CSV".equalsIgnoreCase(formato)) {
                throw new IllegalArgumentException("Formato inválido");
            }
            this.formato = formato.toUpperCase();
            return this;
        }

        /** Define se o relatório inclui gráficos. */
        public Builder graficos(boolean graficos) { this.graficos = graficos; return this; }
        /** Define se o relatório inclui rodapé. */
        public Builder rodape(boolean rodape) { this.rodape = rodape; return this; }

        /** Define um limite positivo de linhas para o relatório. */
        public Builder limiteLinhas(int limiteLinhas) {
            if (limiteLinhas <= 0) throw new IllegalArgumentException("Limite de linhas deve ser positivo");
            this.limiteLinhas = limiteLinhas;
            return this;
        }

        /** Valida os campos obrigatórios e cria o relatório imutável. */
        public Relatorio build() {
            if (titulo == null || titulo.isBlank()) throw new IllegalArgumentException("Título obrigatório");
            if (autor == null || autor.isBlank()) throw new IllegalArgumentException("Autor obrigatório");
            return new Relatorio(this);
        }
    }
}
