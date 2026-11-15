package exercicio02.original;

/** Simula a API legada: recebe gramas e retorna o valor em centavos. */
class TransportadoraLegada {
    public int cotarEmCentavos(int pesoEmGramas) {
        return 1500 + pesoEmGramas * 2;
    }
}

/** Versão original: integra diretamente o checkout à transportadora legada. */
public class Checkout {
    /** Converte unidades, consulta o frete e soma o valor aos produtos. */
    public double calcularTotal(double produtos, double pesoKg) {
        TransportadoraLegada transportadora = new TransportadoraLegada();
        int gramas = (int) Math.round(pesoKg * 1000);
        return produtos + (transportadora.cotarEmCentavos(gramas) / 100.0);
    }

    /** Demonstra o total para R$ 100,00 em produtos e 2 kg. */
    public static void main(String[] args) {
        System.out.println(new Checkout().calcularTotal(100.00, 2));
    }
}
