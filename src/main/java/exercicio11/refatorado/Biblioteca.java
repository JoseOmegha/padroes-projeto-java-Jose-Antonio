package exercicio11.refatorado;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/** Coleção de livros que oferece uma iteração controlada por Iterator. */
public class Biblioteca implements Iterable<String> {
    /** Armazena os títulos na ordem de inserção. */
    private final List<String> livros = new ArrayList<>();

    /** Acrescenta um título ao final da coleção. */
    public void adicionar(String titulo) { livros.add(titulo); }

    /** Devolve uma cópia imutável para proteger a lista interna. */
    public List<String> getLivros() {
        return List.copyOf(livros);
    }

    /** Cria um iterador sobre uma cópia estável da coleção atual. */
    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {
            /** Snapshot evita que alterações futuras na biblioteca mudem esta iteração. */
            private final List<String> snapshot = new ArrayList<>(livros);
            /** Índice do próximo elemento a ser retornado. */
            private int indice = 0;

            /** Informa se ainda há títulos no snapshot. */
            @Override
            public boolean hasNext() {
                return indice < snapshot.size();
            }

            /** Retorna o próximo título ou sinaliza que a iteração terminou. */
            @Override
            public String next() {
                if (!hasNext()) throw new NoSuchElementException();
                return snapshot.get(indice++);
            }

            /** Impede remoções pelo iterador, conforme a política desta biblioteca. */
            @Override
            public void remove() {
                throw new UnsupportedOperationException("Remoção não permitida");
            }
        };
    }
}
