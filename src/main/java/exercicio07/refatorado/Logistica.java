package exercicio07.refatorado;

/** Define o fluxo fixo da entrega e deixa a criação do transporte para subclasses. */
public abstract class Logistica {
    /** Executa as etapas comuns usando o transporte fornecido pelo método fábrica. */
    public final void processar() {
        System.out.println("Preparando entrega");
        Transporte transporte = criarTransporte();
        transporte.entregar();
    }

    /** Cria o transporte adequado à modalidade concreta de logística. */
    protected abstract Transporte criarTransporte();
}
