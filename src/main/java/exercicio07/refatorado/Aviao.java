package exercicio07.refatorado;

/** Transporte concreto que simula uma entrega pelo ar. */
public class Aviao implements Transporte {
    /** Executa a ação de entrega aérea da demonstração. */
    public void entregar() { System.out.println("Ar"); }
}
