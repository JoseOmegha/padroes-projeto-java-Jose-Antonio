package exercicio12.original;

import java.util.List;

/** Versão original: repete o fluxo de importação para cada formato. */
public class Importador {
    /** Exibe a abertura, os nomes extraídos de cada linha CSV e o encerramento. */
    public void importarCsv(List<String> linhas) {
        System.out.println("Abrindo importação");
        for (String l : linhas) System.out.println("Salvando: " + l.split(";", -1)[0].trim());
        System.out.println("Fechando importação");
    }

    /** Exibe o fluxo de importação de linhas de texto simples. */
    public void importarTexto(List<String> linhas) {
        System.out.println("Abrindo importação");
        for (String l : linhas) System.out.println("Salvando: " + l.trim());
        System.out.println("Fechando importação");
    }
}
