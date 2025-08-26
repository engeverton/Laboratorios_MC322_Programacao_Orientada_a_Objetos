package lab02.Filtros;

import java.util.List; // Import List from java.util

import lab02.model.Evento;

import java.util.ArrayList; // Import ArrayList from java.util

/**
 * Classe que implementa o filtro de eventos por local
 */
public class EventoPorLocalFilter implements Filter {
    private String local;

    /**
     * Construtor da classe EventoPorLocalFilter
     * @param local o local a ser filtrado
     */
    public EventoPorLocalFilter(String local) {
        this.local = local;
    }

    /**
     * [Sobrescrita] Método que filtra os eventos por local
     * @param eventos a lista de eventos a serem filtrados
     * @return a lista de eventos filtrados
     */
    @Override
    public List<Evento> filter(List<Evento> eventos) {
        List<Evento> eventosPorLocal = new ArrayList<Evento>();

        for (Evento evento : eventos) {
            if (evento.getLocal().getNome().equalsIgnoreCase(local)) {
                eventosPorLocal.add(evento);
            }
        }
        return eventosPorLocal;
    }
    
}
