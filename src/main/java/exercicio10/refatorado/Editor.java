package exercicio10.refatorado;

/** Mantém o texto e oferece operações usadas pelos comandos de edição. */
public class Editor {
    /** Conteúdo textual editado pelo usuário. */
    private String texto = "";

    /** Acrescenta um trecho ao final do texto atual. */
    public void inserir(String trecho) { texto += trecho; }

    /** Remove o último caractere quando o texto não está vazio. */
    public void apagarUltimo() {
        if (!texto.isEmpty()) texto = texto.substring(0, texto.length() - 1);
    }

    /** Retorna o texto atual do editor. */
    public String getTexto() { return texto; }
    /** Restaura o conteúdo usado para desfazer uma operação. */
    public void setTexto(String texto) { this.texto = texto; }
}
