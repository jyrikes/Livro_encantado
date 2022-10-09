import java.io.IOException;
import java.util.HashMap;

import javax.print.DocFlavor.URL;

import historia.Capitulo;
import historia.CapituloImagem;
import historia.Escolhas;
import historia.Personagem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import script.CarregadorCapitulo;
import script.Escritor;
import script.LeitorObjetos;

public class ControleCapitulo {

  // Objetos iniciais
  Escritor escritor = new Escritor();
  LeitorObjetos leitor = new LeitorObjetos();
  Capitulo capituloControle;
  ControleMainCene main;
  FXMLLoader loader;

  /**
   * Inicializador padrão do controle capitulo
   */
  public ControleCapitulo() {
  }
  
  /**
   * @param carregador
   * @return Retorna o capítulo de load gavado
   * @throws IOException
   */
  public Capitulo lerCapitulos(CarregadorCapitulo carregador) throws IOException {

    capituloControle = carregador.getRaiz();
    return capituloControle;

  }

  /**
   * 
   * Método reponsável por exibir o capítulo na tela
   * 
   * @param capitulo     Capitulo a ser exibido
   * @param carregador   Objeto que leu o capitulo
   * @param controleMain Obejto que controla onde o capítulo será exibido
   */
  public void displayCapitulo(Capitulo capitulo, CarregadorCapitulo carregador, ControleMainCene controleMain) {
    Capitulo capituloImagem = carregador.getImagem();
    HashMap<String, Capitulo> imagens = capituloImagem.getCapitulos();

    main = controleMain;

    Personagem person = capitulo.getPersonagem();

    main.getTextArea().clear();
    main.getButtons_space().getChildren().clear();

    main.getTextArea().setText(capitulo.getHistoria().getTexto());
    ControlePersonagem controlePersonagem = new ControlePersonagem(person, capitulo);
    controlePersonagem.displayPersonagem(main.getBarVida1(), main.getBarEnergia1());

    if (capitulo.getEscolhas().size() > 0) {
      for (Escolhas escolha : capitulo.getEscolhas()) {
        Button botao = new Button(escolha.getConteudo().getEscolha());
        botao.setOnAction(new EventHandler<ActionEvent>() {

          @Override
          public void handle(ActionEvent arg0) {

            if (capitulo.getPersonagem().getPessoa().isAlive() &&
                capitulo.getPersonagem().getPessoa().temEnergia()) {

              String nomeProximoCapitulo = escolha.getConteudo().getNomeCapituloEscolhido();
              Capitulo proximoCapitulo = capitulo.getCapitulos().get(nomeProximoCapitulo);
              proximoCapitulo.setCapitulos(capitulo.getCapitulos());
              String link_Imagem = imagens.get(nomeProximoCapitulo).getHistoria().getTexto();
              Image imagem = new Image(getClass().getResourceAsStream(link_Imagem));
              if (!(imagem == null)) {
                main.getImagem_capitulo().setImage(imagem);

              }

              try {
                escritor.escreverCapitulo("rsc/JsonFiles/loads/loadCapituloGravado.json", capitulo);
                displayCapitulo(proximoCapitulo, carregador, main);
              } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
              }

            }
            if (!capitulo.getPersonagem().getPessoa().temEnergia()) {
              displayCapitulo(capitulo.getCapitulos()
                  .get("Terceiro final"), carregador, controleMain);
            }
            if (!capitulo.getPersonagem().getPessoa().isAlive()) {
              displayCapitulo(capitulo.getCapitulos()
                  .get("Terceiro final"), carregador, controleMain);

            }

            main.getBt_recarregar().setOnAction(new EventHandler<ActionEvent>() {

              @Override
              public void handle(ActionEvent arg0) {
                try {
                  recarregarCapituloInicial(main, carregador);
                } catch (IOException e) {

                  e.printStackTrace();
                }

              }

            });

          }

        });
        main.getButtons_space().getChildren().add(botao);

      }
    }
  }

  /**
   * 
   * Método chamdo dentro da ação do botão recarregar 
   * Ao ser chamado esse método reinicia no primeiro capítulo a tela
   * Esse método não altera os atributos dos personagens 
   * @param controleMain
   * @param carregador
   * @throws IOException
   */
  public void recarregarCapituloInicial(ControleMainCene controleMain, CarregadorCapitulo carregador)
      throws IOException {
    main = controleMain;
    String nomeCapitulo = leitor.lerNomeCapitulo("rsc/JsonFiles/loads/loadCapituloInicial.json");
    Capitulo capitulo = carregador.getCapitulo().getCapitulos().get(nomeCapitulo);
    escritor.escreverCapitulo("rsc/JsonFiles/loads/loadCapituloGravado.json", capitulo);
    displayCapitulo(capitulo, carregador, main);
    Image imagem = new Image(getClass().getResourceAsStream("rsc/imagens/imagem1.jpg"));
    main.getImagem_capitulo().setImage(imagem);
  }
 

}
