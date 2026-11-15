package exercicio07.refatorado;

/** Fábrica concreta que cria o transporte marítimo. */
public class LogisticaMaritima extends Logistica {
    /** Retorna o navio usado nesta modalidade de logística. */
    @Override
    public Transporte criarTransporte() { return new Navio(); }
}
