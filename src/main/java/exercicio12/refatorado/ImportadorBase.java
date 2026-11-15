package exercicio12.refatorado;

import java.util.List;

/** Template Method que define o fluxo comum de importação. */
public abstract class ImportadorBase {
    /** Executa abertura, processamento de linhas e encerramento garantido. */
    public final void importar(List<String> linhas) {
        abrir();
        try {
            for (String linha : linhas) {
                // A extração varia por formato; salvar e o hook permanecem no fluxo comum.
                String nome = extrairNome(linha);
                salvar(nome);
                aposSalvar(nome);
            }
        } finally {
            fechar();
        }
    }

    /** Etapa comum executada antes de processar as linhas. */
    protected void abrir() { System.out.println("Abrindo importação"); }
    /** Etapa variável: cada formato define como obter o nome da linha. */
    protected abstract String extrairNome(String linha);
    /** Etapa comum que simula o armazenamento do nome extraído. */
    protected void salvar(String nome) { System.out.println("Salvando: " + nome); }
    /** Hook opcional executado depois que cada nome é salvo. */
    protected void aposSalvar(String nome) { }
    /** Etapa comum sempre executada, inclusive se o processamento falhar. */
    protected void fechar() { System.out.println("Fechando importação"); }
}
