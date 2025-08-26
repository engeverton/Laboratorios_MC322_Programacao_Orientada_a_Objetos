/*
* Ingresso.java
* 
* Material usado na disciplina MC322 - Programação orientada a objetos.
*/

package lab01;

import java.util.Random;

/**
* Contém a estrutura de implementação de um Ingresso.
* 
* @author Everton Mendes de Almeida- 260426
*/
public abstract class Ingresso {
    private Evento evento;
    private String codigo;

    /**
    * Construtor da classe Ingresso
    * @param evento o evento associado ao Ingresso
    */
    public Ingresso(Evento evento){
        this.evento = evento;
        this.codigo = gerarCodigoAleatorio();
    }
    
    /**
    * Retorna o evento associado ao Ingresso
    * @return o evento associado ao Ingresso
    */
    public Evento getEvento() {
        return evento;
    }

    /**
    * Altera o evento associado ao Ingresso para `evento`
    * @param evento o novo evento associado ao Ingresso
    */
    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    /**
     * Retorna o código do Ingresso
     * @return o código do Ingresso
     */
    public String getCodigo() {
        return codigo;
    }

    /**
    * Retorna o preço do Ingresso
    * @return o preço do Ingresso
    */

    /**
    * Gera um código aleatório de 6 dígitos
    * @return String representando o código
    */
    private String gerarCodigoAleatorio() {
        Random random = new Random();
        int numero = 100000 + random.nextInt(900000); // Gera um número aleatório entre 100000 e 999999
        return String.valueOf(numero);
    }

    public abstract double getPreco();

}
