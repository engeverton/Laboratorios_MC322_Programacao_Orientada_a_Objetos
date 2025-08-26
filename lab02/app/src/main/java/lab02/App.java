/*
* Material usado na disciplina MC322 - Programação orientada a objetos.
*/

package lab02;

import java.util.ArrayList;
import java.util.List;

import lab02.Excecoes.CapacidadeInsuficienteException;
import lab02.Excecoes.EventoNaoEncontradoException;
import lab02.Excecoes.IngressoEsgotadoException;
import lab02.Excecoes.IngressoNaoEncontradoException;
import lab02.Excecoes.LocalIndisponivelException;
import lab02.Filtros.*;

/**
 * Contém a estrutura de implementação da aplicação.
 * Em todas as classes foi utilizada IA generativa para a documentação
* 
* @author Everton Mendes de Almeida - 260426
*/
public class App {

    /**
     * Aplicação principal
    * @param args
    */
    public static void main(String[] args) {


        // Desenvolvimento de Cenário de Uso

        //DEMONSTRAÇÃO DE CRIAÇÃO DE EVENTOS E ALOCAÇÃO DE LOCAIS

        //Criando uma organizadora
        Organizadora organizadora = new Organizadora("Épika Produções/Eventos Ltda", 45987321, 
                                                    "Avenida Nova Era, 456, Belo Horizonte");

        //Criando locais
        Local localShow = new Local("Allianz Parque",5000);
        Local localShowPrivado = new Local("Local privado", 10);
        Local localJogo = new Local("Estádio Mineirão", 60000);
        Local localFestival = new Local("Autódromo de Interlagos", 58000);

        //########Criando os eventos########
        //Criando uma lista para armazenar todos os eventos criados
        List<Evento> eventos = new ArrayList<Evento>();
        //inicializando os eventos
        EventoShow eventoShow = null;
        EventoShow eventoShowPrivado = null;
        EventoJogo eventoJogo = null;
        EventoFestival eventoFestival = null;
  
        //Criando os eventos, com tratamento de exceções - [todos são criados com sucesso]
        try{    
            //SHOW
            System.out.println("\nCriando evento SHOW...");
            eventoShow = organizadora.criarEvento("ENSAIOS DA ANITTA", localShow, 100, "19/05/2025", 
                                                    900, "Anitta");
            eventos.add(eventoShow);
            System.out.println(eventoShow.descricao());

            //SHOW PRIVADO - evento com capacidade máxima de 3 pessoas
            System.out.println("\nCriando evento SHOW PRIVADO...");
            eventoShowPrivado = organizadora.criarEvento("Show privado", localShowPrivado, 5,
                                                         "19/05/2025", 3, "Liniker");
            eventos.add(eventoShowPrivado);
            System.out.println(eventoShowPrivado.descricao());

            //JOGO
            System.out.println("\nCriando evento JOGO...");
            List<String> times = new ArrayList<String>();
            times.add("Cruzeiro");
            times.add("Atlético Mineiro");
            eventoJogo = organizadora.criarEvento("CRUZEIRO X ATLÉTICO MINEIRO", localJogo, 80, 
                                                    "19/05/2025", 50000, times);
            eventos.add(eventoJogo);
            System.out.println(eventoJogo.descricao());

            //FESTIVAL
            System.out.println("\nCriando evento FESTIVAL...");
            List<String> lineup = new ArrayList<String>();
            lineup.add("Justin Timberlake");
            lineup.add("Shawn Mendes");
            lineup.add("Olivia Rodrigo");
            lineup.add("Jão");
            lineup.add("Tool");
            lineup.add("Samhara");       
            eventoFestival = organizadora.criarEvento("LOLLAPALOOZA BRAZIL 2025", localFestival, 500, 
                                                        "17/05/2025", 58000, lineup, 4320);
            eventos.add(eventoFestival);
            System.out.println(eventoFestival.descricao());

        } catch (CapacidadeInsuficienteException | LocalIndisponivelException e){
            System.out.println(e.getMessage());
        }


        //DEMONSTRAÇÃO VENDA E CANCELAMENTO DE INGRESSOS E NOTIFICAÇÕES
        //Criando os clientes
        Cliente cliente1 = new Cliente("Everton", "everton@gmail.com", "61999999999");
        Cliente cliente2 = new Cliente("Sophia", "sophia@gmail.com", "61888888888");
        Cliente cliente3 = new Cliente("Renan", "renan@gmail.com", "61777777777");
        Cliente cliente4 = new Cliente("Zeno", "zeno@gmail.com", "61666666666");   //cliente que não comprou nenhum ingresso

        //Vendendo ingressos, com tratamento de exceções
        //Se a compra for bem sucedida, é enviada uma notificação para o cliente, por e-mail e SMS
        System.out.println("\nVENDENDO INGRESSOS...");

        try {
            if (eventoShow != null) {
                eventoShow.venderIngresso(cliente1);
            }
            if (eventoShowPrivado != null) {
                eventoShowPrivado.venderIngresso(cliente1);
            }
            if (eventoShow != null) {
                eventoShow.venderIngresso(cliente2);
            }
            if (eventoFestival != null) {
                eventoFestival.venderIngresso(cliente2);
            }
            if (eventoShowPrivado != null) {
                eventoShowPrivado.venderIngresso(cliente2);
            }
            if (eventoShow != null) {
                eventoShow.venderIngresso(cliente3);
            }
            if (eventoJogo != null) {
                eventoJogo.venderIngresso(cliente3);
            }
            if (eventoFestival != null) {
                eventoFestival.venderIngresso(cliente3);
            }
            if (eventoShowPrivado != null) {
                eventoShowPrivado.venderIngresso(cliente3);
            }
            if (eventoShowPrivado != null) {
                eventoShowPrivado.venderIngresso(cliente4); //ingresso esgotado
            }
        } catch (IngressoEsgotadoException e) {
            System.out.println(e.getMessage());
        } catch (EventoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }

        //Cancelando ingressos
        //Se o cancelamento for bem sucedido, é enviada uma notificação para o cliente, por e-mail e SMS
        try {
            cliente3.cancelarIngresso(eventoShow);
            cliente2.cancelarIngresso(eventoFestival);
            cliente1.cancelarIngresso(eventoJogo);  //erro - ingresso não encontrado
        } catch (IngressoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
        
        //notificação para um cliente usando os canais de notificação SMS e Email
        cliente3.notificar("Vimos que você cancelou seu ingresso para o evento, " +
                                        "mas não queremos que perca essa experiência incrível!" +
                                        "Por isso, estamos oferecendo um desconto de 10% na compra de um novo ingresso. Aproveite!");


        //DEMONSTRAÇÃO DOS MÉTODOS DE BUSCA

        //Criando uma imobiliária e adicionando locais
        ImobiliariaDeEventos imobiliaria = new ImobiliariaDeEventos("Imobiliária Barão");
        Local local1 = new Local("Maracanã", 70000);
        Local local2 = new Local("Castelao", 60000);
        Local local3 = new Local("NaPraia Parque", 5000);
        Local local4 = new Local("Responsa", 50000);
        imobiliaria.adicionarLocal(local1);
        imobiliaria.adicionarLocal(local2);
        imobiliaria.adicionarLocal(local3);
        imobiliaria.adicionarLocal(local4);

        //Buscando local por nome
        //Busca por um local existente
        System.out.println("\nBUSCANDO LOCAL POR NOME...");
        System.out.println("Buscar: Maracanã");
        if (imobiliaria.buscarLocal("Maracanã") != null) {
            System.out.println(imobiliaria.buscarLocal("Maracanã").getNome() + " foi encontrado e tem capacidade:" 
                                + imobiliaria.buscarLocal("Maracanã").getCapacidade());
        } else {
            System.out.println("Local não encontrado.");
        }

        //Busca por um local inexistente
        System.out.println("Buscar: Mané-Garrincha");
        if (imobiliaria.buscarLocal("Mané-Garrinha") != null) {
            System.out.println(imobiliaria.buscarLocal("Mané-Garrinha").getNome() + "foi encontrado e tem capacidade:" 
                                + imobiliaria.buscarLocal("Mané-Garrinha").getCapacidade());
        } else {
            System.out.println("Local não encontrado.");
        }

        //Buscando local por capacidade
        //Busca por locais existentes
        System.out.println("\nBUSCANDO LOCAIS POR CAPACIDADE...");
        System.out.println("Buscar: 20000");
        List<Local> locaisEncontrados = imobiliaria.buscarLocal(10000);
        if (locaisEncontrados.size() == 0) {
            System.out.println("Local não encontrado.");
        } else {
            System.out.println("Locais encontrados, com capacidade para pelo menos 20000 pessoas:");
            for (Local local : locaisEncontrados) {
                System.out.println("- " + local.getNome());
            }
        }

        //Busca por locais inexistentes - local não encontrado
        System.out.println("Buscar: 80000");
        List<Local> locaisEncontrados2 = imobiliaria.buscarLocal(80000);
        if (locaisEncontrados2.size() == 0) {
            System.out.println("Local não encontrado.");
        } else {
            System.out.println("Locais encontrados, com capacidade para pelo menos 80000 pessoas:");
            for (Local local : locaisEncontrados2) {
                System.out.println("- " + local.getNome());
            }
        }

        //DEMONSTRAÇÃO DE COMPARAÇÃO DE CLIENTES

        System.out.println("\nCOMPARANDO CLIENTES...");
        int comparação1 = cliente1.compareTo(cliente2);
        //comparação entre clientes 1 e 2 - possuem ingressos para o mesmo evento
        if (comparação1 == 1) {
            System.out.println(cliente1.getNome() + " e " + cliente2.getNome() + " possuem ingressos para o mesmo evento: .");
        } else if (comparação1 == 0) {
            System.out.println(cliente1.getNome() + " e " + cliente2.getNome() + " não possuem ingressos para o mesmo evento.");
        } 
        //comparação entre clientes 1 e 3 - possuem ingressos para o mesmo evento
        int comparação2 = cliente1.compareTo(cliente3);
        if (comparação2 == 1) {
            System.out.println(cliente1.getNome() + " e " + cliente3.getNome() + " possuem ingressos para o mesmo evento: .");
        } else if (comparação2 == 0) {
            System.out.println(cliente1.getNome() + " e " + cliente3.getNome() + " não possuem ingressos para o mesmo evento.");
        }
        //comparação entre clientes 1 e 4 - não possuem ingressos para o mesmo evento
        int comparação3 = cliente1.compareTo(cliente4);
        if (comparação3 == 1) {
            System.out.println(cliente1.getNome() + " e " + cliente4.getNome() + " possuem ingressos para o mesmo evento: .");
        } else if (comparação3 == 0) {
            System.out.println(cliente1.getNome() + " e " + cliente4.getNome() + " não possuem ingressos para o mesmo evento.");
        }
        
        //DEMONSTRAÇÃO DE FILTROS
        //Criando outra organizadora
        Organizadora organizadora2 = new Organizadora("Organizadora de eventos", 87654321, 
                                                        "Avenida Paulista, 123, São Paulo");

        //Inicializando outros os eventos
        EventoShow eventoShow2 = null;
        EventoJogo eventoJogo2 = null;
        EventoJogo eventoJogo3 = null;
        EventoFestival eventoFestival2 = null;
        //Criando outros eventos, com tratamento de exceções
        try{
            //SHOW
            System.out.println("\nCriando outro evento SHOW...");
            eventoShow2 = organizadora2.criarEvento("NUMANICE", local3, 100, 
                                                    "17/05/2025", 2000, "Ludmilla");
            eventos.add(eventoShow2);
            System.out.println(eventoShow2.descricao());

            //JOGOS
            System.out.println("\nCriando outros eventos JOGOS...");
            List<String> times2 = new ArrayList<String>();
            times2.add("Flamengo");
            times2.add("Corinthians");
            eventoJogo2 = organizadora2.criarEvento("FLAMENGO X CORINTHIANS", local1, 100, 
                                                    "18/05/2025", 50000, times2);
            eventos.add(eventoJogo2);
            System.out.println(eventoJogo2.descricao());

            System.out.println("\nCriando outros eventos JOGOS...");
            List<String> times3 = new ArrayList<String>();
            times3.add("São Paulo");
            times3.add("Vasco");
            eventoJogo3 = organizadora2.criarEvento("SÃO PAULO X VASCO", local2, 90,
                                                     "18/05/2025", 50000, times3);
            eventos.add(eventoJogo3);
            System.out.println(eventoJogo3.descricao());

            //FESTIVAL
            //evento com capacidade insuficiente
            System.out.println("\nCriando outro evento FESTIVAL...");
            List<String> lineup = new ArrayList<String>();
            lineup.add("Justin Timberlake");
            lineup.add("Shawn Mendes");
            lineup.add("Olivia Rodrigo");
            lineup.add("Jão");
            lineup.add("Tool");
            lineup.add("Samhara");
            eventoFestival2 = organizadora2.criarEvento("THE TOWN 2026", local4, 500, 
                                                        "17/05/2026", 65000, lineup, 4320);
            eventos.add(eventoFestival2);
            System.out.println(eventoFestival2.descricao());
        } catch (CapacidadeInsuficienteException | LocalIndisponivelException e){
            System.out.println(e.getMessage());
        }


        System.out.println("\nFILTRANDO EVENTOS..");

        //Imprimindo todos os eventos criados
        System.out.println("\nLista de eventos todos os eventos criados:");
        for (Evento evento : eventos) {
            System.out.println("- " + evento.getNome());
        }

        //Filtrando eventos por organizadora
        System.out.println("\nFiltrando eventos por organizadora...");
        Filter filtroOrganizadora = new EventoPorOrganizadoraFilter("Organizadora de eventos");
        List<Evento> eventosFiltradosOrganizadora = filtroOrganizadora.filter(eventos);
        if (eventosFiltradosOrganizadora.size() == 0) {
            System.out.println("Nenhum evento encontrado.");
        } else {
            System.out.println("Eventos filtrados pela organizadora ORGANIZADORA DE EVENTOS:");
            for (Evento evento : eventosFiltradosOrganizadora) {
                System.out.println("- " + evento.getNome());
            }
        }

        //Filtrando eventos por nome
        System.out.println("\nFiltrando eventos por nome...");
        Filter filtroNome = new EventoPorNomeFilter("SÃO PAULO X VASCO");
        List<Evento> eventosFiltradosNome = filtroNome.filter(eventos);
        if (eventosFiltradosNome.size() == 0) {
            System.out.println("Nenhum evento encontrado.");
        } else {
            System.out.println("Eventos filtrados por pelo nome \'SÃO PAULO X VASCO\':");
            for (Evento evento : eventosFiltradosNome) {
                System.out.println("- " + evento.getNome());
            }
        }

        //Filtrando eventos por local - nenhum evento encotrado
        System.out.println("\nFiltrando eventos por local...");
        Filter filtroLocal = new EventoPorLocalFilter("Mané-Garrincha");
        List<Evento> eventosFiltradosLocal = filtroLocal.filter(eventos);
        if (eventosFiltradosLocal.size() == 0) {
            System.out.println("Nenhum evento encontrado.");
        } else {
            System.out.println("Eventos filtrados pelo local \'Mane-Garrincha\'':");  
            for (Evento evento : eventosFiltradosLocal) {
                System.out.println("- " + evento.getNome());
            }
        }

        //Filtrando eventos por data
        System.out.println("\nFiltrando eventos por data...");
        Filter filtroData = new EventoPorDataFilter("18/05/2025");
        List<Evento> eventosFiltradosData = filtroData.filter(eventos);
        if (eventosFiltradosData.size() == 0) {
            System.out.println("Nenhum evento encontrado.");
        } else {
            System.out.println("Eventos filtrados pela data \'18/05/2025\':");
            for (Evento evento : eventosFiltradosData) {
                System.out.println("- " + evento.getNome());
            }
        }

        //Filtrando eventos por organizadora E data
        System.out.println("\nFiltrando eventos por organizadora e data...");
        Filter filtroOrganizadoraEData = new AndFilter(filtroOrganizadora, filtroData);
        List<Evento> eventosFiltradosOrganizadoraEData = filtroOrganizadoraEData.filter(eventos);
        if (eventosFiltradosOrganizadoraEData.size() == 0) {
            System.out.println("Nenhum evento encontrado.");
        } else {
            System.out.println("Eventos filtrados pela organizadora ORGANIZADORA DE EVENTOS e pela data \'18/05/2025\'':");
            for (Evento evento : eventosFiltradosOrganizadoraEData) {
                System.out.println("- " + evento.getNome());
            }
        }


        //DEMONSTRAÇÃO CARACTERÍSTICAS DE EVENTOS

        System.out.println("\nCaracteristica do " + eventoShow.getNome() + ", com um evento Bar - AFTER DO SHOW");
        EventoEmBar caracteristica = new EventoEmBar("Bar da Ju","02:00", "3 horas");
        eventoShow.setCaracteristica(caracteristica);
        System.out.println(eventoShow.getCaracteristica());

    }   
}
