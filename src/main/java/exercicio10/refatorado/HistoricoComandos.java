package exercicio10.refatorado;

import java.util.ArrayDeque;
import java.util.Deque;

/** Mantém comandos executados para permitir desfazer em ordem inversa. */
public class HistoricoComandos {
    /** Pilha LIFO: o último comando registrado é o primeiro a ser desfeito. */
    private final Deque<Comando> historico = new ArrayDeque<>();

    /** Adiciona um comando ao topo do histórico. */
    public void registrar(Comando comando) {
        historico.push(comando);
    }

    /** Desfaz e remove o comando mais recente, se houver algum. */
    public void desfazerUltimo() {
        if (!historico.isEmpty()) {
            historico.pop().desfazer();
        }
    }
}
