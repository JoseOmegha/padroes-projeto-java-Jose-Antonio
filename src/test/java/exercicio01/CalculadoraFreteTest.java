package exercicio01;

import static org.junit.jupiter.api.Assertions.*;
import exercicio01.refatorado.CalculadoraFrete;
import exercicio01.refatorado.FreteExpresso;
import exercicio01.refatorado.FretePac;
import exercicio01.refatorado.FreteSedex;
import exercicio01.refatorado.RetiradaNaLoja;
import org.junit.jupiter.api.Test;

/** Valida os valores calculados pelas estratégias de frete. */
class CalculadoraFreteTest {
    @Test
    void deveCalcularValoresEsperados() {
        // Confere as fórmulas de cada modalidade para um pacote de 3 kg.
        assertEquals(18.00, new CalculadoraFrete(new FretePac()).calcular(3), 0.001);
        assertEquals(32.00, new CalculadoraFrete(new FreteSedex()).calcular(3), 0.001);
        assertEquals(0.00, new CalculadoraFrete(new RetiradaNaLoja()).calcular(3), 0.001);
        assertEquals(48.00, new CalculadoraFrete(new FreteExpresso()).calcular(3), 0.001);
    }
}
