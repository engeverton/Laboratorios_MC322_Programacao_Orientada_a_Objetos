/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */
package lab02;

import java.util.ArrayList;
import java.util.List;

import lab02.Excecoes.IngressoNaoEncontradoException;
import lab02.Notificacoes.Email; // Import the Email class
import lab02.Notificacoes.SMS;

import lab02.Notificacoes.Notificavel;

public class Cliente implements Comparable<Cliente> {

    /**
     * Atributos da classe cliente
     */
    private String nome;
    private String email;
    private String telefone;
    private List<Ingresso> ingressos;       // lista de ingressos do cliente
    private List<Notificavel> notificaveis; // lista de canais de notificação

    /**
     * Construtor da classe cliente
     * @param nome     o nome do cliente
     * @param email    o email do cliente
     * @param telefone o telefone do cliente
     */
    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.ingressos = new ArrayList<>();
        this.notificaveis = new ArrayList<>();
        notificaveis.add(new Email(email));   // adiciona o email à lista de canais de notificações
        notificaveis.add(new SMS (telefone)); // adiciona o telefone à lista de canais de notificações
    }

    /**
     * Retorna o nome do cliente
     * @return o nome do cliente
     */
    public String getNome(){
        return nome;
    }

    /**
     * Altera o nome do evento para `nome` 
     * @param nome o novo nome do cliente
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    /**
     * Retorna o email do cliente
     * @return o email do cliente
     */
    public String getEmail() {
        return email;
    }   

    /**
     * Altera o email do cliente para `email` 
     * @param email o novo email do cliente
     */
    public void setEmail(String email) {
        this.email = email;
    }  
    
    /**
     * Retorna o telefone do cliente
     * @return o telefone do cliente
     */
    public String getTelefone() {
        return telefone;
    }
    
    /**
     * Altera o telefone do cliente para `telefone` 
     * @param telefone o novo telefone do cliente
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    /**
     * Envia uma notificação para todos os canais de notificação do cliente
     * @param mensagem a mensagem a ser enviada
     */
    public void notificar(String mensagem) {
        for (Notificavel canal : notificaveis) {
            canal.notificacao(mensagem);
        }
    }

    /**
     * Retorna a lista de ingressos do cliente
     * @return a lista de ingressos do cliente
     * 
    */
    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    /**
     * [sobrecarga]Adiciona um ingresso à lista de ingressos do cliente
     * @param ingresso o ingresso a ser adicionado
     */
    public void adicionarIngresso(Ingresso ingresso) {
        ingressos.add(ingresso); 
        // Envia uma notificação para o cliente informando que a compra foi realizada com sucesso
        notificar(nome + " sua compra para o evento: " + ingresso.getEvento().getNome()
                                               + " no dia " + ingresso.getEvento().getData() 
                                               + " foi realizada com sucesso!");
    }

    /**
     * [sobrecarga]Adiciona elementos de uma lista de ingressos à lista de ingressos do cliente
     * @param novosIngressos a lista de ingressos a ser adicionada
     */
    public void adicionarIngresso(List<Ingresso> novosIngressos) {
        for (Ingresso ingresso : novosIngressos) {
            ingressos.add(ingresso);
            // Envia uma notificação para o cliente informando que a compra foi realizada com sucesso
            notificar(nome + " sua compra para o evento: " + ingresso.getEvento().getNome()
                                               + " no dia " + ingresso.getEvento().getData() 
                                               + " foi realizada com sucesso!");
        }
    }

    /**
     * Remove um ingresso da lista de ingressos do cliente
     * @param ingresso o ingresso a ser removido
     */
    public void removerIngresso(Ingresso ingresso) {
        ingressos.remove(ingresso);
    }

    /**
     * Cancela um ingresso do cliente
     * @param evento o evento do ingresso a ser cancelado
     * @throws IngressoNaoEncontradoException se o ingresso não for encontrado
     */
    public void cancelarIngresso(Evento evento) throws IngressoNaoEncontradoException{
        if (ingressos.isEmpty()) {
            throw new IngressoNaoEncontradoException("Nenhum ingresso encontrado.");
        }
        for (Ingresso ingresso : ingressos) {
            if (ingresso.getEvento().equals(evento)) {
                // Envia uma notificação para o cliente informando que o ingresso foi cancelado
                notificar(nome + " seu ingresso para o evento: " + ingresso.getEvento().getNome()
                                               + " no dia " + ingresso.getEvento().getData() 
                                               + " foi CANCELADO");
                removerIngresso(ingresso);  //remove o ingresso da lista de ingressos do cliente
                return;
            }
        }
        throw new IngressoNaoEncontradoException("Ingresso não encontrado.");
    }

    /**
     * [sobescrita] Verrifica se dois clientes tem ingressos para o mesmo evento
     * @return 1 se o cliente tem ingressos para o mesmo evento, 0 caso contrário
     */
    @Override
    public int compareTo(Cliente outroCliente) {
        for(Ingresso ingresso : ingressos){  
            for(Ingresso outroIngresso : outroCliente.getIngressos()){
                if(ingresso.getEvento().equals(outroIngresso.getEvento())){
                    return 1;
                }
            }
        }
        return 0;
    }
}