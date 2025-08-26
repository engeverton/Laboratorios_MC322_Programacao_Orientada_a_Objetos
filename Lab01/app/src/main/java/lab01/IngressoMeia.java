package lab01;

public class IngressoMeia extends Ingresso{

    /**
     * Construtor da classe IngressoMeia
     * @param evento o evento ao qual o ingresso pertence
     * @param codigo o código do ingresso
     */
    public IngressoMeia(Evento evento) {
        super(evento);
    }

    /**
     * Retorna o preço do ingresso
     * @return o preço do ingresso com as condições de meia
     * que é 50% do preço base do evento
     */
    @Override
    public double getPreco () {
        return this.getEvento().getPrecoIngresso()/2; // 50% de desconto
    }
}