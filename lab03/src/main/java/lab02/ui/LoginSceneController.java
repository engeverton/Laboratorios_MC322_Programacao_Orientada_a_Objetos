package lab02.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lab02.model.Cliente;

/**
 * Controlador da cena de login.
 * Gerencia a autenticação dos clientes no sistema.
 */
public class LoginSceneController {

    /** Botão para realizar o login */
    @FXML
    private Button btLogar;

    /** Campo de texto para inserção do email */
    @FXML
    private TextField txtEmail;

    /** Label para exibir mensagens de status (erros ou sucesso) */
    @FXML
    private Label lbStatus;

    /**
     * Ação executada ao clicar no botão "Logar".
     *
     * @param event evento de clique no botão
     * @throws Exception se ocorrer erro ao trocar de tela
     */
    @FXML
    void AcaoLogar(ActionEvent event) throws Exception {
        Main main = new Main();

        String email = txtEmail.getText();

        // Verifica se o campo de email está vazio
        if (email.isEmpty()) {
            lbStatus.setText("Por favor, insira um email.");
            return;
        }

        // Procura o cliente com o email informado
        Cliente clienteEncotrado = null;
        for (Cliente cliente : Main.SistemaGerenciador.getClientes()) {
            if (cliente.getEmail().equals(email)) {
                clienteEncotrado = cliente;
                break;
            }
        }

        // Se cliente for encontrado, faz login e troca de cena
        if (clienteEncotrado != null) {
            Main.ClienteLogado = clienteEncotrado;
            main.changeScene("MenuScene.fxml");
        } else {
            lbStatus.setText("Cliente não encontrado. Verifique o email.");
        }
    }
}
