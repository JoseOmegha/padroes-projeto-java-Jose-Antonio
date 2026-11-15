package exercicio01.original;

/** Versão original: concentra a escolha da modalidade e todas as fórmulas de frete. */
public class CalculadoraFrete {
    /** Seleciona o cálculo pelo nome da modalidade e rejeita opções desconhecidas. */
    public double calcular(String modalidade, double pesoKg) {
        if ("PAC".equalsIgnoreCase(modalidade)) return 12.00 + pesoKg * 2.00;
        if ("SEDEX".equalsIgnoreCase(modalidade)) return 20.00 + pesoKg * 4.00;
        if ("RETIRADA".equalsIgnoreCase(modalidade)) return 0;
        throw new IllegalArgumentException("Modalidade inválida");
    }

    /** Demonstra o cálculo de um envio SEDEX de 3 kg. */
    public static void main(String[] args) {
        System.out.println(new CalculadoraFrete().calcular("SEDEX", 3));
    }
}
