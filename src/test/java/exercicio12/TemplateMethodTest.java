package exercicio12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import exercicio12.refatorado.ImportadorCsv;
import exercicio12.refatorado.ImportadorTexto;
import org.junit.jupiter.api.Test;

/** Verifica a extração de nomes nos formatos CSV e texto. */
class TemplateMethodTest {
    /** Confirma que o importador CSV usa somente a primeira coluna. */
    @Test
    void deveExtrairNomesDoCsv() {
        ImportadorCsvComCaptura csv = new ImportadorCsvComCaptura();
        csv.importar(List.of("Ana;123", "Bruno;456"));

        assertEquals(List.of("Ana", "Bruno"), csv.nomesSalvos);
    }

    /** Confirma que o importador de texto mantém o conteúdo sem espaços externos. */
    @Test
    void deveExtrairNomesDoTexto() {
        ImportadorTextoComCaptura texto = new ImportadorTextoComCaptura();
        texto.importar(List.of("Ana", "Bruno"));

        assertEquals(List.of("Ana", "Bruno"), texto.nomesSalvos);
    }

    /** Importador de teste que captura os nomes sem imprimir no console. */
    private static class ImportadorCsvComCaptura extends ImportadorCsv {
        private final List<String> nomesSalvos = new ArrayList<>();

        /** Registra cada nome para que o teste possa compará-lo. */
        @Override
        protected void salvar(String nome) {
            nomesSalvos.add(nome);
        }
    }

    /** Importador de teste que captura os nomes sem imprimir no console. */
    private static class ImportadorTextoComCaptura extends ImportadorTexto {
        private final List<String> nomesSalvos = new ArrayList<>();

        /** Registra cada nome para que o teste possa compará-lo. */
        @Override
        protected void salvar(String nome) {
            nomesSalvos.add(nome);
        }
    }
}
