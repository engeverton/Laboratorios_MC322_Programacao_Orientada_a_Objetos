package lab01;

import java.util.ArrayList;
import java.util.List;

public class EventoFestival extends Evento {
    private int duracao;
    private List<String> lineup; // Lista de atrações do festival

    /**
     * Construtor da classe EventoFestival
     * @param nome o nome do evento
     * @param local o local do evento
     * @param precoIngresso o preço do ingresso do evento
     * @param duracao a duração do festival em minutos
     */
    public EventoFestival(String nome, Local local, double precoIngresso, int duracao) {
        super(nome, local, precoIngresso);
        this.duracao = duracao;
        this.lineup = new ArrayList<>(); // Inicializa a lista de atrações
    }

    /**
     * retorna a duração do festival em minutos
     * @return a duracao do festival em minutos
     */
    public double getDuracao() {
        return duracao;
    }

    /**
     * Altera a duração do festival
     * @param duracao a nova duração do festival
     */
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    /**
     * Retorna o line-up do festival
     * @return o lineup do festival
     */
    public List<String> getLineup() {
        return lineup;
    }


    /**
     * Adiciona uma atração ao line-up do festival
     * @param atracao a atração a ser adicionada
     */
    public void adicionarAtracao(String atracao) {
        lineup.add(atracao);
    }
    
    /**
     * Imprime o line-up do festival e mais detalhes como nome, local e duração
     */
    public void MostrarLineUp() {
        System.out.println("Festival " + getNome());
        System.out.println("Local: " + getLocal().getNome());
        System.out.println("Duração total: " + duracao + " minutos");
        System.out.println("Line-up do festival:");
        for (String atracao : lineup) {
            System.out.println("- " + atracao);
        }
    }

}
