package lab01;

public class IngressoInteira extends Ingresso{
    
    /**
     * Construtor da classe IngressoInteira
     * @param evento o evento ao qual o ingresso pertence
     * @param codigo o código do ingresso
     */
    public IngressoInteira(Evento evento) {
        super(evento);
    }

    /**
     * Retorna o preço do ingresso
     * @return o preço do ingresso com as condições de inteira,  
     * que é o preço base do evento
     */
    @Override
    public double getPreco(){
        return this.getEvento().getPrecoIngresso(); //valor do preco base
    }


}
