package historia;

import java.io.Serializable;
import java.lang.reflect.Type;

public class Historia implements Serializable, Type {

  private static final long serialVersionUID = 1L;
  protected String nome;
  protected String texto;
  protected int altVida;
  protected int altEnergia;
  protected String nomePersonagem;
  protected String imagem;
  

  public String getNomePersonagem() {
    return nomePersonagem;
  }

  public void setNomePersonagem(String nomePersonagem) {
    this.nomePersonagem = nomePersonagem;
  }

  public String getTexto() {
    return texto;
  }

  public void setTexto(String texto) {
    this.texto = texto;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
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
  public String getImagem() {
    return imagem;
  }
  public void setImagem(String imagem) {
    this.imagem = imagem;
  }

}
