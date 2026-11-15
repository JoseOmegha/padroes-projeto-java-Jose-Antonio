package exercicio09;

import static org.junit.jupiter.api.Assertions.*;
import exercicio09.refatorado.Relatorio;
import org.junit.jupiter.api.Test;

/** Valida valores padrão e rejeição de configurações inválidas no Builder. */
class RelatorioBuilderTest {
    /** Confirma que o builder aplica os valores opcionais padrão. */
    @Test
    void deveConstruirRelatorioPadrao() {
        Relatorio relatorio = Relatorio.builder()
            .titulo("Relatório")
            .autor("João")
            .build();
        assertEquals("Relatório | João | PDF | false | false | 100", relatorio.resumo());
    }

    /** Confirma que campos obrigatórios e opções fora das regras são rejeitados. */
    @Test
    void deveRejeitarCamposInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> Relatorio.builder().autor("João").build());
        assertThrows(IllegalArgumentException.class, () -> Relatorio.builder().titulo("T").autor("A").formato("XLS").build());
        assertThrows(IllegalArgumentException.class, () -> Relatorio.builder().titulo("T").autor("A").limiteLinhas(0).build());
    }
}
