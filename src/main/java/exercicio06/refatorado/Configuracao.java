package exercicio06.refatorado;

/** Configuração compartilhada por meio do padrão Singleton. */
public class Configuracao {
    /** Valor de ambiente mantido pela instância única. */
    private String ambiente = "DESENVOLVIMENTO";

    /** Impede que clientes criem instâncias independentes. */
    private Configuracao() {}

    /** Inicializa a instância única de forma segura e sob demanda. */
    private static class Holder {
        private static final Configuracao INSTANCIA = new Configuracao();
    }

    /** Retorna a instância compartilhada da configuração. */
    public static Configuracao getInstancia() { return Holder.INSTANCIA; }
    /** Lê o ambiente compartilhado. */
    public String getAmbiente() { return ambiente; }
    /** Altera o ambiente visto por todos que usam a instância única. */
    public void setAmbiente(String ambiente) { this.ambiente = ambiente; }
}
