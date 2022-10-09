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
  public Pessoa pessoa = new Pessoa();

  public Pessoa getPessoa() {
    return pessoa;
  }

  public void setPessoa(Pessoa p) {
    this.pessoa = p;
  }

  private String nome = pessoa.getNome();
  private int vida = pessoa.getVida();
  private int energia = pessoa.getEnergia();
  private int id = pessoa.getId();
  private int pontos;
  private boolean alive;

 
  public Personagem(String nome,
      int id) {
    pessoa.setNome(nome);
    pessoa.setVida(3);
    pessoa.setEnergia(3);
    pessoa.setId(id);
    this.pontos = 0;

  }

  public Personagem(Pessoa pessoa) {
    pessoa.setNome(pessoa.getNome());
    pessoa.setEnergia(pessoa.getEnergia());
    pessoa.setVida(pessoa.getVida());
    pessoa.setId(pessoa.getId());
    pessoa.setAlive(true);
    this.pontos = 0;

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
    return pessoa.isAlive();
  }

  public void serAlive(boolean alive) {
    pessoa.setAlive(alive);
  }

  public void a(String id) {
    // vidaBar
  }

  public String getNome() {
    return pessoa.getNome();
  }

  public void setNome(String nome) {
    pessoa.setNome(nome);
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
    return pessoa.getId();
  }

  public void setId(int id) {
    pessoa.setId(id);
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

 

  
    
 

}
