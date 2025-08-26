package lab02.model;

import java.util.ArrayList;
import java.util.List;

import lab02.Excecoes.CapacidadeInsuficienteException;
import lab02.Excecoes.EventoNaoEncontradoException;
import lab02.Excecoes.IngressoEsgotadoException;
import lab02.Excecoes.IngressoNaoEncontradoException;
import lab02.Excecoes.IngressoNaoPertenceAoClienteException;
import lab02.Excecoes.LocalIndisponivelException;
import lab02.Excecoes.OfertaNaoEncontradaException;
import lab02.Excecoes.SaldoInsuficienteException;

/**
* Contém a estrutura de inicialização do sistema.
* 
* @author Everton Mendes de Almeida 260426
*/

public class SistemaGerenciador {
	
	private List<Organizadora> organizadoras;
	private List<Cliente> clientes;
	private List<Evento> eventos;
	private Marketplace marketplace;

	public SistemaGerenciador() {
		this.organizadoras = new ArrayList<>(); // Lista de organizadoras do sistema
		this.clientes = new ArrayList<>(); // Lista de clientes do sistema
		this.eventos = new ArrayList<>(); // Lista de eventos do sistema
		this.marketplace = new Marketplace(10.0); // 10% de comissão por padrão
		
		inicializarSistema();
	}

	private void inicializarSistema() {
		// Inicialização de organizadoras, clientes, eventos e locais
		System.out.println("Inicializando o sistema de gerenciamento de eventos...");
		
		//criação de organizadoras
		Organizadora organizadora = new Organizadora("Épika Produções/Eventos Ltda", 45987321, 
                "Avenida Nova Era, 456, Belo Horizonte");
		Organizadora organizadora2 = new Organizadora("Organizadora de eventos", 87654321, 
                "Avenida Paulista, 123, São Paulo");
		Organizadora organizadora3 = new Organizadora("Organizadora de eventos 3", 45135948, 
				"Rua Florenço, 789, Rio de Janeiro");
		Organizadora organizadora4 = new Organizadora("Organizadora de eventos 4", 54687198, 
				"Avenida Alvorada, 321, Brasília");												//sem eventos
		organizadoras.add(organizadora);
		organizadoras.add(organizadora2);
		organizadoras.add(organizadora3);
		organizadoras.add(organizadora4);

       //Criando locais
		Local localShow = new Local("Allianz Parque",5000);
		Local localJogo = new Local("Estádio Mineirão", 60000);
		Local localFestival = new Local("Autódromo de Interlagos", 58000);
		Local local1 = new Local("Maracanã", 70000);
        Local local2 = new Local("Castelao", 60000);
        Local local3 = new Local("NaPraia Parque", 5000);
        Local local4 = new Local("Responsa", 50000);
		
        //Criando eventos
		EventoShow eventoShow = null;
        EventoJogo eventoJogo = null;
        EventoFestival eventoFestival = null;
        EventoShow eventoShow2 = null;
        EventoJogo eventoJogo2 = null;
        EventoJogo eventoJogo3 = null;
        EventoFestival eventoFestival2 = null;
  
        //Criando os eventos, com tratamento de exceções
        try{    
        	//SHOWS
            System.out.println("\nCriando evento SHOW...");
            eventoShow = organizadora.criarEvento("ENSAIOS DA ANITTA", localShow, 100, "19/05/2025", 
                                                    900, "Anitta");
            eventos.add(eventoShow);
            System.out.println(eventoShow.descricao());

            System.out.println("\nCriando outro evento SHOW...");
            eventoShow2 = organizadora.criarEvento("NUMANICE", local3, 100, 
                                                    "17/05/2025", 2000, "Ludmilla");
            eventos.add(eventoShow2);
            System.out.println(eventoShow2.descricao());

            //JOGOS
            System.out.println("\nCriando evento JOGO...");
            List<String> times = new ArrayList<String>();
            times.add("Cruzeiro");
            times.add("Atlético Mineiro");
            eventoJogo = organizadora2.criarEvento("CRUZEIRO X ATLÉTICO MINEIRO", localJogo, 80, 
                                                    "19/05/2025", 50000, times);
            eventos.add(eventoJogo);
            System.out.println(eventoJogo.descricao());
            
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

            //FESTIVAIS
            System.out.println("\nCriando evento FESTIVAL...");
            List<String> lineup = new ArrayList<String>();
            lineup.add("Justin Timberlake");
            lineup.add("Shawn Mendes");
            lineup.add("Olivia Rodrigo");
            lineup.add("Jão");
            lineup.add("Tool");
            lineup.add("Samhara");       
            eventoFestival = organizadora3.criarEvento("LOLLAPALOOZA BRAZIL 2025", localFestival, 500, 
                                                        "17/05/2025", 58000, lineup, 4320);
            eventos.add(eventoFestival);
            System.out.println(eventoFestival.descricao());
            
            //evento com capacidade insuficiente
            System.out.println("\nCriando outro evento FESTIVAL...");
            List<String> lineupp = new ArrayList<String>();
            lineup.add("Justin Timberlake");
            lineup.add("Shawn Mendes");
            lineup.add("Olivia Rodrigo");
            lineup.add("Jão");
            lineup.add("Tool");
            lineup.add("Samhara");
            eventoFestival2 = organizadora3.criarEvento("THE TOWN 2026", local4, 500, 
                                                        "17/05/2026", 65000, lineupp, 4320);
            eventos.add(eventoFestival2);
            System.out.println(eventoFestival2.descricao());

        } catch (CapacidadeInsuficienteException | LocalIndisponivelException e){
            System.out.println(e.getMessage());
        }
        
        //Imprimindo todos os eventos criados
        System.out.println("\nLista de todos os eventos criados:");
        for (Evento evento : eventos) {
            System.out.println("- " + evento.getNome());
        }
        
        //Criando os clientes
        Cliente cliente1 = new Cliente("Everton", "everton@gmail.com", "61999999999");
        cliente1.adicionarSaldo(800.0); // Adicionando saldo ao cliente 
        Cliente cliente2 = new Cliente("Sophia", "sophia@gmail.com", "61888888888");
        cliente2.adicionarSaldo(1950.0); // Adicionando saldo ao cliente 
        Cliente cliente3 = new Cliente("Renan", "renan@gmail.com", "61777777777");
        cliente3.adicionarSaldo(2400.0); // Adicionando saldo ao cliente 
        Cliente cliente4 = new Cliente("Zeno", "zeno@gmail.com", "61666666666");   //cliente que não comprou nenhum ingresso
        cliente4.adicionarSaldo(90.0); // Adicionando saldo ao cliente
        
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.add(cliente4);
        
        //Vendendo ingressos, com tratamento de exceções
        //Se a compra for bem sucedida, é enviada uma notificação para o cliente, por e-mail e SMS
        try {
        	if (eventoShow != null) {
                eventoShow.venderIngresso(cliente1);
        	}
            if (eventoShow != null) {
                eventoShow.venderIngresso(cliente2);
            }
            if (eventoFestival != null) {
                eventoFestival.venderIngresso(cliente2);
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
            if (eventoJogo3 != null) {
            	eventoJogo3.venderIngresso(cliente2);
            }
            if (eventoJogo2 != null) {
				eventoJogo2.venderIngresso(cliente3);
			}
            if (eventoShow2 != null) {
				eventoShow2.venderIngresso(cliente1); 
			}
            if (eventoJogo2 != null) {
				eventoJogo2.venderIngresso(cliente4); //cliente 4 não possui saldo suficiente
			}
        } catch (IngressoEsgotadoException e) {
            System.out.println(e.getMessage());
        } catch (EventoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        } catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		}
        
        Ingresso ingresso1 = cliente1.getIngressos().get(0); 
        Ingresso ingresso2 = cliente2.getIngressos().get(0);
        Ingresso ingresso3 = cliente3.getIngressos().get(0);
        Ingresso ingresso4 = cliente2.getIngressos().get(1);
        Ingresso ingresso5 = cliente3.getIngressos().get(1);
        
        //Oferecendo ingressos para venda no marketplace
        try {
        	cliente1.oferecerIngressoParaVenda(ingresso1, 100.0, marketplace); 
        	cliente2.oferecerIngressoParaVenda(ingresso2, 80.0, marketplace); 
        	cliente2.oferecerIngressoParaVenda(ingresso4, 60.0, marketplace);
        	cliente3.oferecerIngressoParaVenda(ingresso5, 70.0, marketplace);
        	cliente3.oferecerIngressoParaVenda(ingresso3, 50.0, marketplace); 
        	cliente4.oferecerIngressoParaVenda(ingresso1, 30.0, marketplace);  //ingresso não pertence ao cliente 4 - ERRO
        } catch (IngressoNaoPertenceAoClienteException e) {
			System.out.println(e.getMessage());
		}
        
        //Cancelando ingressos
        //Se o cancelamento for bem sucedido, é enviada uma notificação para o cliente, por e-mail e SMS
        try {
            cliente3.cancelarIngresso(eventoShow);
            cliente1.cancelarIngresso(eventoJogo);  //erro - ingresso não encontrado
        } catch (IngressoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
        
        //Visualização dos ingressos do cliente 2 e 3
        System.out.println("\nIngressos do cliente: " + cliente2.getNome());
        if (cliente2.getIngressos().isEmpty()) {
        	System.out.println("Nenhum ingresso encontrado.");
        }else {
        	for (Ingresso ingresso : cliente2.getIngressos()) {
        		System.out.println("- " + ingresso.getEvento().getNome() + " - Preço: R$ " + ingresso.getPreco());
        	}
        }
        
        System.out.println("\nIngressos do cliente: " + cliente3.getNome());
        if (cliente3.getIngressos().isEmpty()) {
			System.out.println("Nenhum ingresso encontrado.");
		}else {
			for (Ingresso ingresso : cliente3.getIngressos()) {
				System.out.println("- " + ingresso.getEvento().getNome() + " - Preço: R$ " + ingresso.getPreco());
			}
		}
        
		//Listando ofertas no marketplace
		System.out.println("\nOfertas disponíveis no Marketplace:");
		for (OfertaIngresso oferta : marketplace.listarOfertas()) {
			System.out.println("- " + oferta);
		}
		
		//Comprando ingressos no marketplace
		try {
			cliente2.comprarIngressoNoMarketplace(marketplace.listarOfertas().get(0), marketplace); 
			cliente1.comprarIngressoNoMarketplace(marketplace.listarOfertas().get(1), marketplace); 
			cliente4.comprarIngressoNoMarketplace(marketplace.listarOfertas().get(2), marketplace); 
		} catch (OfertaNaoEncontradaException e) {
			System.out.println(e.getMessage());
		} catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		}
		
		//Visualização dos ingressos do cliente 2 e 3 após compra no marketplace
		System.out.println("\nIngressos do cliente após compra no Marketplace: " + cliente2.getNome());
		if (cliente2.getIngressos().isEmpty()) {
			System.out.println("Nenhum ingresso encontrado.");
		}
		else {
			for (Ingresso ingresso : cliente2.getIngressos()) {
				System.out.println("- " + ingresso.getEvento().getNome() + " - Preço: R$ " + ingresso.getPreco());
			}
		}
		
		System.out.println("\nIngressos do cliente após compras no Marketplace: " + cliente3.getNome());
		if (cliente3.getIngressos().isEmpty()) {
			System.out.println("Nenhum ingresso encontrado.");
		}else {
			for (Ingresso ingresso : cliente3.getIngressos()) {
				System.out.println("- " + ingresso.getEvento().getNome() + " - Preço: R$ " + ingresso.getPreco());
			}
		}
		
		//Listando ofertas no marketplace após compras
		System.out.println("\nOfertas disponíveis no Marketplace após compras:");
		if (marketplace.listarOfertas().isEmpty()) {
			System.out.println("Nenhuma oferta disponível.");
		}
		else {
			for (OfertaIngresso oferta : marketplace.listarOfertas()) {
				System.out.println("- " + oferta);
			}
		}
	}

	public List<Organizadora> getOrganizadoras() {
		return organizadoras;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public List<Evento> getEventos() {
		return eventos;
	}
	
	public Marketplace getMarketplace() {
		return marketplace;
	}

}