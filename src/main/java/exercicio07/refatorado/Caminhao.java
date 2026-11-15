package exercicio07.refatorado;

/** Transporte concreto que simula uma entrega por rodovia. */
public class Caminhao implements Transporte {
    /** Executa a ação de entrega terrestre da demonstração. */
    public void entregar() { System.out.println("Rodovia"); }
}
