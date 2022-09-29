package historia;

import java.io.Serializable;
import java.util.Objects;
import javax.swing.JFrame;
import javax.swing.JLabel;
import historia.Pessoa;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author JYrik
 */
public class Personagem extends JFrame implements Serializable {
  private static final long serialVersionUID = 1L;
  public Pessoa p = new Pessoa();

  private String nome = p.getNome();
  private int vida = p.getVida();
  private int energia = p.getEnergia();
  private int id = p.getId();
  private int pontos;
  private boolean alive;

  private javax.swing.JLabel barVida;
  private javax.swing.JLabel barEnergia;
  private javax.swing.JLabel nome3;

  /// Preciso refatorar pra mais de um personagem !!!
  public Personagem(String nome,
      int id) {
    p.setNome(nome);
    p.setVida(3);
    p.setEnergia(3);
    p.setId(id);
    this.pontos = 0;

  }

  public Personagem(Pessoa pessoa) {
    p.setNome(pessoa.getNome());
    p.setEnergia(pessoa.getEnergia());
    p.setVida(pessoa.getVida());
    p.setId(pessoa.getId());
    p.setAlive(true);
    this.pontos = 0;

  }

  public void setComponentesVisuais(javax.swing.JLabel barVida, javax.swing.JLabel barEnergia,
      javax.swing.JLabel nome3) {
    this.barVida = barVida;
    this.barEnergia = barEnergia;
    this.nome3 = nome3;

  }

  public String[] getInfo() {

    String nome = getNome();
    String vida = Integer.toString(getVida());
    String energia = Integer.toString(getEnergia());
    String isAlive = Boolean.toString(isAlive());
    String[] informacaoPersonagem = { nome, vida, energia, isAlive };
    return informacaoPersonagem;

  }

  public int getPontos() {
    return pontos;
  }

  public void setPontos(int pontos) {
    this.pontos = pontos;
  }

  public boolean isAlive() {
    return p.isAlive();
  }

  public void serAlive(boolean alive) {
    p.setAlive(alive);
  }

  public void a(String id) {
    // vidaBar
  }

  public JLabel getBarVida() {
    return barVida;
  }

  public void setBarVida(JLabel barVida) {
    this.barVida = barVida;
  }

  public JLabel getBarEnergia() {
    return barEnergia;
  }

  public void setBarEnergia(JLabel barEnergia) {
    this.barEnergia = barEnergia;
  }

  public String getNome() {
    return p.getNome();
  }

  public void setNome(String nome) {
    p.setNome(nome);
  }

  public int getVida() {
    return this.vida;
  }

  public void setVida(int vida) {
    this.vida = vida;
  }

  public int getEnergia() {
    return this.energia;
  }

  public void setEnergia(int energia) {
    this.energia = energia;
  }

  public int getId() {
    return p.getId();
  }

  public void setId(int id) {
    p.setId(id);
  }

  /**
   * @param vida
   * @param barVida
   */
  public void diplayStatusVida(int vida, javax.swing.JLabel barVida) {
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

  public void displayStatusEnergia(int energia, javax.swing.JLabel barEnergia) {
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

  public void displayPersonagem(int energia, int vida, javax.swing.JLabel barVida, javax.swing.JLabel barEnergia) {
    System.out.println(this.energia);
    this.diplayStatusVida(this.vida, barVida);
    this.displayStatusEnergia(this.energia, barEnergia);
    this.setNome(p.getNome());
    nome3.setText(p.getNome());

  }

  public boolean temEnergia() {
    boolean temEnergia;
    if (this.getEnergia() > 0) {
      temEnergia = true;
    } else {
      temEnergia = false;
    }
    return temEnergia;
  }

  public boolean temVida() {
    boolean temVida;
    if (this.getVida() > 0) {
      temVida = true;
    } else {
      temVida = false;
    }
    return temVida;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 53 * hash + Objects.hashCode(this.nome);
    hash = 53 * hash + this.vida;
    hash = 53 * hash + this.energia;
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Personagem other = (Personagem) obj;
    if (this.vida != other.vida) {
      return false;
    }
    if (this.energia != other.energia) {
      return false;
    }
    return Objects.equals(this.nome, other.nome);
  }

  public Personagem get(String nomePersonagem) {
    return null;
  }

}
