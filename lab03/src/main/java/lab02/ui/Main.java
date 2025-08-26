package lab02.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import lab02.model.Cliente;
import lab02.model.SistemaGerenciador;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Classe principal que inicializa a aplicação JavaFX
 * e gerencia a troca de telas.
 */
public class Main extends Application {

    /** Janela principal da aplicação */
    private static Stage stg;

    /** Instância do sistema gerenciador que controla os dados */
    public static SistemaGerenciador SistemaGerenciador = new SistemaGerenciador();

    /** Cliente atualmente logado no sistema */
    public static Cliente ClienteLogado = null;

    /**
     * Método inicial da aplicação JavaFX.
     * Carrega a tela de login ao iniciar o programa.
     *
     * @param primaryStage janela principal da aplicação
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            stg = primaryStage;
            Parent root = FXMLLoader.load(getClass().getResource("/lab02/ui/LoginScene.fxml"));
            Scene scene = new Scene(root, 600, 400);
            primaryStage.setTitle("Sistema MarketPlace");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Altera a cena (tela) atual da aplicação.
     *
     * @param fxml nome do arquivo FXML da nova tela (ex.: "MenuScene.fxml")
     * @throws Exception se não for possível carregar o FXML
     */
    public static void changeScene(String fxml) throws Exception {
        Parent pane = FXMLLoader.load(Main.class.getResource("/lab02/ui/" + fxml));
        stg.getScene().setRoot(pane);
    }

    /**
     * Método main que inicia a aplicação JavaFX.
     *
     * @param args argumentos de linha de comando
     */
    public static void main(String[] args) {
        launch(args);
    }
}
