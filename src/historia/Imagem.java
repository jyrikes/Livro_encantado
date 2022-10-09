package historia;

import java.io.Serializable;
import java.lang.reflect.Type;

public class Imagem  extends Historia implements Serializable, Type{
  private static final long serialVersionUID = 1L;
  private String imagem = super.getImagem();
 

  public Imagem(Historia historia){
    this.imagem = historia.getImagem();
    this.nome = historia.getNome();
  }

  public String getImagem() {
    return imagem;
  }

  public void setImagem(String imagem) {
    this.imagem = imagem;
  }
  
}
