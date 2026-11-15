package exercicio03.refatorado;

import java.util.ArrayList;
import java.util.List;

/** Observador que mantém os eventos recebidos como histórico do pedido. */
public class ObservadorHistoricoPedido implements ObservadorPedido {
    /** Eventos de status registrados em ordem de recebimento. */
    private final List<EventoPedido> eventos = new ArrayList<>();

    /** Acrescenta ao histórico o evento publicado pelo pedido. */
    @Override
    public void atualizar(EventoPedido evento) {
        eventos.add(evento);
    }

    /** Devolve uma cópia imutável do histórico acumulado. */
    public List<EventoPedido> getEventos() {
        return List.copyOf(eventos);
    }
}
