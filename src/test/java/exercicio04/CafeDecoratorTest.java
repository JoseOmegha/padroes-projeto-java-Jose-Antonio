package exercicio04;

import static org.junit.jupiter.api.Assertions.*;
import exercicio04.refatorado.Bebida;
import exercicio04.refatorado.CafeSimples;
import exercicio04.refatorado.Chocolate;
import exercicio04.refatorado.Leite;
import org.junit.jupiter.api.Test;

/** Verifica preços de bebidas simples e de combinações de decoradores. */
class CafeDecoratorTest {
    /** Confirma o preço base e o acréscimo dos adicionais, inclusive repetidos. */
    @Test
    void deveCalcularDecoraces() {
        Bebida simples = new CafeSimples();
        assertEquals(5.00, simples.calcularPreco(), 0.001);
        Bebida comLeiteChocolate = new Chocolate(new Leite(simples));
        assertEquals(10.00, comLeiteChocolate.calcularPreco(), 0.001);
        Bebida comTresAdicionais = new Chocolate(new Chocolate(new Leite(simples)));
        assertEquals(13.00, comTresAdicionais.calcularPreco(), 0.001);
    }
}
