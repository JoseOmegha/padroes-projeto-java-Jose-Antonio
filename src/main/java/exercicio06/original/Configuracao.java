package exercicio06.original;

/** Versão original: cada construção cria uma configuração independente. */
public class Configuracao {
    /** Ambiente mantido por esta instância específica. */
    private String ambiente = "DESENVOLVIMENTO";

    /** Lê o ambiente configurado nesta instância. */
    public String getAmbiente() { return ambiente; }
    /** Altera o ambiente somente nesta instância. */
    public void setAmbiente(String ambiente) { this.ambiente = ambiente; }

    /** Demonstra que duas instâncias não compartilham alterações. */
    public static void main(String[] args) {
        Configuracao vendas = new Configuracao();
        Configuracao estoque = new Configuracao();
        vendas.setAmbiente("PRODUCAO");
        System.out.println(vendas.getAmbiente() + " | " + estoque.getAmbiente() + " | " + (vendas == estoque));
    }
}
