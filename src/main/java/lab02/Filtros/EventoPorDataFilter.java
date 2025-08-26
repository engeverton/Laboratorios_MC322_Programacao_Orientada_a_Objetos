package lab02.Filtros;

import java.util.List; // Import List from java.util

import lab02.model.Evento;

import java.util.ArrayList; // Import ArrayList from java.util

/**
 * Classe que implementa o filtro de eventos por data
 */
public class EventoPorDataFilter implements Filter {
    private String data;

    /**
     * Construtor da classe EventoPorDataFilter
     * @param data a data a ser filtrada
     */
    public EventoPorDataFilter(String data) {
        this.data = data;
    }

    /**
     * [Sobrescrita]Método que filtra os eventos por data
     * @param eventos a lista de eventos a serem filtrados
     * @return a lista de eventos filtrados
     */
    public List<Evento> filter(List<Evento> eventos) {
        List<Evento> eventosPorData = new ArrayList<Evento>();

        for (Evento evento : eventos) {
            if (evento.getData().equalsIgnoreCase(data)) {
                eventosPorData.add(evento);
            }
        }
        return eventosPorData;
    }
    
}
