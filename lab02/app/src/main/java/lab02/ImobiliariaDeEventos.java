/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab02;

import java.util.List;
import java.util.ArrayList;

public class ImobiliariaDeEventos {
    
    /**
     * Atributos da classe ImobiliariaDeEventos
     */
    private List<Local> locais;
    private String nome;
    private List<Local> LocaisEncontradosCapacidade;

    /**
     * Construtor da classe ImobiliariaDeEventos
     * @param nome o nome da imobiliária de eventos
     */
    public ImobiliariaDeEventos(String nome) {
        this.nome = nome;
        this.locais = new ArrayList<Local>();
    }

      /**
     * Retorna o nome da imobiliária de eventos
     * @return o nome da imobiliária
     */
    public String getNome() {
        return nome;
    }

    /**
     * Altera o nome da imobiliária de eventos para `nome`
     * @param nome o novo nome da imobiliária
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a lista de locais disponíveis
     * @return a lista de locais disponíveis
     */
    public List<Local> getLocais() {
        return locais;
    }

    /**
     * Adiciona um local à lista de locais disponíveis
     * @param local o local a ser adicionado
     */
    public void adicionarLocal(Local local) {
        this.locais.add(local);
    }

    /**
     * Busca um local pelo nome na lista de locais disponíveis
     * @param nome o nome do local a ser buscado
     * @return o local encontrado ou null se não encontrado
     */
    public Local buscarLocal(String nome) {
        for (Local local : locais) {
            if (local.getNome().equalsIgnoreCase(nome)) {
                return local;
            }
        }
        return null; // Retorna null se o local não for encontrado
    }

    /**
     * Busca locais com capacidade maior ou igual a `capacidadeMaxima` buscada
     * @param capacidadeMaxima a capacidade máxima desejada
     * @return uma lista de locais que atendem ao critério de capacidade
     */
    public List<Local> buscarLocal(int capacidadeMaxima) {
        LocaisEncontradosCapacidade = new ArrayList<Local>();
        for (Local local : locais) {
            if (local.getCapacidade() >= capacidadeMaxima) {
                LocaisEncontradosCapacidade.add(local);
            }
        }
        return LocaisEncontradosCapacidade; 

    }
    
}
