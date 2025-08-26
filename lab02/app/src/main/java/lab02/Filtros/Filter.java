package lab02.Filtros;

import java.util.List;
import lab02.Evento;

/**
 * Interface que define o método filter para filtrar eventos
 */
public interface Filter{
   public List<Evento> filter(List<Evento> eventos);
}