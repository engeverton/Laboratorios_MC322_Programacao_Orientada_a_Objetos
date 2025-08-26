package lab02;

public class EventoEmBar extends CaracteristicaDeEvento {
    /**
     * Atributos da classe EventoEmBar
     */
    private String nome;
    private String inicio;
    private String duracao;

    /**
     * Construtor da classe EventoEmBar
     * @param nome o nome do Evento
     * @param inicio o hoário de início do evento
     * @param duracao a duração do evento em horas, no formato "HH:mm"
     */
    public EventoEmBar(String nome, String inicio, String duracao) {
        this.nome = nome;
        this.inicio = inicio;
        this.duracao = duracao;
    }

    /**
     * Retorna o nome do evento
     * @return o nome do evento
     */
    public String getNome() {
        return nome;
    }

    /**
     * Altera o nome do evento para `nome` 
     * @param nome o novo nome do evento
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o horário de início do evento
     * @return o horário de início do evento
     */
    public String getInicio() {
        return inicio;
    }

    /**
     * Altera o horário de início do evento para `inicio` 
     * @param inicio o novo horário de início do evento
     */
    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    /**
     * Retorna a duração do evento
     * @return a duração do evento
     */
    public String getDuracao() {
        return duracao;
    }

    /**
     * Altera a duração do evento para `duracao` 
     * @param duracao a nova duração do evento
     */
    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    /**
     * {Sobrescrita] Retorna a descrição dessa característica de evento
     * @return a descrição do evento em bar
     */
    @Override
    public String Descricao() {
        return "Evento no bar: " + nome + ", Happy Hour Inicio: "  + inicio + ", Duração: " + duracao;
    }
    
}
