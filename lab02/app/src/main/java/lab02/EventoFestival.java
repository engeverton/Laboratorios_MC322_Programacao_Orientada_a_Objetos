/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab02;

import java.util.List;

public class EventoFestival extends Evento {

    /**
     * Atributos da classe EventoFestival
     */
    private List<String> lineup;
    private int duracao;
    
    /**
    * Construtor da classe EventoFestival
    * @param nome o nome do Evento
    * @param local o local do Evento
    * @param precoIngresso o preço do Ingresso do Evento
    * @param organizadora a organizadora do Evento
    * @param data a data do Evento no formato dd/MM/yyyy
    * @param qtdPessoas a quantidade de pessoas que podem participar do Evento
    * @param lineup a lista com os nomes dos artistas que se apresentarão no Festival
    * @param duracao a duração do Festival em dias
    */
    public EventoFestival(String nome, Local local, double precoIngresso, Organizadora organizadora,
                             String data, int qtdPessoas,List<String> lineup, int duracao) {
        super(nome, local, precoIngresso, organizadora, data, qtdPessoas);
        this.lineup = lineup;
        this.duracao = duracao;
    }

    /**
    * Retorna a lista com os nomes dos artistas que se apresentarão no Festival
    * @return a lista com os nomes dos artistas do Festival
    */
    public List<String> getLineup() {
        return lineup;
    }
    
    /**
    * Retorna a duracao do Festival em dias
    * @return a duracao do Festival
    */
    public int getDuracao() {
        return duracao;
    }

    /**
     * Altera a duracao do Festival para `duracao`
     * @param duracao a nova duracao do Festival
     */

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    /**
     * Retorna uma string contendo a descricao do Festival, com seu nome, lineup, local e duracao
     * @return uma string com a descri o do Festival
     */
    public String descricao() {
        return "Festival: " + this.nome + "\n- Lineup: " + this.lineup 
                            + "\n- Local: " + this.local.getNome() + "\n- Duração: " + this.duracao + " min"
                            + "\n- Data: " + this.data;
    }
}
