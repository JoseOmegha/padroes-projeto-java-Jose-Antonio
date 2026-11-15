package exercicio02.refatorado;

/** Adapta as unidades e a assinatura da transportadora legada ao serviço do checkout. */
public class TransportadoraAdapter implements ServicoFrete {
    /** API existente, que trabalha com gramas e centavos. */
    private final TransportadoraLegada transportadoraLegada = new TransportadoraLegada();

    @Override
    public double calcular(double pesoKg) {
        // Converte para a unidade exigida pela API legada.
        int gramas = (int) Math.round(pesoKg * 1000);
        // Converte os centavos retornados para reais.
        return transportadoraLegada.cotarEmCentavos(gramas) / 100.0;
    }
}
