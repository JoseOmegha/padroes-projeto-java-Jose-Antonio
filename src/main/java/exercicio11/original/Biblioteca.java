package exercicio11.original;

import java.util.ArrayList;
import java.util.List;

/** Versão original: expõe diretamente a lista interna de livros. */
public class Biblioteca {
    /** Livros armazenados na ordem em que foram adicionados. */
    private final List<String> livros = new ArrayList<>();

    /** Adiciona um título à coleção. */
    public void adicionar(String titulo) { livros.add(titulo); }

    /** Retorna a lista interna, que pode ser alterada pelo chamador. */
    public List<String> getLivros() { return livros; }
}
