package historia;

import java.io.Serializable;
import java.lang.reflect.Type;

public class Imagem  extends Historia implements Serializable, Type{
  private static final long serialVersionUID = 1L;
  private String imagem;
 

  public Imagem(String imagem){
    this.imagem = imagem;
    this.nome = super.getNome();
    this.texto = null;
    this.altEnergia = 0;
    this.altVida = 0;
    this.nomePersonagem = null;
    

  }

  public String getImagem() {
    return imagem;
  }

  public void setImagem(String imagem) {
    this.imagem = imagem;
  }
  
}
