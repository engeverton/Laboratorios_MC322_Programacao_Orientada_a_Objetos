/*
 * App.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab01;

/**
* Contém a estrutura de implementação da aplicação.
* 
* @author Everton Mendes de Almeida 260426
*/
public class App {
 
    /**
    * Aplicação principal
    * @param args
    */
    public static void main(String[] args) {
 
 
        // DEMONSTRAÇÃO CÓDIGO PRELIMINAR
         
        // Criando diferentes usuarios e atribuindo seus dados
        Usuario usuario1 = new Usuario("Everton", "everton@gmail.com");
        Usuario usuario2 = new Usuario("Sophia", "sophia@gmail.com");
        Usuario usuario3 = new Usuario("Renan", "renan@gmail.com");
        Usuario usuario4 = new Usuario("Sandra", "sandra@gmail.com");
        Usuario usuario5 = new Usuario("Zeno", "zeno@gmail.com");
        
        HistoricoEventos historicoEventos = new HistoricoEventos();

        // DEMONSTRAÇÃO EVENTO SHOW
        System.out.println("SHOW\n");

        // Dados sobre um evento show
        Local localShow = new Local("Allianz Parque",1000);
        EventoShow eventoShow = new EventoShow("Ensaios da Anitta", localShow, 100, "Anitta", "19/01/2025");
        eventoShow.exibirDetalhes();

        //  Dados sobre ingressos e impressão do valor de cada tipo de ingresso (Inteira, meia, vip)
        IngressoInteira ingressoInteiraShow = new IngressoInteira(eventoShow);
        IngressoMeia ingressoMeiaShow = new IngressoMeia(eventoShow);
        IngressoVIP ingressoVipShow = new IngressoVIP(eventoShow);
        System.out.println("Preço do Ingresso intera: " + ingressoInteiraShow.getPreco());
        System.out.println("Preço do Ingresso meia: " + ingressoMeiaShow.getPreco());
        System.out.println("Preço do Ingresso VIP: " + ingressoVipShow.getPreco() + "\n\n");

 
        // DEMONSTRAÇÃO EVENTO ESPORTE
        System.out.println("ESPORTE\n");

        //Dados sobre o local e um evento de esporte e impressão dos detalhes
        Local localEsporte = new Local("Estádio Mineirão", 60000);
        EventoEsporte eventoEsporte = new EventoEsporte("Final do Campeonato Mineiro", localEsporte, 80,
                                                         "Futebol", 11, "Atlético Mineiro", "Cruzeiro");
        eventoEsporte.exibirDetalhes();

        //  Dados sobre ingressos e impressão do valor de cada tipo de ingresso (Inteira, meia, vip)
        IngressoInteira ingressoInteiraEsporte = new IngressoInteira(eventoEsporte);
        IngressoMeia ingressoMeiaEsporte = new IngressoMeia(eventoEsporte);
        IngressoVIP ingressoVipEsporte = new IngressoVIP(eventoEsporte);
        System.out.println("Preço do Ingresso intera: " + ingressoInteiraEsporte.getPreco());
        System.out.println("Preço do Ingresso meia: " + ingressoMeiaEsporte.getPreco());
        System.out.println("Preço do Ingresso VIP: " + ingressoVipEsporte.getPreco() + "\n\n");


        // DEMONSTRAÇÃO EVENTO FESTIVAL
        System.out.println("Festival\n");

        //Dados sobre um evento festival e impressão dos detalhes e lineup
        Local localFestival = new Local("Autódromo de Interlagos", 60000);
        EventoFestival eventoFestival = new EventoFestival("LOLLAPALOOZA 2025", localFestival, 
                                                            500, 4320);
        eventoFestival.adicionarAtracao("Justin Timberlake");
        eventoFestival.adicionarAtracao("Shawn Mendes");
        eventoFestival.adicionarAtracao("Olivia Rodrigo");
        eventoFestival.adicionarAtracao("Jão");
        eventoFestival.adicionarAtracao("Tool");
        eventoFestival.adicionarAtracao("Samhara");
        eventoFestival.MostrarLineUp();

        //  Dados sobre ingressos e impressão do valor de cada tipo de ingresso (Inteira, meia, vip)
        IngressoInteira ingressoInteiraFestival = new IngressoInteira(eventoFestival);
        IngressoMeia ingressoMeiaFestival = new IngressoMeia(eventoFestival);
        IngressoVIP ingressoViaFestival = new IngressoVIP(eventoFestival);
        System.out.println("Preço do Ingresso intera: " + ingressoInteiraFestival.getPreco());
        System.out.println("Preço do Ingresso meia: " + ingressoMeiaFestival.getPreco());
        System.out.println("Preço do Ingresso VIP: " + ingressoViaFestival.getPreco() + "\n\n");

        //DEMOSNTRAÇÃO EVENTO TEATRO
        System.out.println("TEATRO\n");

        //Dados sobre o local e um evento de teatro e impressão dos detalhes
        Local localTeatro = new Local("Teatro Municipal do Rio de Janeiro", 500);
        EventoTeatro eventoTeatro = new EventoTeatro("O Fantasma da Ópera", localTeatro, 120,
                                                     "Drama", "O Fantasma da Ópera");
        eventoTeatro.exibirDetalhes();

        //  Dados sobre ingressos e impressão do valor de cada tipo de ingresso (Inteira, meia, vip)
        IngressoInteira ingressoInteiraTeatro = new IngressoInteira(eventoTeatro);
        IngressoMeia ingressoMeiaTeatro = new IngressoMeia(eventoTeatro);
        IngressoVIP ingressoViaTeatro = new IngressoVIP(eventoTeatro);
        System.out.println("Preço do Ingresso intera: " + ingressoInteiraTeatro.getPreco());
        System.out.println("Preço do Ingresso meia: " + ingressoMeiaTeatro.getPreco());
        System.out.println("Preço do Ingresso VIP: " + ingressoViaTeatro.getPreco() + "\n\n");

        // DEMONSTRAÇÃO DA CRIAÇÃO DE INGRESSOS, PARA DIFERENTES EVENTOS E USUÁRIOS
        
        // Adicionando ingressos para o evento show
        eventoShow.adicionarIngresso(ingressoVipShow, usuario1);
        eventoShow.adicionarIngresso(ingressoMeiaShow, usuario2);
        eventoShow.adicionarIngresso(ingressoInteiraShow, usuario3);

        // Adicionando ingressos para o evento esporte
        eventoEsporte.adicionarIngresso(ingressoVipEsporte, usuario4);
        eventoEsporte.adicionarIngresso(ingressoMeiaEsporte, usuario5);
        eventoEsporte.adicionarIngresso(ingressoInteiraEsporte, usuario1);

        // Adicionando ingressos para o evento festival
        eventoFestival.adicionarIngresso(ingressoViaFestival, usuario2);
        eventoFestival.adicionarIngresso(ingressoMeiaFestival, usuario3);
        eventoFestival.adicionarIngresso(ingressoInteiraFestival, usuario4);

        // Adicionando ingressos para o evento teatro
        eventoTeatro.adicionarIngresso(ingressoViaTeatro, usuario5);
        eventoTeatro.adicionarIngresso(ingressoMeiaTeatro, usuario1);
        eventoTeatro.adicionarIngresso(ingressoInteiraTeatro, usuario2);

        //imprimindo os ingressos comprados pelo usuario1
        System.out.println("Ingressos comprados por " + usuario1.getNome());
        for (Ingresso ingresso : usuario1.getIngresso()) {
            System.out.println("Código: " + ingresso.getCodigo() + "\n" + "Preço: " + ingresso.getPreco() + "\n" 
                                + "Evento: "+ ingresso.getEvento().getNome() + "\n");
        }

        //imprime o faturamento de cada evento
        System.out.println("Faturamento " + eventoShow.getNome() + ": R$ " + eventoShow.calcularFaturamento());
        System.out.println("Faturamento " + eventoEsporte.getNome() + ": R$ " + eventoEsporte.calcularFaturamento());
        System.out.println("Faturamento " + eventoFestival.getNome() + ": R$ " + eventoFestival.calcularFaturamento());
        System.out.println("Faturamento " + eventoTeatro.getNome() + ": R$ " + eventoTeatro.calcularFaturamento());
        System.out.println("\n");
 
        // DEMONSTRAÇÃO HISTÓRICO DE EVENTOS

        //adicionando todos os eventos na lista de histórico de eventos
        historicoEventos.adicionarEvento(eventoShow);
        historicoEventos.adicionarEvento(eventoEsporte);
        historicoEventos.adicionarEvento(eventoFestival);
        historicoEventos.adicionarEvento(eventoTeatro);

        //imprimindo o histórico de eventos
        System.out.println("Histórico de Eventos\n");
        for (Evento historico : historicoEventos.getEventos()) {
            System.out.println(historico.getNome());
        }
        System.out.println("\n");

    }
}
 