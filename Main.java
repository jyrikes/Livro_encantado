
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
  public static void main(String[] args) throws Exception {
    launch(args);
  }

  /* (non-Javadoc)
   * @see javafx.application.Application#start(javafx.stage.Stage)
   */
  @Override
  public void start(Stage primyrStage) throws Exception {
    URL caminho = getClass().getResource("telas/cenas/openCene.fxml");
    FXMLLoader loader = new FXMLLoader(caminho);
    Parent root = loader.load();
    Scene cenaInicial = new Scene(root);
    primyrStage.setResizable(false);
    primyrStage.setScene(cenaInicial);
    primyrStage.setTitle("MAGICBOOK-THE HISTORY");
    primyrStage.show();

  }
}
