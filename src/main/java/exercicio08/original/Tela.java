package exercicio08.original;

/** Versão original: escolhe por tema os textos de cada componente da tela. */
public class Tela {
    /** Renderiza a família de componentes correspondente ao tema informado. */
    public void renderizar(String tema) {
        if ("CLARO".equals(tema)) {
            System.out.println("Botão claro"); System.out.println("Caixa de seleção clara");
        } else if ("ESCURO".equals(tema)) {
            System.out.println("Botão escuro"); System.out.println("Caixa de seleção escura");
        } else throw new IllegalArgumentException("Tema inválido");
    }
}
