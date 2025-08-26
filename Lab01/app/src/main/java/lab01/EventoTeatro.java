package lab01;

public class EventoTeatro extends Evento {
    private String tipoPalco;
    private String nomePeca;
    private String genero;


    /**
     * Construtor da classe EventoTeatro
     * @param nome o nome do evento
     * @param local o local do evento
     * @param precoIngresso o preço do ingresso do evento
     * @param genero o genero da peça
     * @param nomePeca o nome da peça
     */
	public EventoTeatro(String nome, Local local, double precoIngresso, String genero, String nomePeca) {
		super(nome, local, precoIngresso);
        this.genero = genero;
        this.nomePeca = nomePeca;
	}
    
    /**
     * @return String return the tipoPalco
     */
    public String getGenero() {
        return tipoPalco;
    }
    
    /**
     * @return String return the nomePeca
     */
    public String getNomePeca() {
        return nomePeca;
    }

    /**
     * Altera o tipo de palco
     * @param tipoPalco o novo tipo de palco
     */
    public void setTipoPalco(String tipoPalco) {
        this.tipoPalco = tipoPalco;
    }

    /**
     * Altera o nome da peça
     * @param nomePeca o novo nome da peça
     */
    public void setNomePeca(String nomePeca) {
        this.nomePeca = nomePeca;
    }

    /**
     * imprime os detalhes do evento como nome, tipo de palco e nome da peça
     */
    public void exibirDetalhes(){
        System.out.println(getNome());
        System.out.println("Local: " + getLocal().getNome());  
        System.out.println("Nome da Peça: " + nomePeca);
        System.out.println("Gênero: " + genero);
        System.out.println("Capacidade: " + getCapacidade() + " pessoas");
    }
}
