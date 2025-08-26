/*
 * Local.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */
package lab02;

import java.util.List;

import lab02.Excecoes.CapacidadeInsuficienteException;
import lab02.Excecoes.LocalIndisponivelException;
import java.util.ArrayList;

/**
 * Contém a estrutura de implementação de um Local.
 * 
 * @author Everton Mendes de Almeida - 260426
 */
public class Local{
    /**
     * Atributos da classe Local
     */
    private String nome;
    private double capacidadeMaxima;
    private List<Local> locaisAlocados;

    /**
     * Construtor da classe Local
     * @param nome o nome do local
     * @param capacidadeMaxima a capacidade máxima do local
     */
    public Local(String nome, double capacidadeMaxima){
        this.nome = nome;
        this.capacidadeMaxima = capacidadeMaxima;
        this.locaisAlocados = new ArrayList<>();
    }

    /**
     * Retorna o nome do evento
     * @return o nome do evento
     */
    public String getNome(){
        return nome;
    }

    /**
     * Altera o nome do evento para `nome` 
     * @param nome o novo nome do evento
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    /**
     * Retorna a capacidade do local
     * @return a capacidade do local
     */
    public double getCapacidade(){
        return capacidadeMaxima;
    }
    
    /**
     * Altera a capacidade máxima do local para `capacidadeMaxima` 
     * @param capacidadeMaxima a nova capacidade máxima do local
     */
    public void setCapacidade(double capacidadeMaxima){
        this.capacidadeMaxima = capacidadeMaxima;
    }

    /**
     * Retorna a lista de locais alocados
     * @return a lista de locais alocados
     */
    public List<Local> getLocaisAlocados(){
        return locaisAlocados;
    }

    /**
     * Aloca o local para um evento
     * @param evento o evento a ser alocado
     * @throws CapacidadeInsuficienteException se a capacidade do local for insuficiente
     * @throws LocalIndisponivelException se o local já estiver alocado
     */
    public void alocarParaEvento(Evento evento) throws CapacidadeInsuficienteException, LocalIndisponivelException{
        // Verifica se o local tem a capacidade desejada para o evento
        if(evento.getLocal().getCapacidade() < evento.getQtdPessoas()){
            throw new CapacidadeInsuficienteException("Capacidade insuficiente para o evento.");
        }
        // Verifica se o local já está alocado para outro evento a partir da lista de locais alocados 
        for (Local local : locaisAlocados) {
            if (local.getNome().equals(evento.getLocal().getNome())) {
                throw new LocalIndisponivelException("Local está indisponível");
            }
        }
        // Se não houve erro, adiciona o local à lista de locais alocados
        evento.setLocal(this);
        locaisAlocados.add(evento.getLocal());
    }
}
