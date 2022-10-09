import historia.Capitulo;
import historia.Historia;
import historia.Personagem;
import historia.Pessoa;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;

public class ControlePersonagem {
  Personagem person;
  ControleMainCene main;
  Pessoa p;

  /**
   * Esse método é responsável por construir o controle dos personagens
   * é nele que modificamos os atributos de vida e energia do personagem.
   * 
   * @param personagem
   * @param capitulo
   */
  public ControlePersonagem(Personagem personagem, Capitulo capitulo) {

    person = personagem;
    p = person.getPessoa();
    Historia h = capitulo.getHistoria();
    p.setEnergia(p.getEnergia() + h.getAltEnergia());
    p.setVida(p.getVida() + h.getAltVida());

  }

  /**
   * 
   * Método responsável por apresentar na tela a vida do personagem
   * 
   * @param vida
   * @param barVida
   */
  public void diplayStatusVida(Label barVida) {

    int vida = person.getPessoa().getVida();

    switch (vida) {

      case 1 -> {
        barVida.setText(" ❤");
        p.setVida(vida);

      }
      case 0 -> {
        barVida.setText(" ");
        p.setAlive(false);
      }
      case 2 -> {
        barVida.setText(" ❤ ❤");
        p.setVida(vida);

      }
      case 3 -> {
        barVida.setText(" ❤ ❤ ❤ ");
        p.setVida(vida);

      }

      default -> {
      }
    }
  }

  /**
   * Método resposável por apresentar na tela a energia do personagem
   * 
   * @param barEnergia
   */
  public void displayStatusEnergia(Label barEnergia) {
    int energia = person.getPessoa().getEnergia();

    switch (energia) {

      case 1 -> {
        barEnergia.setText(" ✨");
        p.setEnergia(energia);

      }
      case 0 -> {
        barEnergia.setText(" ");
        p.setEnergia(energia);

      }
      case 2 -> {
        barEnergia.setText(" ✨ ✨");
        p.setEnergia(energia);

      }
      case 3 -> {
        barEnergia.setText(" ✨ ✨ ✨ ");
        p.setEnergia(energia);

      }

      default -> {
      }
    }
  }

  /**
   * 
   * Método responsável por construir graficamente na tela todo o personagem
   * 
   * @param barVida
   * @param barEnergia
   */
  public void displayPersonagem(Label barVida, Label barEnergia) {

    System.out.println(person.getPessoa().getVida());
    this.diplayStatusVida(barVida);
    this.displayStatusEnergia(barEnergia);
    person.setNome(p.getNome());

  }

}
