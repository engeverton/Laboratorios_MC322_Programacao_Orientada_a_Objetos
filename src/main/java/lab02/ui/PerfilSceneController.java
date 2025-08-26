package lab02.ui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import lab02.Excecoes.IngressoNaoEncontradoException;
import lab02.model.Cliente;
import lab02.model.Ingresso;
import javafx.fxml.Initializable;

/**
 * Controlador da tela de Perfil.
 * Permite visualizar os dados do cliente logado e gerenciar seus ingressos.
 */
public class PerfilSceneController implements Initializable {

    private ObservableList<Ingresso> IngressosList;
    private Cliente clienteLogado = Main.ClienteLogado;
    private Main main = new Main();

    @FXML
    private Label lbEmail;

    @FXML
    private Label lbNome;

    @FXML
    private Label lbSaldo;

    @FXML
    private Label lbTelefone;

    @FXML
    private Button btCancelar;

    @FXML
    private ListView<Ingresso> lvIngressos;


    /**
     * Inicializa a tela de perfil carregando os dados do cliente logado
     * e seus ingressos.
     *
     * @param location não utilizado
     * @param resources não utilizado
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregarIngressos();
        lvIngressos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btCancelar.setDisable(newValue == null);
        });
    }

    /**
     * Ação executada ao clicar no botão "Voltar".
     * Retorna para o menu principal.
     *
     * @param event evento de clique no botão
     * @throws Exception se houver erro na troca de cena
     */
    @FXML
    void AcaoVoltar(ActionEvent event) throws Exception {
        main.changeScene("MenuScene.fxml");
    }

    /**
     * Ação executada ao clicar no botão "Cancelar Ingresso".
     * Cancela o ingresso selecionado na lista do usuário.
     *
     * @param event evento de clique no botão
     * @throws IngressoNaoEncontradoException se o ingresso não for encontrado
     */
    @FXML
    void AcaoCancelarIngresso(ActionEvent event) throws IngressoNaoEncontradoException {
        Ingresso ingressoSelecionado = lvIngressos.getSelectionModel().getSelectedItem();
        if (ingressoSelecionado != null) {
            clienteLogado.cancelarIngresso(ingressoSelecionado.getEvento());
            carregarIngressos();
        }
    }

    /**
     * Carrega os ingressos do cliente na ListView e preenche os dados do perfil.
     */
    private void carregarIngressos() {
        IngressosList = FXCollections.observableArrayList(clienteLogado.getIngressos());
        lvIngressos.setItems(IngressosList);

        lbNome.setText(clienteLogado.getNome());
        lbEmail.setText(clienteLogado.getEmail());
        lbTelefone.setText(clienteLogado.getTelefone());
        lbSaldo.setText(String.format("R$ %.2f", clienteLogado.getSaldo()));
    }
}
