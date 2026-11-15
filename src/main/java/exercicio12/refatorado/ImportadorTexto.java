package exercicio12.refatorado;

/** Implementa a extração de nomes em linhas de texto simples. */
public class ImportadorTexto extends ImportadorBase {
    /** Remove espaços ao redor da linha e usa o restante como nome. */
    @Override
    protected String extrairNome(String linha) {
        return linha.trim();
    }
}
