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
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import lab02.Excecoes.IngressoNaoPertenceAoClienteException;
import lab02.Excecoes.OfertaNaoEncontradaException;
import lab02.Excecoes.SaldoInsuficienteException;
import lab02.model.Cliente;
import lab02.model.Ingresso;
import lab02.model.OfertaIngresso;
import lab02.model.SistemaGerenciador;

/**
 * Controlador da interface MarketplaceScene.
 * Permite que o cliente logado visualize ingressos à venda,
 * compre ingressos ou ofereça seus próprios ingressos no marketplace.
 */
public class MarketplaceSceneController implements Initializable {


    Main main = new Main();
    private ObservableList<OfertaIngresso> IngressosList;
    private SistemaGerenciador sistemaGerenciador = Main.SistemaGerenciador;

    /** Cliente atualmente logado */
    private Cliente clienteLogado = Main.ClienteLogado;

    @FXML
    private Button btComprar;

    @FXML
    private Button btOferecer;

    @FXML
    private Button btVoltar;

    @FXML
    private TextField txtPreco;

    @FXML
    private TextField txtOferecer;

    @FXML
    private ListView<OfertaIngresso> lvIngressosMarket;

    /**
     * Inicializa a cena, carregando as ofertas e configurando os listeners dos campos.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregarIngressosMarket();

        // Habilita ou desabilita o botão "Comprar" dependendo da seleção
        lvIngressosMarket.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btComprar.setDisable(newValue == null);
        });

        // Valida os campos para habilitar o botão "Oferecer"
        txtPreco.textProperty().addListener((observable, oldValue, newValue) -> validarCampos());
        txtOferecer.textProperty().addListener((observable, oldValue, newValue) -> validarCampos());
    }

        /**
     * Ação executada ao clicar no botão "Comprar".
     * Permite que o cliente compre o ingresso selecionado no marketplace.
     *
     * @param event evento de clique no botão
     */
    @FXML
    void AcaoComprar(ActionEvent event) {
        OfertaIngresso ingressoSelecionado = lvIngressosMarket.getSelectionModel().getSelectedItem();
        if (ingressoSelecionado != null) {
            try {
                clienteLogado.comprarIngressoNoMarketplace(ingressoSelecionado, sistemaGerenciador.getMarketplace());
                carregarIngressosMarket();
            } catch (SaldoInsuficienteException | OfertaNaoEncontradaException e) {
                alerta("Erro", e.getMessage());
            }
        }
    }

    /**
     * Ação executada ao clicar no botão "Oferecer".
     * Permite que o cliente ofereça um ingresso próprio para venda no marketplace.
     *
     * @param event evento de clique no botão
     */
    @FXML
    void AcaoOferecer(ActionEvent event) {
        if (!camposPreenchidos()) {
            alerta("Erro", "Por favor, preencha todos os campos.");
            return;
        }

        String preco = txtPreco.getText();
        String ingressoId = txtOferecer.getText();
        Ingresso ingressoEncontrado = null;

        // Busca ingresso do cliente pelo nome do evento
        for (Ingresso ingresso : clienteLogado.getIngressos()) {
            if (ingresso.getEvento().getNome().equals(ingressoId)) {
                ingressoEncontrado = ingresso;
                break;
            }
        }

        // Se o ingresso não for encontrado, exibe alerta
        if (ingressoEncontrado == null) {
            alerta("Erro", "Ingresso não encontrado na sua lista.");
            return;
        }

        // Tenta oferecer o ingresso para venda no marketplace
        try {
            clienteLogado.oferecerIngressoParaVenda(ingressoEncontrado,
                    Double.parseDouble(preco), sistemaGerenciador.getMarketplace());
            carregarIngressosMarket();
        } catch (IngressoNaoPertenceAoClienteException e) {
            alerta("Erro", e.getMessage());
        }
    }

    /**
     * Ação executada ao clicar no botão "Voltar".
     * Retorna o usuário à tela de menu.
     *
     * @param event evento de clique no botão
     */
    @FXML
    void AcaoVoltar(ActionEvent event) throws Exception {
        main.changeScene("MenuScene.fxml");
    }

    /**
     * Carrega as ofertas de ingressos do marketplace na ListView.
     */
    private void carregarIngressosMarket() {
        IngressosList = FXCollections.observableArrayList(
                sistemaGerenciador.getMarketplace().listarOfertas());
        lvIngressosMarket.setItems(IngressosList);
    }

    /**
     * Verifica se os campos de texto foram preenchidos.
     *
     * @return true se ambos os campos estiverem preenchidos, false caso contrário
     */
    private boolean camposPreenchidos() {
        String preco = txtPreco.getText();
        String ingressoId = txtOferecer.getText();
        return !preco.isEmpty() && !ingressoId.isEmpty();
    }

    /**
     * Valida os campos e ativa ou desativa o botão "Oferecer".
     */
    private void validarCampos() {
        btOferecer.setDisable(!camposPreenchidos());
    }

    /**
     * Exibe uma janela de alerta com uma mensagem personalizada.
     *
     * @param titulo título da janela de alerta
     * @param mensagem mensagem a ser exibida no corpo do alerta
     */
    private void alerta(String titulo, String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(titulo);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
}
