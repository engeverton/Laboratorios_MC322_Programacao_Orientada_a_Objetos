package lab02.ui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import lab02.Excecoes.EventoNaoEncontradoException;
import lab02.Excecoes.IngressoEsgotadoException;
import lab02.Excecoes.SaldoInsuficienteException;
import lab02.model.Cliente;
import lab02.model.Evento;
import lab02.model.SistemaGerenciador;

/**
 * Controlador da cena de listagem de eventos.
 * Permite que o cliente visualize os eventos disponíveis e compre ingressos.
 */
public class EventosSceneController implements Initializable {
    private Cliente clienteLogado = Main.ClienteLogado;
    private Main main = new Main();
    private ObservableList<Evento> eventosList;
    private SistemaGerenciador sistemaGerenciador = Main.SistemaGerenciador;

    @FXML
    private ListView<Evento> lvEventos;

    @FXML
    private Label lbInformacoes;

    @FXML
    private Button BtComprar;

    @FXML
    private Button BtVoltar;

    /**
     * Inicializa o controlador da cena.
     * 
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //carrega os eventos disponíveis no sistema
        carregarEventos();
        // habilita o botão de compra quando um evento é selecionado
        lvEventos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            BtComprar.setDisable(newValue == null);
        });
    }

    /**
     * Ação executada ao clicar no botão "Comprar".
     * Realiza a compra do ingresso para o evento selecionado.
     * 
     * @param event Evento de clique no botão.
     * @throws IngressoEsgotadoException Caso não haja ingressos disponíveis.
     * @throws EventoNaoEncontradoException Caso o evento não seja encontrado.
     */
    @FXML
    void AcaoComprar(ActionEvent event) throws IngressoEsgotadoException, EventoNaoEncontradoException, SaldoInsuficienteException {
        Evento eventoSelecionado = lvEventos.getSelectionModel().getSelectedItem();
        if (eventoSelecionado != null) {
            if (clienteLogado.getSaldo() >= eventoSelecionado.getPrecoIngresso()) {
                eventoSelecionado.venderIngresso(clienteLogado);
                clienteLogado.removerSaldo(eventoSelecionado.getPrecoIngresso());
                alerta("Compra efetuada com sucesso!", "Ingresso comprado para o evento: " + eventoSelecionado.getNome());
                carregarEventos();
            } else {
                alerta("Saldo Insuficiente", "Você não tem saldo suficiente para comprar este ingresso.");
            }
        }
    }

    /**
     * Ação executada ao clicar no botão "Voltar".
     * Retorna para a tela de menu principal.
     * 
     * @param event Evento de clique no botão.
     * @throws Exception Caso haja erro na troca de cena.
     */
    @FXML
    void AcaoVoltar(ActionEvent event) throws Exception {
        main.changeScene("MenuScene.fxml");
    }

    /**
     * Exibe um alerta informativo na interface.
     * 
     * @param titulo   Título do alerta.
     * @param mensagem Mensagem do alerta.
     */
    private void alerta(String titulo, String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(titulo);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }

    /**
     * Carrega os eventos disponíveis no sistema e exibe na ListView.
     * Atualiza as informações do evento selecionado.
     */
    private void carregarEventos() {
        // adiciona os eventos do sistema à lista de eventos
        eventosList = FXCollections.observableArrayList(sistemaGerenciador.getEventos());
        lvEventos.setItems(eventosList);

        // Apresenta as informações do evento selecionado
        lvEventos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                lbInformacoes.setText(newValue.descricao());
            }
        });
    }
}
