/*
 * Ingresso.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab02.model;

/**
 * Contém a estrutura de implementação de um Ingresso.
 */
public class Ingresso {

    /**
     * Atributos da classe Ingresso
     */
    private Evento evento;
    private double preco;

    /**
     * Construtor da classe Ingresso
     * @param evento o evento associado ao Ingresso
     * @param preco o preço do Ingresso
     */
    public Ingresso(Evento evento, double preco) {
        this.evento = evento;
        this.preco = preco;
    }

    
    /**
     * Retorna o evento associado ao Ingresso
     * @return o evento associado ao Ingresso
     */
    public Evento getEvento() {
        return evento;
    }
    
    /**
     * Define o evento associado ao Ingresso
     * @param evento o evento associado ao Ingresso
     */
    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    /**
     * Retorna o preço do Ingresso
     * @return o preço do Ingresso
     */
    public double getPreco() {
        return this.preco;
    }

    /**
     * Define o preço do Ingresso
     * @param preco o preço do Ingresso
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
		return getEvento().getNome() + " - " + "R$ " + getPreco();
	}
}
