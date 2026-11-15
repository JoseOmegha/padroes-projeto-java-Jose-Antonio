package exercicio07.refatorado;

/** Fábrica concreta que cria o transporte terrestre. */
public class LogisticaTerrestre extends Logistica {
    /** Retorna o caminhão usado nesta modalidade de logística. */
    @Override
    public Transporte criarTransporte() { return new Caminhao(); }
}
