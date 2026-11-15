package exercicio01.refatorado;

/** Estratégia sem custo, usada quando o cliente retira o pedido na loja. */
public class RetiradaNaLoja implements EstrategiaFrete {
    @Override
    public double calcular(double pesoKg) {
        return 0;
    }
}
