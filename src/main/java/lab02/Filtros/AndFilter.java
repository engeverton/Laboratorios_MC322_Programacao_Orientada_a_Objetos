package lab02.Filtros;

import java.util.List;

import lab02.model.Evento; 

/**
 * Classe que implementa uma combinacao de dois filtros, que usa a lógica "AND"
 */
public class AndFilter implements Filter {
    private Filter primeiroFilter;
    private Filter segundoFilter;

    /**
     * Construtor da classe AndFilter
     * @param primeiroFilter o primeiro filtro a ser aplicado
     * @param segundoFilter o segundo filtro a ser aplicado
     */
    public AndFilter(Filter primeiroFilter, Filter segundoFilter) {
        this.primeiroFilter = primeiroFilter;
        this.segundoFilter = segundoFilter;
    }

    /**
     * Método que filtra os eventos usando ambos os filtros
     * @param eventos a lista de eventos a serem filtrados
     * @return a lista de eventos filtrados
     */
    @Override
    public List<Evento> filter(List<Evento> eventos) {
        List<Evento> primeiroFiltrado = primeiroFilter.filter(eventos);
        return segundoFilter.filter(primeiroFiltrado);
    }
    
}
