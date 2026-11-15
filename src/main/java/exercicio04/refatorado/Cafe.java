package exercicio04.refatorado;

/** Demonstra combinações de bebidas compostas pelo padrão Decorator. */
public class Cafe {
    /** Constrói combinações de adicionais e exibe seus nomes e preços. */
    public static void main(String[] args) {
        // Bebida base, sem adicionais.
        Bebida cafeSimples = new CafeSimples();
        // Os decoradores são empilhados para combinar leite e chocolate.
        Bebida cafeComLeiteEChocolate = new Chocolate(new Leite(cafeSimples));
        // Repetir um decorador representa uma porção adicional do mesmo item.
        Bebida cafeComDuasPorcoesChocolateUmaDeLeite = new Chocolate(new Chocolate(new Leite(cafeSimples)));
        System.out.println(cafeSimples.obterDescricao() + " -> " + cafeSimples.calcularPreco());
        System.out.println(cafeComLeiteEChocolate.obterDescricao() + " -> " + cafeComLeiteEChocolate.calcularPreco());
        System.out.println(cafeComDuasPorcoesChocolateUmaDeLeite.obterDescricao() + " -> " + cafeComDuasPorcoesChocolateUmaDeLeite.calcularPreco());
    }
}
