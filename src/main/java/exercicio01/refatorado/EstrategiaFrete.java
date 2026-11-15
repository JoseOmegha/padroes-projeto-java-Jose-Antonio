package exercicio01.refatorado;

/** Contrato comum para as diferentes regras de cálculo de frete. */
public interface EstrategiaFrete {
    /** Calcula o frete para o peso informado em quilogramas. */
    double calcular(double pesoKg);
}
