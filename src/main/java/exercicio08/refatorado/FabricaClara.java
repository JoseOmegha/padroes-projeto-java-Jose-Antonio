package exercicio08.refatorado;

/** Fábrica concreta que cria componentes compatíveis com o tema claro. */
public class FabricaClara implements FabricaComponentes {
    /** Cria o botão da família clara. */
    public Botao criarBotao() { return new BotaoClaro(); }
    /** Cria a caixa de seleção da família clara. */
    public CaixaSelecao criarCaixaSelecao() { return new CaixaSelecaoClara(); }
}
