/*
* Evento.java
* 
* Material usado na disciplina MC322 - Programação orientada a objetos.
*/

package lab01;

import java.util.ArrayList;
import java.util.List;

/**
 * Contém a estrutura de implementação de um Evento.
* 
* @author Everton Mendes de Almeida - 216180
*/
public abstract class Evento {
    private String nome;
    private Local local;
    private double precoIngresso;
    private List<Ingresso> ingressosVendidos;

    /**
     * Construtor da classe Evento
    * @param nome o nome do Evento
    * @param local o local associado ao Evento
    * @param precoIngresso o preço do ingresso
    */
    public Evento(String nome, Local local, double precoIngresso){
        this.nome = nome;
        this.local = local;
        this.precoIngresso = precoIngresso;
        this.ingressosVendidos = new ArrayList<Ingresso>();
    }


    /**
     * Retorna o local do Evento
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
     * Retorna o preço do ingresso do Evento
    * @return o precoIngresso do Evento
    */
    public double getPrecoIngresso(){
        return precoIngresso;
    }

    /**
     * retorna a capacidade do local
     * @return a capacidade do local
     */
    public double getCapacidade(){
        return local.getCapacidade();
    }

    /**
     * Altera o precoIngresso do Evento para `precoIngresso` 
    * @param precoIngresso o novo precoIngresso do Evento
    */
    public void setPrecoIngresso(double precoIngresso){
        this.precoIngresso = precoIngresso;
    }

    /**
     * Retorna a lista de ingressos vendidos do evento
     * @return a lista de ingressos vendidos
     */
    public List<Ingresso> getIngressosVendidos(){
        return ingressosVendidos;
    }

    /**
     * Adiciona um ingresso a lista ingressosVendidos, e associa o ingresso ao Usuario
    * @param ingresso 
    * @param usuario
    */
    public void adicionarIngresso(Ingresso ingresso, Usuario usuario){
        ingressosVendidos.add(ingresso);
        usuario.adicionarIngresso(ingresso); // Associa o ingresso ao usuário
    }

    /**
     * Calcula o faturamento, somando o preço de cada ingresso vendido, armazenado na lista ingressosVendidos
    * @return o total de faturamento do evento
    */
    public double calcularFaturamento(){
        double total = 0;
        for (Ingresso ingresso : ingressosVendidos) {
        total += ingresso.getPreco(); // Soma-se o preço de cada ingresso vendido
        }
        return total;
    }
}
