package lab01;

public class EventoShow extends Evento implements FiltroEventos{
    private String artista;
    private String data;

    
    /**
     * Construtor da classe EventoShow
     * @param nome o nome do evento
     * @param local o local do evento
     * @param precoIngresso o preço do ingresso do evento
     * @param artista a artista do show
     * @param data a data do show no formato dd/mm/aaaa
     */
    public EventoShow(String nome, Local local, double precoIngresso, String artista, String data) {
        super(nome, local, precoIngresso);
        this.artista = artista;
        this.data = data;
    }

    /**
     * Altera o artista do show
     * @param artista o novo artista do show
     */
    public void setArtista(String artista) {
        this.artista = artista;
    }

    /**
     * altera a data do show
     * @param data a nova data do show
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * retorna o artista do show
     * @return o artista do show
     */
    public String getArtista() {
        return artista;
    }

    /**
     * retorna a data do show
     * @return a data do show
     */
    public String getData() {
        return data;
    }

    /**
     * imprime os detalhes do evento como nome, local, duração do show e gênero musical
     */
    public void exibirDetalhes(){
        System.out.println(getNome()); 
        System.out.println("Artista: " + artista) ;
        System.out.println("Local: " + getLocal().getNome());
        System.out.println("Data : " + data);
    } 
}

