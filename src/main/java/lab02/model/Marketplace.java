package lab02.model;

import java.util.ArrayList;
import java.util.List;

import lab02.Excecoes.OfertaNaoEncontradaException;
import lab02.Excecoes.SaldoInsuficienteException;

/**
 * Classe que representa o Marketplace de venda de ingressos entre clientes.
 */
public class Marketplace {
    private List<OfertaIngresso> ingressosAVenda; // Lista de ofertas disponíveis no marketplace
    private double comissaoPorcentagem; // Porcentagem de comissão aplicada sobre cada venda

    /**
     * Construtor da classe Marketplace.
     * 
     * @param comissaoPorcentagem A porcentagem de comissão do marketplace sobre cada venda.
     */
    public Marketplace(double comissaoPorcentagem) {
        this.ingressosAVenda = new ArrayList<>();
        this.comissaoPorcentagem = comissaoPorcentagem;
    }

    /**
     * Lista todas as ofertas de ingressos disponíveis no marketplace.
     * @return Lista de ofertas disponíveis.
     */
    public List<OfertaIngresso> listarOfertas() {
        return ingressosAVenda;
    }

    /**
     * Recebe uma oferta de ingresso para venda no marketplace, e adiciona à lista de ofertas disponíveis.
     * 
     * @param ingresso    Ingresso que será colocado à venda.
     * @param precoPedido Preço pedido pelo ingresso.
     * @param vendedor    Cliente que está oferecendo o ingresso.
     */
    public void receberOferta(Ingresso ingresso, double precoPedido, Cliente vendedor) {
        OfertaIngresso oferta = new OfertaIngresso(ingresso, precoPedido, vendedor);
        ingressosAVenda.add(oferta);
    }

    /**
     * Processa a compra de uma oferta de ingresso no marketplace
     * 
     * @param comprador Cliente que deseja comprar o ingresso.
     * @param oferta    Oferta que o cliente deseja comprar.
     * @throws OfertaNaoEncontradaException Se a oferta não for encontrada no marketplace.
     * @throws SaldoInsuficienteException   Se o comprador não tiver saldo suficiente.
     */
    public void processarCompra(Cliente comprador, OfertaIngresso oferta)
            throws OfertaNaoEncontradaException, SaldoInsuficienteException {

        if (ingressosAVenda.contains(oferta)) {
            // Calcula o preço total da compra, incluindo a comissão do marketplace
            double precoVenda = oferta.getPrecoPedido();
            double precoComissao = precoVenda * comissaoPorcentagem / 100;
            double total = precoVenda + precoComissao;

            // Verifica se o comprador tem saldo suficiente para a compra
            if (comprador.getSaldo() < total) {
                throw new SaldoInsuficienteException("Saldo insuficiente para comprar o ingresso.");
            }

            comprador.removerSaldo(total);
            oferta.getVendedor().adicionarSaldo(precoVenda);

            // Cria um novo ingresso com os dados da oferta e adiciona ao comprador
            Ingresso ingressoComprado = new Ingresso(oferta.getEvento(), oferta.getPreco());
            comprador.adicionarIngresso(ingressoComprado);
            ingressosAVenda.remove(oferta);
        } else {
            throw new OfertaNaoEncontradaException("Oferta de ingresso não encontrada no marketplace.");
        }

    }

}
