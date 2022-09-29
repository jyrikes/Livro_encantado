package historia;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JLabel;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import script.LeitorObjetos;
import telas.TelaPricipal;

public class CapituloImagem extends Capitulo {
  private String imagem;
  Historia historia ;
  Personagem personagem ;

  public CapituloImagem(){
    this.tela = super.tela;
    this.area= super.area;
  }

  public CapituloImagem(String caminhoArquivo, String caminhoEscolhas,
  HashMap<String, Personagem> personagens, TelaPricipal tela) throws IOException {
   this.capitulos= this.lerCapitulosMap(caminhoArquivo, caminhoEscolhas, personagens, tela);
  }

  @Override
  public HashMap<String, Capitulo> lerCapitulosMap(String caminhoArquivo, String caminhoEscolhas,
      HashMap<String, Personagem> personagens, TelaPricipal tela) throws IOException {
      LeitorObjetos ler = new LeitorObjetos();
      HashMap<String,Capitulo> capitulos = new HashMap<>();
      HashMap<String,Imagem> imagens = ler.lerImagensMap(caminhoArquivo);
      ArrayList<String> chaves = new ArrayList<>();
            for (String key : imagens.keySet()) {
              Imagem img = imagens.get(key);
              if(img.getImagem() != null ){
              Capitulo capitulo = new Capitulo();
              capitulo.getHistoria().setNome(key);
              capitulo.getHistoria().setTexto(img.getImagem());
              System.out.println(capitulo.getNome());
              capitulos.put(img.getNome(), capitulo);

              }
              

            }

      
    return capitulos;
  }
  @Override
  public void displayCapitulo(JLabel barVida, JLabel barEnergia) {
    area.append(this.getTexto() + "\n");

    super.displayCapitulo(barVida, barEnergia);
  }
}