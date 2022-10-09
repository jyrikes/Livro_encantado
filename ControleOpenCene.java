
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import historia.Capitulo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import script.CarregadorCapitulo;

public class ControleOpenCene implements Initializable {

  ControleMainCene main;
  FXMLLoader loader;

  @FXML
  private ImageView imagem_inicial;

  @FXML
  private Button iniciar;

  /**
   * Método resposável pela transição entre a tela inicial e a tela principal
   * 
   * @param event
   * @throws IOException
   */
  @FXML
  public void mudarTela(ActionEvent event) throws IOException {
    Capitulo capituloControle = new Capitulo();
    CarregadorCapitulo carregador = new CarregadorCapitulo();
    ControleCapitulo controleCapitulo = new ControleCapitulo();

    // Carregamento do controlador
    loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("telas/cenas/mainCene.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    main = loader.getController();

    // Construção do FXML
    capituloControle = controleCapitulo.lerCapitulos(carregador);
    main.initData(capituloControle, carregador);
    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.setResizable(false);
    window.setScene(scene);
    window.show();

  }

  /*
   * Esse método inicializa a cena
   * 
   * @see javafx.fxml.Initializable#initialize(java.net.URL,
   * java.util.ResourceBundle)
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {

    Image imagem = new Image(getClass().getResourceAsStream("rsc/imagens/imagem1.jpg"));
    imagem_inicial.setImage(imagem);
  }

}
