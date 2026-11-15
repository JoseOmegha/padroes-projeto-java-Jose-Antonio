package exercicio04.original;

/** Versão original: combina adicionais por meio de opções booleanas fixas. */
public class Cafe {
    /** Indica quais adicionais foram escolhidos para esta bebida. */
    private final boolean leite;
    private final boolean chocolate;
    private final boolean chantilly;

    /** Guarda as opções de adicionais selecionadas na criação do café. */
    public Cafe(boolean leite, boolean chocolate, boolean chantilly) {
        this.leite = leite;
        this.chocolate = chocolate;
        this.chantilly = chantilly;
    }

    /** Soma ao preço base o valor de cada adicional selecionado. */
    public double calcularPreco() {
        double preco = 5.00;
        if (leite) preco += 2.00;
        if (chocolate) preco += 3.00;
        if (chantilly) preco += 2.50;
        return preco;
    }

    /** Monta a descrição com o café e seus adicionais. */
    public String obterDescricao() {
        String descricao = "Café";
        if (leite) descricao += ", leite";
        if (chocolate) descricao += ", chocolate";
        if (chantilly) descricao += ", chantilly";
        return descricao;
    }

    /** Demonstra um café com leite e chocolate. */
    public static void main(String[] args) {
        Cafe cafe = new Cafe(true, true, false);
        System.out.println(cafe.obterDescricao() + " -> " + cafe.calcularPreco());
    }
}
