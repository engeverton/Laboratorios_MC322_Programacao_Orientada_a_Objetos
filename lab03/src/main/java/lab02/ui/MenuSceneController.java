package lab02.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Controlador da interface MenuScene.
 * Gerencia a navegação entre as telas do sistema após o login.
 */
public class MenuSceneController {
    Main main = new Main();

    @FXML
    private Button btEventos;

    @FXML
    private Button btMarketplace;

    @FXML
    private Button btMeuPerfil;

    @FXML
    private Button btVoltar;

    /**
     * Ação executada ao clicar no botão "Eventos".
     * Redireciona para a tela de gerenciamento de eventos.
     *
     * @param event evento de clique no botão
     * @throws Exception caso ocorra erro na troca de cena
     */
    @FXML
    void AcaoEventos(ActionEvent event) throws Exception {
        main.changeScene("EventosScene.fxml");
    }

    /**
     * Ação executada ao clicar no botão "Marketplace".
     * Redireciona para a tela do marketplace de ingressos.
     *
     * @param event evento de clique no botão
     * @throws Exception caso ocorra erro na troca de cena
     */
    @FXML
    void AcaoMarketplace(ActionEvent event) throws Exception {
        main.changeScene("MarketplaceScene.fxml");
    }

    /**
     * Ação executada ao clicar no botão "Meu Perfil".
     * Redireciona para a tela de perfil do cliente logado.
     *
     * @param event evento de clique no botão
     * @throws Exception caso ocorra erro na troca de cena
     */
    @FXML
    void AcaoMeuPerfil(ActionEvent event) throws Exception {
        main.changeScene("PerfilScene.fxml");
    }

    /**
     * Ação executada ao clicar no botão "Voltar".
     * Retorna para a tela de login.
     *
     * @param event evento de clique no botão
     */
    @FXML
    void AcaoVoltarLogin(ActionEvent event) {
        try {
            main.changeScene("LoginScene.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
