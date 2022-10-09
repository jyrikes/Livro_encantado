import java.net.URL;
import java.util.ResourceBundle;

import historia.Capitulo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import script.CarregadorCapitulo;

public class ControleMainCene implements Initializable {

  ControleCapitulo controleCapitulo = new ControleCapitulo();

  // Componente FXML
  @FXML
  private HBox buttons_space;

  @FXML
  private Button bt_recarregar;

  @FXML
  private TextArea textArea;

  @FXML
  private Label barVida1;

  @FXML
  private Label barVida2;

  @FXML
  private Label barEnergia1;

  @FXML
  private Label barEnergia2;

  @FXML
  private ImageView imagem_capitulo;

  /*
   * (non-Javadoc)
   * 
   * @see javafx.fxml.Initializable#initialize(java.net.URL,
   * java.util.ResourceBundle)
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    Image imagem = new Image(getClass().getResourceAsStream("rsc/imagens/imagem1.jpg"));
    imagem_capitulo.setImage(imagem);

  }

  /**
   * Método reponsável por inicializar os dados na cena
   * 
   * @param capitulo
   * @param carregador
   */
  public void initData(Capitulo capitulo, CarregadorCapitulo carregador) {
    controleCapitulo.displayCapitulo(capitulo, carregador, this);

  }

  /**
   * Método que retorna a barra de energia do primeiro personagem
   * 
   * @return Barra de energia do primeiro personagem
   */
  public Label getBarEnergia1() {
    return barEnergia1;
  }

  /**
   * Método que retorna a barra de energia do segundo pesegundo
   * 
   * @return Barra de energia do segundo personagem
   */
  public Label getBarEnergia2() {
    return barEnergia2;
  }

  /**
   * Método que retorna barra de vida do primeiro personagem
   * 
   * @return barra de vida do primeiro personagem
   */
  public Label getBarVida1() {
    return barVida1;
  }

  /**
   * Método que retorna barra de vida do segundo personagem
   * 
   * @return barra de vida do segundo personagem
   */
  public Label getBarVida2() {
    return barVida2;
  }

  /**
   * Método que retorna a área de texto para os capítulos
   * 
   * @return Área de texto dos capítulos
   */
  public TextArea getTextArea() {
    return textArea;
  }

  /**
   * @return retorna Hbox dos botões
   */
  public HBox getButtons_space() {
    return buttons_space;
  }

  /**
   * @return retorna o elemento ImageView
   */
  public ImageView getImagem_capitulo() {
    return imagem_capitulo;
  }

  /**
   * @return retorna o botão de recarregamento
   */
  public Button getBt_recarregar() {
    return bt_recarregar;
  }

}
