package lab02.model;

import java.util.ArrayList;
import java.util.List;

import lab02.Excecoes.CapacidadeInsuficienteException;
import lab02.Excecoes.LocalIndisponivelException;

public class Organizadora {

    /**
     * Atributos
     */
    private String nome;
    private int cnpj;
    private String endereco;
    private List<Evento> eventos; // lista de eventos da organizadora

    /**
     * Construtor da classe Organizadora
     * @param nome o nome da organizadora
     * @param cnpj o CNPJ da organizadora
     * @param endereco o endereço da organizadora
     */
    public Organizadora(String nome, int cnpj, String endereco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.eventos = new ArrayList<>();
    }

    /**
     * Retorna o nome da organizadora
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     *  Altera o nome da organizadora para `nome`
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o CNPJ da organizadora
     * @return int return the cnpj
     */
    public int getCnpj() {
        return cnpj;
    }

    /**
     * Altera o CNPJ da organizadora para `cnpj`
     * @param cnpj the cnpj to set
     */
    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * Retorna o endereço da organizadora
     * @return String return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Altera o endereço da organizadora para `endereco`
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Retorna a lista de eventos da organizadora
     * @return a lista de eventos da organizadora
     */
    public List<Evento> getEventos() {
        return eventos;

    }
    /**
     * Altera a lista de eventos da organizadora para `eventos` 
     * @param eventos a nova lista de eventos da organizadora
     */
    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    /**
     * [sobrecarga]Cria uma evento Festival
     * @param nome o nome do evento
     * @param local o local do evento
     * @param precoBase o preço base do evento
     * @param data a data do evento
     * @param qtdPessoas a quantidade de pessoas que podem participar do evento
     * @param lineup a lista de artistas que se apresentarão no evento
     * @param duracao a duração do evento em minutos
     */
    public EventoFestival criarEvento(String nome, Local local, double precoBase, String data, int qtdPessoas,
                                     List<String> lineup, int duracao) throws CapacidadeInsuficienteException, LocalIndisponivelException {
        //Cria o evento
        EventoFestival evento = new EventoFestival(nome, local, precoBase, this, data, qtdPessoas, lineup, duracao);//tenta alocar o evento no local
        local.alocarParaEvento(evento);//se o local estiver alocado, adiciona o evento na lista de eventos da organizadora
        eventos.add(evento);
        return evento;
    }


    /**
     * [sobrecarga]Cria uma evento Jogo
     * @param nome o nome do evento
     * @param local o local do evento
     * @param precoBase o preço base do evento
     * @param data a data do evento
     * @param qtdPessoas a quantidade de pessoas que podem participar do evento
     * @param times os times que se enfrentam no evento, em uma lista
     * @return 
     */
    public EventoJogo criarEvento(String nome, Local local, double precoBase, String data, 
                                    int qtdPessoas, List<String> times) throws CapacidadeInsuficienteException, LocalIndisponivelException {
        //Cria o evento
        EventoJogo evento = new EventoJogo(nome, local, precoBase, this, data, qtdPessoas, times);//tenta alocar o evento no local
        local.alocarParaEvento(evento);//se o local estiver alocado, adiciona o evento na lista de eventos da organizadora
        eventos.add(evento);
        return evento; 
    }

    /**
     * [sobrecarga]Cria uma evento Show
     * @param nome o nome do evento
     * @param local o local do evento
     * @param precoBase o preço base do evento
     * @param data a data do evento
     * @param qtdPessoas a quantidade de pessoas que podem participar do evento
     * @param artista o artista que se apresenta no evento
     */
    public EventoShow criarEvento(String nome, Local local, double precoBase, String data,
                                     int qtdPessoas, String artista) throws CapacidadeInsuficienteException, LocalIndisponivelException {
        //Cria o evento
        EventoShow evento = new EventoShow(nome, local, precoBase, this, data, qtdPessoas, artista); //tenta alocar o evento no local
        local.alocarParaEvento(evento); //se o local estiver alocado, adiciona o evento na lista de eventos da organizadora
        eventos.add(evento);
        return evento;
    }
}
