package exercicio03.refatorado;

/** Dados imutáveis publicados aos observadores quando o status muda. */
public record EventoPedido(int id, String novoStatus) { }
