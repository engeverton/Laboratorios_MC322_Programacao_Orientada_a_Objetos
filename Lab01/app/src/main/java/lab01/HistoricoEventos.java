package lab01;

import java.util.List;
import java.util.ArrayList;

public class HistoricoEventos {
    private List<Evento> eventos;

    /**
     * Construtor da classe HistoricoEventos
     */

    public HistoricoEventos(){
        this.eventos = new ArrayList<Evento>(); // Inicializa a lista de eventos
    }

    /**
     * Adiciona um evento ao histórico de eventos
     * @param evento o evento a ser adicionado
     */
    public void adicionarEvento(Evento evento) {
        eventos.add(evento);
    }

    /**
     * Retorna a lista de eventos
     * @return a lista de eventos
     */
    public List<Evento> getEventos() {
        return eventos;
    }
}
