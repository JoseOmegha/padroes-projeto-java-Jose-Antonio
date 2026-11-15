package exercicio12.refatorado;

/** Implementa a extração do nome a partir da primeira coluna de uma linha CSV. */
public class ImportadorCsv extends ImportadorBase {
    /** Separa pelo ponto e vírgula e remove espaços ao redor do nome. */
    @Override
    protected String extrairNome(String linha) {
        return linha.split(";", -1)[0].trim();
    }
}
