package lab02.model;

/**
 * Representa uma oferta de ingresso no marketplace.
 * 
 */
public class OfertaIngresso extends Ingresso {

    private double precoPedido; // Preço pedido pelo ingresso na oferta
    private Cliente vendedor;   // Cliente que está vendendo o ingresso

    /**
     * Construtor da classe OfertaIngresso.
     * 
     * @param ingresso    Ingresso a ser colocado na oferta.
     * @param precoPedido Preço pedido pelo ingresso.
     * @param vendedor    Cliente que está oferecendo o ingresso.
     */
    public OfertaIngresso(Ingresso ingresso, double precoPedido, Cliente vendedor) {
        super(ingresso.getEvento(), ingresso.getPreco());
        this.precoPedido = precoPedido;
        this.vendedor = vendedor;
    }

    /**
     * Retorna o preço pedido na oferta.
     * @return o preço pedido.
     */
    public double getPrecoPedido() {
        return precoPedido;
    }

    /**
     * Retorna o cliente que está vendendo o ingresso.
     * @return o vendedor.
     */
    public Cliente getVendedor() {
        return vendedor;
    }

    /**
     * Retorna uma representação em texto da oferta de ingresso.
     * @return String contendo nome do evento e preço pedido.
     */
    @Override
    public String toString() {
        return getEvento().getNome() + " - Preço Pedido: R$ " + precoPedido;
    }

}
