package lab01;

public class EventoEsporte extends Evento{
    private String modalidade;
    private int qtdPessoas;
    private String time1;
    private String time2;

    /**
     * Construtor da classe EventoEsporte
     * @param nome o nome do evento
     * @param local o local do evento
     * @param precoIngresso o preço do ingresso do evento
     * @param modalidade a modalidade do esporte
     * @param qtdPessoas a quantidade de pessoas por time
     * @param time1 o nome do time 1
     * @param time2 o nome do time 2
     */

    public EventoEsporte(String nome, Local local, double precoIngresso, String modalidade, int qtdPessoas, String time1, String time2) {
        super(nome, local, precoIngresso);
        this.modalidade = modalidade;
        this.qtdPessoas = qtdPessoas;
        this.time1 = time1;
        this.time2 = time2;
    }

    /**
     * retorna a modalidade do esporte
     * @return a modalidade do esporte
     */
    public String getModalidade() {
        return modalidade;
    }

    /**
     * Altera a modalidade do esporte
     * @param modalidade a nova modalidade do esporte
     */
    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    /**
     * retorna a quantidade de pessoas por time
     * @return a quantidade de pessoas por time
     */
    public int getQtdPessoas() {
        return qtdPessoas;
    }

    /**
     * Altera a quantidade de pessoas por time
     * @param qtdPessoas a nova quantidade de pessoas por time
     */
    public void setQtdPessoas(int qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }

    /**
     * retorna o nome do time 1
     * @return o nome do time 1
     */
    public String getTime1() {
        return time1;
    }

    /**
     * Altera o nome do time 1
     * @param time1 o novo nome do time 1
     */
    public void setTime1(String time1) {
        this.time1 = time1;
    }

    /**
     * retorna o nome do time 2
     * @return o nome do time 2
     */
    public String getTime2() {
        return time2;
    }

    /**
     * Altera o nome do time 2
     * @param time2 o novo nome do time 2
     */
    public void setTime2(String time2) {
        this.time2 = time2;
    }

    /**
     * imprime os detalhes do evento como nome, local, modalidade, quantidade de pessoas por time e os times que disputarão o evento
     */
    public void exibirDetalhes(){
        System.out.println(getNome());
        System.out.println("Modalidade: " + modalidade) ;
        System.out.println("Quantidade de pessoas por time: " + qtdPessoas + " pessoas");
        System.out.println("Times: " + time1 + " x " + time2);
        System.out.println("Local: " + getLocal().getNome());
    }

}





