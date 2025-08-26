/*
 * Material usado na disciplina MC322 - Programação Orientada a Objetos.
 */

package lab02.model;

import java.util.ArrayList;
import java.util.List;

import lab02.Excecoes.IngressoNaoEncontradoException;
import lab02.Excecoes.IngressoNaoPertenceAoClienteException;
import lab02.Excecoes.OfertaNaoEncontradaException;
import lab02.Excecoes.SaldoInsuficienteException;
import lab02.Notificacoes.Email;
import lab02.Notificacoes.Notificavel;
import lab02.Notificacoes.SMS;

/**
 * Classe que representa um cliente do sistema.
 * 
 */
public class Cliente implements Comparable<Cliente> {

    private String nome;
    private String email;
    private String telefone;
    private List<Ingresso> ingressos;
    private List<Notificavel> notificaveis;
    private double saldo;

    /**
     * Construtor da classe Cliente.
     * Inicializa os dados do cliente e os canais de notificação (email e SMS).
     *
     * @param nome     nome do cliente
     * @param email    email do cliente
     * @param telefone telefone do cliente
     */
    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.ingressos = new ArrayList<>();
        this.notificaveis = new ArrayList<>();
        notificaveis.add(new Email(email));
        notificaveis.add(new SMS(telefone));
        this.saldo = 0.0;
    }

    /** @return o nome do cliente */
    public String getNome() {
        return nome;
    }

    /**
     * Define um novo nome para o cliente.
     * @param nome novo nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** @return o email do cliente */
    public String getEmail() {
        return email;
    }

    /**
     * Define um novo email para o cliente.
     * @param email novo email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /** @return o telefone do cliente */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define um novo telefone para o cliente.
     * @param telefone novo telefone
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /** @return o saldo atual do cliente */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Adiciona um valor ao saldo do cliente.
     * @param valor valor a ser adicionado
     */
    public void adicionarSaldo(double valor) {
        saldo += valor;
    }

    /**
     * Remove um valor do saldo do cliente.
     * @param valor valor a ser removido
     */
    public void removerSaldo(double valor) {
        saldo -= valor;
    }

    /**
     * Envia uma notificação para todos os canais cadastrados do cliente.
     * @param mensagem mensagem a ser enviada
     */
    public void notificar(String mensagem) {
        for (Notificavel canal : notificaveis) {
            canal.notificacao(mensagem);
        }
    }

    /** @return lista de ingressos do cliente */
    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    /**
     * Adiciona um ingresso ao cliente e notifica sobre a compra.
     * @param ingresso ingresso a ser adicionado
     */
    public void adicionarIngresso(Ingresso ingresso) {
        ingressos.add(ingresso);
        notificar(nome + " sua compra para o evento: " + ingresso.getEvento().getNome()
                + " no dia " + ingresso.getEvento().getData() + " foi realizada com sucesso!");
    }

    /**
     * Adiciona vários ingressos ao cliente e notifica sobre cada compra.
     * @param novosIngressos lista de ingressos
     */
    public void adicionarIngresso(List<Ingresso> novosIngressos) {
        for (Ingresso ingresso : novosIngressos) {
            ingressos.add(ingresso);
            notificar(nome + " sua compra para o evento: " + ingresso.getEvento().getNome()
                    + " no dia " + ingresso.getEvento().getData() + " foi realizada com sucesso!");
        }
    }

    /**
     * Remove um ingresso do cliente.
     * @param ingresso ingresso a ser removido
     */
    public void removerIngresso(Ingresso ingresso) {
        ingressos.remove(ingresso);
    }

    /**
     * Cancela um ingresso do cliente, remove da lista e reembolsa o valor
     *
     * @param evento evento do ingresso a ser cancelado
     * @throws IngressoNaoEncontradoException se o ingresso não for encontrado
     */
    public void cancelarIngresso(Evento evento) throws IngressoNaoEncontradoException {
        if (ingressos.isEmpty()) {
            throw new IngressoNaoEncontradoException("Nenhum ingresso encontrado.");
        }
        for (Ingresso ingresso : ingressos) {
            if (ingresso.getEvento().equals(evento)) {
                notificar(nome + " seu ingresso para o evento: " + ingresso.getEvento().getNome()
                        + " no dia " + ingresso.getEvento().getData() + " foi CANCELADO");
                adicionarSaldo(ingresso.getPreco());
                removerIngresso(ingresso);
                return;
            }
        }
        throw new IngressoNaoEncontradoException("Ingresso não encontrado.");
    }

    /**
     * Compara se dois clientes possuem ingressos para o mesmo evento
     *
     * @param outroCliente outro cliente a ser comparado
     * @return 1 se possuem ingresso para o mesmo evento, 0 caso contrário
     */
    @Override
    public int compareTo(Cliente outroCliente) {
        for (Ingresso ingresso : ingressos) {
            for (Ingresso outroIngresso : outroCliente.getIngressos()) {
                if (ingresso.getEvento().equals(outroIngresso.getEvento())) {
                    return 1;
                }
            }
        }
        return 0;
    }

    /**
     * Coloca um ingresso do cliente à venda no marketplace.
     *
     * @param ingresso ingresso a ser vendido
     * @param precoPedido preço desejado
     * @param marketplace marketplace onde será colocado à venda
     * @throws IngressoNaoPertenceAoClienteException se o ingresso não pertencer ao cliente
     */
    public void oferecerIngressoParaVenda(Ingresso ingresso, double precoPedido, Marketplace marketplace)
            throws IngressoNaoPertenceAoClienteException {
        if (ingressos.contains(ingresso)) {
            removerIngresso(ingresso);
            marketplace.receberOferta(ingresso, precoPedido, this);
            notificar(nome + " você ofereceu um ingresso para venda no Marketplace.");
        } else {
            throw new IngressoNaoPertenceAoClienteException(
                    "Ingresso não encontrado na lista de ingressos do cliente.");
        }
    }

    /**
     * Realiza a compra de um ingresso no marketplace.
     *
     * @param oferta oferta selecionada
     * @param marketplace marketplace onde está a oferta
     * @throws OfertaNaoEncontradaException se a oferta não existir
     * @throws SaldoInsuficienteException se o cliente não tiver saldo suficiente
     */
    public void comprarIngressoNoMarketplace(OfertaIngresso oferta, Marketplace marketplace)
            throws OfertaNaoEncontradaException, SaldoInsuficienteException {
        if (marketplace.listarOfertas().contains(oferta)) {
            double precoTotal = oferta.getPrecoPedido();
            if (this.saldo < precoTotal) {
                throw new SaldoInsuficienteException("Saldo insuficiente para realizar a compra.");
            }
            marketplace.processarCompra(this, oferta);
        } else {
            throw new OfertaNaoEncontradaException("Oferta de ingresso não encontrada no marketplace.");
        }
    }
}
