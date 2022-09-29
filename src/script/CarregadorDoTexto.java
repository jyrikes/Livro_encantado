
package script;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
//import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.transform.Source;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

//import javax.swing.JButton;
//import javax.xml.transform.Source;
import historia.Capitulo;
import historia.CapituloImagem;
import historia.Escolhas;
import historia.Historia;
import historia.Personagem;
import historia.Pessoa;
import telas.TelaPricipal;

/**
 *
 * @author JYrik
 */
public class CarregadorDoTexto {
  TelaPricipal tela;
  Scanner scam;
  public static Capitulo final3;
  public Capitulo raiz;

  public CarregadorDoTexto(TelaPricipal tela) throws IOException {

    // tela.scam = new Scanner(tela.ler.getText());

    System.out.println("tela iniciou");
    // System.out.println(tela.btscam.nextLine());
    this.tela = tela;

    carregar();
    

  }

  /**
   * @throws IOException
   * 
   */
  public void carregar() throws IOException {
    Musica musica = new Musica("./Teasing the King - Nathan Moore.wav");
    musica.play();

    LeitorObjetos ler = new LeitorObjetos();
    
    HashMap<String, Personagem> personagens = ler.lerPersonagensMap("rsc\\JsonFiles\\JsonPersonagens.json");
    Capitulo capitulo = new Capitulo("rsc\\JsonFiles\\JsonCapitulos.json",
    "rsc\\JsonFiles\\JsonEscolhas.json", personagens, tela);
   

    CapituloImagem cap = new CapituloImagem("rsc\\JsonFiles\\JsonCapitulos.json",
    "rsc\\JsonFiles\\JsonEscolhas.json", personagens, tela);
  

    Personagem protagnista = personagens.get("Protagonista");
    protagnista.setComponentesVisuais(tela.getVidaBar1(), tela.getEnergiaBar1(), tela.getNome3());
    Personagem antagonista = new Personagem("Antagonista", 2);
    antagonista.setComponentesVisuais(tela.getVidaBar3(), tela.getEnergiaBar3(), tela.getNome4());

    String nomeRaiz = ler.lerNomeCapitulo("rsc\\JsonFiles\\loads\\loadCapitulo.json");

    raiz = capitulo.getCapitulos().get(nomeRaiz);
    CapituloImagem r1 = (CapituloImagem) cap.getCapitulos().get(nomeRaiz);
    //r1.displayCapitulo(raiz.getPersonagem().getBarEnergia(), raiz.getPersonagem().getBarVida());
    raiz.displayCapitulo(raiz.getPersonagem().getBarEnergia(), raiz.getPersonagem().getBarVida());

  }

}
