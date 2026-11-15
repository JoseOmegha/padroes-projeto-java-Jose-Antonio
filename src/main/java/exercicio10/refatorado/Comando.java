package exercicio10.refatorado;

/** Contrato dos comandos que podem ser executados e desfeitos. */
public interface Comando {
    /** Aplica a ação representada pelo comando. */
    void executar();
    /** Reverte a ação representada pelo comando. */
    void desfazer();
}
