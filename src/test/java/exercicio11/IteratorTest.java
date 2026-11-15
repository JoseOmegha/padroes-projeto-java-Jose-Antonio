package exercicio11;

import static org.junit.jupiter.api.Assertions.*;
import exercicio11.refatorado.Biblioteca;
import java.util.Iterator;
import org.junit.jupiter.api.Test;

/** Verifica a ordem e o término da iteração pelos livros. */
class IteratorTest {
    /** Confirma que os títulos são percorridos na ordem em que foram inseridos. */
    @Test
    void deveIterarEmOrdemDeInsercao() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionar("Clean Code");
        biblioteca.adicionar("Effective Java");

        Iterator<String> iterator = biblioteca.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("Clean Code", iterator.next());
        assertEquals("Effective Java", iterator.next());
        assertFalse(iterator.hasNext());
    }
}
