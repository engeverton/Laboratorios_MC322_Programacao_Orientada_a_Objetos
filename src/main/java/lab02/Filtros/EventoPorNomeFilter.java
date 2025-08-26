package lab02.Filtros;

import java.util.List;

import lab02.model.Evento;

import java.util.ArrayList;

/**
 * Classe que implementa o filtro de eventos por nome
 */
public class EventoPorNomeFilter implements Filter {
   private String nome;

   /**
    * Construtor da classe EventoPorNomeFilter
    * @param nome o nome a ser filtrado
    */
   public EventoPorNomeFilter(String nome){
      this.nome = nome;
   }
   
   /**
    * [Sobrescrita] Método que filtra os eventos por nome
    * @param eventos a lista de eventos a serem filtrados
    * @return a lista de eventos filtrados
    */
   @Override
   public List<Evento> filter(List<Evento> eventos){
      List<Evento> eventosPorNome = new ArrayList<Evento>(); 
      
      for (Evento evento : eventos) {
         if(evento.getNome().toLowerCase().contains(nome.toLowerCase())) {
            eventosPorNome.add(evento);
         }
      }
      return eventosPorNome;
   }
}
