package exercicio08.refatorado;

/** Renderiza componentes sem depender de uma família visual concreta. */
public class Tela {
    /** Fábrica que fornece componentes do mesmo tema. */
    private final FabricaComponentes fabrica;

    /** Recebe a família de componentes que será usada pela tela. */
    public Tela(FabricaComponentes fabrica) { this.fabrica = fabrica; }

    /** Cria e renderiza um botão e uma caixa de seleção da família escolhida. */
    public void renderizar() {
        fabrica.criarBotao().renderizar();
        fabrica.criarCaixaSelecao().renderizar();
    }
}
