package exercicio07.refatorado;

/** Fábrica concreta que cria o transporte aéreo. */
public class LogisticaAerea extends Logistica {
    /** Retorna o avião usado nesta modalidade de logística. */
    @Override
    public Transporte criarTransporte() { return new Aviao(); }
}
