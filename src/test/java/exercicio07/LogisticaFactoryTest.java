package exercicio07;

import static org.junit.jupiter.api.Assertions.*;
import exercicio07.refatorado.Aviao;
import exercicio07.refatorado.Caminhao;
import exercicio07.refatorado.LogisticaAerea;
import exercicio07.refatorado.LogisticaMaritima;
import exercicio07.refatorado.LogisticaTerrestre;
import exercicio07.refatorado.Navio;
import org.junit.jupiter.api.Test;

/** Verifica se cada logística cria o tipo correto de transporte. */
class LogisticaFactoryTest {
    /** Confirma a associação entre modalidades logísticas e transportes. */
    @Test
    void deveCriarTransporteCorreto() {
        assertInstanceOf(Caminhao.class, new LogisticaTerrestre().criarTransporte());
        assertInstanceOf(Navio.class, new LogisticaMaritima().criarTransporte());
        assertInstanceOf(Aviao.class, new LogisticaAerea().criarTransporte());
    }
}
