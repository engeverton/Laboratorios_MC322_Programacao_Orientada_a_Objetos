/*

 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab02.model;

public class EventoShow extends Evento {

    /**
     * Atributos da classe EventoShow
     */ 
    private String artista;
    
    /**
    * Construtor da classe EventocShow
    * @param nome o nome do Evento
    * @param local o local do Evento
    * @param precoIngresso o preço do Ingresso do Evento
    * @param artista o artista do Evento
    * @param organizadora a organizadora do Evento
    * @param data a data do Evento, no formato dd/MM/yyyy
    * @param qtdPessoas a quantidade de pessoas que podem participar do Evento
    * @param artista o artista do Evento
    */
    public EventoShow(String nome, Local local, double precoIngresso, Organizadora organizadora, String data, int qtdPessoas, String artista) {
        super(nome, local, precoIngresso, organizadora, data, qtdPessoas);
        this.artista = artista;

    }

    /**
     * Retorna o artista do Evento
     * @return o artista do Evento
     */
    public String getArtista() {
        return artista;
    }

    /**
     * Altera o artista do Evento para `artista` 
     * @param artista o novo artista do Evento
     */
    public void setArtista(String artista) {
        this.artista = artista;
    }

    /**
    * Retorna uma string contendo a descricao do Evento, com seu nome, artista, local e data
    * @return uma string com a descricao do Evento
    */
    @Override
    public String descricao() {
        return "Show: " + this.nome 
        		+ "\nArtista: " + this.artista
        		+ "\nOrganizadora: " + this.organizadora.getNome()
        		+ "\nData: " + this.data
        		+ "\nLocal: " + this.local.getNome()
        		+ "\n\nPREÇO DO INGRESSO: R$" + this.precoIngresso;
    }
}
