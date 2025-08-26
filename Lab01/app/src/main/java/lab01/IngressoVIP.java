package lab01;

public class IngressoVIP extends Ingresso {

    /**
     * Construtor da classe IngressoVIP
     * @param evento o evento ao qual o ingresso pertence
     * @param codigo o código do ingresso
     */
    public IngressoVIP(Evento evento) {
        super(evento);
    }

    /**
     * Retorna o preço do ingresso
     * @return o preço do ingresso com as condições de VIP,
     * que é 3 vezes o preço base do evento
     */
    @Override
    public double getPreco(){
        return this.getEvento().getPrecoIngresso()*3;
    }
}
