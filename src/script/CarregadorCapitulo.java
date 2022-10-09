
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


import javax.xml.transform.Source;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


import historia.Capitulo;
import historia.CapituloImagem;
import historia.Escolhas;
import historia.Historia;
import historia.Personagem;
import historia.Pessoa;


/**
 *
 * @author JYrik
 */
public class CarregadorCapitulo {

  private Capitulo capitulo;
  private Capitulo raiz;
  private CapituloImagem imagem;
  private  Musica musica;

  public Capitulo getCapitulo() {
    return capitulo;
  }

  public void setCapitulo(Capitulo capitulo) {
    this.capitulo = capitulo;
  }

  public Capitulo getRaiz() {
    return raiz;
  }

  public void setRaiz(Capitulo raiz) {
    this.raiz = raiz;
  }

  public CapituloImagem getImagem() {
    return imagem;
  }

  public void setImagem(CapituloImagem imagem) {
    this.imagem = imagem;
  }
  public Musica getMusica() {
    return musica;
  }

  public CarregadorCapitulo() throws IOException {

    carregar();
  }

  /**
   * @throws IOException
   * 
   */
  public void carregar() throws IOException {

    LeitorObjetos ler = new LeitorObjetos();
    musica = new Musica("./Teasing the King - Nathan Moore.wav");
    musica.play();

    
    
    HashMap<String, Personagem> personagens = ler.lerPersonagensMap
    ("rsc\\JsonFiles\\JsonPersonagens.json");
    capitulo = new Capitulo("rsc\\JsonFiles\\JsonCapitulos.json",
    "rsc\\JsonFiles\\JsonEscolhas.json", personagens);
   

    imagem = new CapituloImagem("rsc\\JsonFiles\\JsonCapitulos.json",
    "rsc\\JsonFiles\\JsonEscolhas.json", personagens);
  
    String nomeRaiz = ler.lerNomeCapitulo
    ("rsc\\JsonFiles\\loads\\loadCapituloGravado.json");

    raiz = capitulo.getCapitulos().get(nomeRaiz);
    raiz.setCapitulos(capitulo.getCapitulos());


  }

}
