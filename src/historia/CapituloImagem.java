package historia;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


import script.LeitorObjetos;


public class CapituloImagem extends Capitulo {
  private String imagem;
  Historia historia ;
  Personagem personagem ;

  
  /**
   * Constroe  o capitulo imagem e atribui ao atributo capitulos
   * @param caminhoArquivo
   * @param caminhoEscolhas
   * @param personagens
   * @throws IOException
   */
  public CapituloImagem(String caminhoArquivo, String caminhoEscolhas,
  HashMap<String, Personagem> personagens) throws IOException {
   this.capitulos= this.lerCapitulosMap(caminhoArquivo, caminhoEscolhas, personagens);
  }

  /* (non-Javadoc)
   * @see historia.Capitulo#lerCapitulosMap(java.lang.String, java.lang.String, java.util.HashMap)
   */
  @Override
  public HashMap<String, Capitulo> lerCapitulosMap(String caminhoArquivo, String caminhoEscolhas,
      HashMap<String, Personagem> personagens) throws IOException {
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

}