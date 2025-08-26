/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */


package lab02.model;

import java.util.List;

public class EventoJogo extends Evento {
        
    private List<String> times;

    /**
    * Construtor da classe EventoEsporte
    * @param nome o nome do Evento
    * @param local o local do Evento
    * @param precoIngresso o preço do Ingresso do Evento
    * @param organizadora a organizadora do Evento
    * @param data a data do Evento, no formato dd/MM/yyyy
    * @param qtdPessoas a quantidade de pessoas que podem participar do Evento
    * @param times a lista com os nomes dos times que se enfrentarão no Evento
    */
    public EventoJogo(String nome, Local local, double precoIngresso, Organizadora organizadora, String data, int qtdPessoas, List<String> times) {
        super(nome, local, precoIngresso, organizadora, data, qtdPessoas);
        this.times = times;
    }
    
    /**
    * Retorna o preço do Ingresso do Evento
    * @return o preço do Ingresso do Evento
    */
    @Override
    public double getPrecoIngresso() {
        return this.precoIngresso;
    }

    /**
     * Retorna a lista com os nomes dos times que se enfrentam no Evento
     * @return a lista com os nomes dos times do Evento
     */
    public List<String> getTimes() {
        return times;
    }

    /**
     * Retorna uma string contendo a descricao do Evento, com seu nome, times que se enfrentarao, local e data
     * @return uma string com a descri o do Evento
     */
    @Override
    public String descricao() {
        return "Jogo: " + this.nome 
        		+ "\nOrganizadora: " + this.organizadora.getNome()
        		+ "\nData: " + this.data
        		+ "\nLocal: " + this.local.getNome()
        		+ "\n\nTimes: " + this.times
        		+ "\n\nPREÇO DO INGRESSO: R$" + this.precoIngresso;
        		
    }
    
}
