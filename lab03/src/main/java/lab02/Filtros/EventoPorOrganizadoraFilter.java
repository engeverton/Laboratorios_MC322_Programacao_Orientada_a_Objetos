package lab02.Filtros;

import java.util.List;

import lab02.model.Evento;

import java.util.ArrayList;

/**
 * Classe que implementa o filtro de eventos por organizadora
 */
public class EventoPorOrganizadoraFilter implements Filter {
    private String organizadora;

    /**
     * Construtor da classe EventoPorOrganizadoraFilter
     * @param organizadora a organizadora a ser filtrada
     */
    public EventoPorOrganizadoraFilter(String organizadora) {
        this.organizadora = organizadora;
    }

    /**
     * [Sobrescrita] Método que filtra os eventos por organizadora
     * @param eventos a lista de eventos a serem filtrados
     * @return a lista de eventos filtrados
     */
    @Override
    public List<Evento> filter(List<Evento> eventos) {
        List<Evento> eventosPorOrganizadora = new ArrayList<Evento>();

        for (Evento evento : eventos) {
            if (evento.getOrganizadora().getNome().toLowerCase().contains(organizadora.toLowerCase())) {
                eventosPorOrganizadora.add(evento);
            }
        }
        return eventosPorOrganizadora;
    }
    
}
