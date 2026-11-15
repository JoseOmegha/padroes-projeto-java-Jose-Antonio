package exercicio08.refatorado;

/** Fábrica concreta que cria componentes compatíveis com o tema escuro. */
public class FabricaEscura implements FabricaComponentes {
    /** Cria o botão da família escura. */
    public Botao criarBotao() { return new BotaoEscuro(); }
    /** Cria a caixa de seleção da família escura. */
    public CaixaSelecao criarCaixaSelecao() { return new CaixaSelecaoEscura(); }
}
