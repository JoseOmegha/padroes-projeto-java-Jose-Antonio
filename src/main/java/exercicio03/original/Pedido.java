package exercicio03.original;

/** Versão original: o pedido conhece e chama diretamente os três serviços. */
class EmailService {
    /** Simula o envio de uma mensagem por e-mail no console. */
    public void enviar(String e, String m) {
        System.out.println("E-mail: " + e + " | " + m);
    }
}

class SmsService {
    /** Simula o envio de uma mensagem por SMS no console. */
    public void enviar(String t, String m) {
        System.out.println("SMS: " + t + " | " + m);
    }
}

class PainelService {
    /** Simula a atualização do status exibido no painel. */
    public void atualizar(int id, String s) {
        System.out.println("Painel: " + id + " | " + s);
    }
}

/** Pedido original, com as integrações de notificação fixas na própria classe. */
public class Pedido {
    /** Identifica o pedido notificado. */
    private final int id;
    /** Destinatários usados pelos serviços de e-mail e SMS. */
    private final String email, telefone;
    /** Status atual do pedido. */
    private String status = "CRIADO";
    /** Serviços concretos acoplados diretamente ao pedido. */
    private final EmailService emailService = new EmailService();
    private final SmsService smsService = new SmsService();
    private final PainelService painelService = new PainelService();

    /** Cria um pedido com identificador e contatos para notificação. */
    public Pedido(int id, String email, String telefone) {
        this.id = id;
        this.email = email;
        this.telefone = telefone;
    }

    /** Atualiza o status e chama sequencialmente cada serviço concreto. */
    public void alterarStatus(String novoStatus) {
        status = novoStatus;
        String mensagem = "Pedido " + id + ": " + status;
        emailService.enviar(email, mensagem);
        smsService.enviar(telefone, mensagem);
        painelService.atualizar(id, status);
    }

    /** Demonstra as notificações provocadas por uma mudança de status. */
    public static void main(String[] args) {
        new Pedido(101, "cliente@exemplo.com", "62999990000").alterarStatus("ENVIADO");
    }
}
