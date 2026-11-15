package exercicio02.refatorado;

/** Contrato esperado pelo checkout: peso em quilogramas e preço em reais. */
public interface ServicoFrete {
    /** Retorna o custo do frete para o peso informado. */
    double calcular(double pesoKg);
}
