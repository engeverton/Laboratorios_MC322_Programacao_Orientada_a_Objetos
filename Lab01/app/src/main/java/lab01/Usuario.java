/*
 * Usuario.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */
package lab01;

import java.util.ArrayList;
import java.util.List;

/**
 * Contém a estrutura de implementação de um Usuario.
 * 
 * @author Everton Mendes de Almeida - 260426
 */
public class Usuario {
    private String nome;
    private String email;
    private List<Ingresso> ingressosComprados; // Lista de ingressos comprados pelo usuário

    /**
     * Construtor da classe Usuario
     * @param nome o nome do usuário
     * @param email o email do usuário
     */
    public Usuario(String nome, String email){
        this.nome = nome;
        this.email = email;
        this.ingressosComprados = new ArrayList<>(); // Inicializa a lista de ingressos
    }

    /**
     * Retorna o nome do usuário
     * @return o nome do usuário
     */
    public String getNome(){
        return nome;
    }

    /**
     * Altera o nome do usuário para `nome` 
     * @param nome o novo nome do usuário
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    /**
     * Retorna o email do usuário
     * @return o email do usuário
     */
    public String getEmail() {
        return email;
    }

    /**
     * Altera o email do usuário para `email`
     * @param email o novo email do usuário
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Adiciona um ingresso à lista de ingressos comprados pelo usuário
     * @param ingresso o ingresso a ser adicionado
     */
    public void adicionarIngresso(Ingresso ingresso) {
        ingressosComprados.add(ingresso); 
    }

    /**
     * Retorna a lista de ingressos comprados pelo usuário
     * @return a lista de ingressos comprados pelo usuário
    */
    public List<Ingresso> getIngresso() {
        return ingressosComprados;
    }

}
