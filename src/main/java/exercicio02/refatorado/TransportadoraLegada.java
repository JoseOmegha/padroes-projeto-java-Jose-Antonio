package exercicio02.refatorado;

/** Simula a biblioteca existente, que não deve ser alterada pelo checkout. */
class TransportadoraLegada {
    /** Calcula o frete em centavos a partir do peso em gramas. */
    public int cotarEmCentavos(int pesoEmGramas) {
        return 1500 + pesoEmGramas * 2;
    }
}
