package exercicio07.refatorado;

/** Operação que todos os transportes concretos devem oferecer. */
public interface Transporte {
    /** Realiza a entrega usando o meio de transporte concreto. */
    void entregar();
}
