package exercicio08.refatorado;

/** Cria componentes pertencentes à mesma família visual. */
public interface FabricaComponentes {
    /** Cria um botão para o tema da fábrica. */
    Botao criarBotao();
    /** Cria uma caixa de seleção para o tema da fábrica. */
    CaixaSelecao criarCaixaSelecao();
}
