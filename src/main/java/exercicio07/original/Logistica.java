package exercicio07.original;

/** Contrato comum para os transportes da versão original. */
interface Transporte {
    /** Executa a entrega usando o meio de transporte concreto. */
    void entregar();
}

/** Implementação que simula uma entrega por rodovia. */
class Caminhao implements Transporte {
    public void entregar() { System.out.println("Rodovia"); }
}

/** Implementação que simula uma entrega pelo mar. */
class Navio implements Transporte {
    public void entregar() { System.out.println("Mar"); }
}

/** Versão original: escolhe e instancia o transporte por meio de condições. */
public class Logistica {
    /** Prepara a entrega e a encaminha ao transporte selecionado pelo tipo. */
    public void processar(String tipo) {
        Transporte t;
        if ("TERRESTRE".equals(tipo)) t = new Caminhao();
        else if ("MARITIMA".equals(tipo)) t = new Navio();
        else throw new IllegalArgumentException("Tipo inválido");
        System.out.println("Preparando entrega");
        t.entregar();
    }
}
