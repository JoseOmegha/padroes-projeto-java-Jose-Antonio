package exercicio05.original;

/** Versão original: regras de transição ficam em condições sobre uma String. */
public class Pedido {
    /** Estado inicial do pedido, usado para validar as operações. */
    private String status = "NOVO";

    /** Permite pagamento somente quando o pedido está novo. */
    public void pagar() {
        if (!"NOVO".equals(status)) throw new IllegalStateException("Pagamento inválido");
        status = "PAGO"; System.out.println("Pagamento confirmado.");
    }

    /** Permite o envio somente depois do pagamento. */
    public void enviar() {
        if (!"PAGO".equals(status)) throw new IllegalStateException("Envio inválido");
        status = "ENVIADO"; System.out.println("Pedido enviado.");
    }

    /** Cancela pedidos novos ou pagos e rejeita os demais estados. */
    public void cancelar() {
        if ("NOVO".equals(status)) status = "CANCELADO";
        else if ("PAGO".equals(status)) { System.out.println("Solicitando estorno..."); status = "CANCELADO"; }
        else throw new IllegalStateException("Cancelamento inválido");
    }

    /** Retorna o nome do estado atual. */
    public String getStatus() { return status; }
}
