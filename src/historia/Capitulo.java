
package historia;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
//import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedList;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import script.CarregadorCapitulo;
import script.LeitorObjetos;

/**
 *
 * @author JYrik
 */
public class Capitulo implements Serializable {

  private static final long serialVersionUID = 1L;

  protected Historia historia = new Historia();
  protected String nome = historia.getNome();
  protected Personagem personagem;
  protected String texto = historia.getTexto();
  protected ArrayList<Escolhas> escolhas;
  protected int altVida = historia.getAltVida();
  protected int altEnergia = historia.getAltEnergia();
  protected int idEscolha;
  protected javax.swing.JLabel barVida;
  protected javax.swing.JLabel barEnergia;
  protected javax.swing.JTextArea area;
  protected HashMap<String, Capitulo> capitulos;

  
  // CONSTRUTORES DOS CAPITULOS


  /**
   * Construtor padrão de capítulo
   */
  public Capitulo() {

  }

  /**
   * Constroe um capítulo partindo do personagem e da história
   * @param historia
   * @param personagem
   */
  public Capitulo(Historia h, Personagem personagem) {
    historia.setNome(h.getNome());
    this.personagem = personagem;
    historia.setTexto(h.getTexto());
    this.escolhas = new ArrayList<>();
    historia.setAltVida(h.getAltVida());
    historia.setAltEnergia(h.getAltEnergia());
  }

  /**
   * Construtor que constroe capítulos partindo da leitura do arquivo Json
   * Os capitulos lidos são atribuidos ao atributo capitulos
   * @param caminhoCapitulos
   * @param caminhoEscolhas
   * @param personagem
   * @throws IOException
   */
  public Capitulo(String caminhoCapitulos, String caminhoEscolhas,
   HashMap<String, Personagem> personagem) throws IOException {

    this.capitulos = this.lerCapitulosMap(caminhoCapitulos, caminhoEscolhas, personagem);

  }

 
  /**
   * Esse método faz a leitura dos capítulos utilizando o arquivo Json 
   * Ele retorna um HashMap onde a key é o nome do capítulo .
   * @param caminhoArquivo
   * @param caminhoEscolhas
   * @param personagens
   * @return HashMap<String,capitulos> 
   * @throws IOException
   */
  public HashMap<String, Capitulo> lerCapitulosMap(String caminhoArquivo, String caminhoEscolhas,
    HashMap<String, Personagem> personagens) throws IOException {
    LeitorObjetos ler = new LeitorObjetos();

    HashMap<String, Capitulo> capitulos = new HashMap<>();
    ArrayList<Capitulo> caps = new ArrayList<>();
    try {
      com.google.gson.Gson json = new GsonBuilder().setPrettyPrinting().create();
      FileReader filereader = new FileReader(caminhoArquivo);

      java.lang.reflect.Type tipoLista = new TypeToken<LinkedList<Historia>>() {
      }.getType();

      LinkedList<Historia> historia = json.fromJson(filereader, tipoLista);

      HashMap<String, ConteudoEscolhas> conteudos = ler.lerConteudoEscolhasMap(caminhoEscolhas);
      for (Historia h : historia) {

        Capitulo cap = new Capitulo(h, personagens.get(h.getNomePersonagem()));
        capitulos.put(h.getNome(), cap);
        caps.add(cap);

      }

      ArrayList<String> chaves = new ArrayList<>();
      for (String key : conteudos.keySet()) {
        ConteudoEscolhas c = conteudos.get(key);
        String escolhas = c.getEscolha();
        Capitulo capituloAtual = capitulos.get(c.getNomeCapituloAtual());
        Capitulo capituloEscolhido = capitulos.get(c.getNomeCapituloEscolhido());
        String idEscolhas = c.getIdEcolha();
        Escolhas e = new Escolhas(escolhas, capituloAtual, capituloEscolhido, idEscolhas);
        capituloAtual.getEscolhas().add(e);
      }

      filereader.close();

    } catch (FileNotFoundException e) {

      e.printStackTrace();

    }

    return capitulos;

  }

  public HashMap<String, Capitulo> getCapitulos() {
    return capitulos;
  }

  public void setCapitulos(HashMap<String, Capitulo> capitulos) {
    this.capitulos = capitulos;
  }

  public Historia getHistoria() {
    return historia;
  }

  public void setHistoria(Historia historia) {
    this.historia = historia;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Personagem getPersonagem() {
    return personagem;
  }

  public void setPersonagem(Personagem personagem) {
    this.personagem = personagem;
  }

  public String getTexto() {
    return texto;
  }

  public void setTexto(String texto) {
    this.texto = texto;
  }

  public ArrayList<Escolhas> getEscolhas() {
    return escolhas;
  }

  public void setEscolhas(ArrayList<Escolhas> escolhas) {
    this.escolhas = escolhas;
  }

  public int getAltVida() {
    return altVida;
  }

  public void setAltVida(int altVida) {
    this.altVida = altVida;
  }

  public int getAltEnergia() {
    return altEnergia;
  }

  public void setAltEnergia(int altEnergia) {
    this.altEnergia = altEnergia;
  }

  public int getIdEscolha() {
    return idEscolha;
  }

  public void setIdEscolha(int idEscolha) {
    this.idEscolha = idEscolha;
  }



}