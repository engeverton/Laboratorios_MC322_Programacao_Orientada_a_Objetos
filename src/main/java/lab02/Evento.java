/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab02;

import java.util.ArrayList;
import java.util.List;

import lab02.Excecoes.EventoNaoEncontradoException;
import lab02.Excecoes.IngressoEsgotadoException;

public abstract class Evento {
    /**
     * Atributos da classe Evento
     */
    protected String nome;
    protected Local local;
    protected double precoIngresso;               
    protected Organizadora organizadora;
    protected String data;      
    protected int qtdPessoas;                     
    protected List<Ingresso> ingressosVendidos;       // lista de ingressos vendidos
    protected CaracteristicaDeEvento caracteristica;  // caracteristica especificas do evento, caso necessário 
                                                      // (como Evento em Bar e Evento Música ao vivo)

    /**
     * Construtor da classe Evento
     * @param nome o nome do Evento
     * @param local o local associado ao Evento
     * @param precoIngresso o preço base do Evento
     * @param organizadora a organizadora do Evento
     * @param data a data do Evento no formato dd/MM/yyyy
     * @param qtdPessoas a quantidade de pessoas que podem participar do Evento
     */
    public Evento(String nome, Local local, double precoIngresso, Organizadora organizadora, String data, int qtdPessoas) {
        this.nome = nome;
        this.local = local;
        this.precoIngresso = precoIngresso;
        this.organizadora = organizadora;
        this.data = data;
        this.qtdPessoas = qtdPessoas;
        this.ingressosVendidos = new ArrayList<Ingresso>();
    }
    
    /**
     * Retorna o nome do Evento
     * @return o nome do Evento
     */
    public String getNome(){
        return nome;
    }
    
    /**
     * Altera o nome do Evento para `nome` 
     * @param nome o novo nome do Evento
     */
    public void setNome(String nome){
        this.nome = nome;
    }
    
    /**
     * Retorna o Local do Evento
     * @return o local do Evento
     */
    public Local getLocal() {
        return local;
    }
    
    /**
     * Altera o local do Evento para `local` 
     * @param local o novo local do Evento
     */
    public void setLocal(Local local) {
        this.local = local;
    }

    /**
     * Retorna o preço do ingresso do Evento
     * @return o precoIngresso do Evento
     */
    public double getPrecoIngresso(){
        return precoIngresso;
    }

    /**
     * Altera o precoIngresso do Evento para `precoIngresso` 
     * @param precoIngresso o novo precoIngresso do Evento
     */
    public void setPrecoIngresso(double precoIngresso){
        this.precoIngresso = precoIngresso;
    }

    /**
     * Retorna a data do Evento
     * @return a data do Evento
     */
    public String getData() {
        return data;
    }

    /**
     * Altera a data do Evento para `data` 
     * @param data a nova data do Evento
     */
    public void setData(String data) {
        this.data = data;
        
    }
    
    /**
     * Retorna a quantidade de pessoas que podem participar do Evento
     * @return a quantidade de pessoas que podem participar do Evento
     */
    public int getQtdPessoas() {
        return qtdPessoas;
    }
    
    /**
     * Altera a quantidade de pessoas que podem participar do Evento para `qtdPessoas` 
     * @param qtdPessoas a nova quantidade de pessoas que podem participar do Evento
     */
    public void setQtdPessoas(int qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }
    
    /**
     * Retorna a organizadora do Evento
     * @return a organizadora do Evento
     */
    public Organizadora getOrganizadora() {
        return organizadora;
    }
    
    /**
     * Altera a organizadora do Evento para `organizadora` 
     * @param organizadora a nova organizadora do Evento
     */
    public void setOrganizadora(Organizadora organizadora) {
        this.organizadora = organizadora;
    }

    /**
     * Retorna a caracteristica do Evento
     * @return a caracteristica do Evento
     */
    public String getCaracteristica() {
        return caracteristica.Descricao();
    }
    
    /**
     * Altera a caracteristica do Evento para `caracteristica` 
     * @param caracteristica a nova caracteristica do Evento
     */
    public void setCaracteristica(CaracteristicaDeEvento caracteristica) {
        this.caracteristica = caracteristica;
    }

    /**
     * Retorna a lista de ingressos vendidos do Evento
     * @return a lista de ingressos vendidos do Evento
     */
    public List<Ingresso> getIngressosVendidos() {
        return ingressosVendidos;
    }
    
    /**
     * Retorna a descrição do Evento
     * @return a descrição do Evento com nome e local
     */
    public String descricao(){
        return "Evento: " + this.nome + " - Local: " + this.local;
    }


    /**
     * Adiciona um ingresso a lista ingressosVendidos, e associa o ingresso ao Usuario
    * @param ingresso o ingresso a ser adicionado
    * @param cliente o cliente a ser associado ao ingresso
    */
    public void adicionarIngresso(Ingresso ingresso, Cliente cliente){
        ingressosVendidos.add(ingresso);
        cliente.adicionarIngresso(ingresso); // Associa o ingresso ao usuário
    }

    //implementa tratamento de erros para ingresso esgotado e evento não encotrado
    /**
     * Vende um ingresso para o cliente
     * @param cliente o cliente que está comprando o ingresso
     * @throws IngressoEsgotadoException se não houver mais ingressos disponíveis
     * @throws EventoNaoEncontradoException se o evento não for encontrado
     */
    public void venderIngresso(Cliente cliente) throws IngressoEsgotadoException, EventoNaoEncontradoException {
        //verifica se possuem ingressos disponíveis
        if(qtdPessoas <= ingressosVendidos.size()){
            throw new IngressoEsgotadoException("Ingressos esgotados para o evento: " + this.nome);
        }
        //verifica se o evento existe
        if (this.nome == null || this.nome.isEmpty()) {
            throw new EventoNaoEncontradoException("Evento não encontrado: " + this.nome);
        }

        //adiciona o ingresso à lista de ingresso do cliente e à lista de ingressos vendidos 
        Ingresso ingresso = new Ingresso(this, this.precoIngresso);
        this.adicionarIngresso(ingresso, cliente);
    }


}