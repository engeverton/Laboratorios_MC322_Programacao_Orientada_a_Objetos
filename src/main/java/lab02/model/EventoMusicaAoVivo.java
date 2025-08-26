package lab02.model;

public class EventoMusicaAoVivo extends CaracteristicaDeEvento{

    /**
     * Atributos da classe EventoMusicaAoVivo
     */
    private String nomeDoArtista;
    private String generoMusical;

    /**
     * Construtor da classe EventoMusicaAoVivo
     * @param nomeDoArtista Nome do artista que irá se apresentar
     * @param generoMusical Gênero musical do artista
     */
    public EventoMusicaAoVivo(String nomeDoArtista, String generoMusical) {
        this.nomeDoArtista = nomeDoArtista;
        this.generoMusical = generoMusical;
    }

    /**
     * Retorna o nome do artista que irá se apresentar
     * @return o nome do artista
     */
    public String getNomeDoArtista() {
        return nomeDoArtista;
    }

    /**
     * Altera o nome do artista que irá se apresentar
     * @param nomeDoArtista o novo nome do artista
     */
    public void setNomeDoArtista(String nomeDoArtista) {
        this.nomeDoArtista = nomeDoArtista;

    }

    /**
     * Retorna o gênero musical do artista
     * @return o gênero musical do artista
     */
    public String getGeneroMusical() {
        return generoMusical;
    }

    /**
     * Altera o gênero musical do artista
     * @param generoMusical o novo gênero musical do artista
     */
    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    /**
     * Retorna uma string contendo a descrição do evento, com o nome do artista e o gênero musical
     * @return uma string com a descrição do evento
     */
    @Override
    public String Descricao() {
        return "Música ao vivo com: " + nomeDoArtista + ", Gênero: " + generoMusical;
    }
}
