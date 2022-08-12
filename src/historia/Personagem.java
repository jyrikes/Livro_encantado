package historia;

import java.util.Objects;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author JYrik
 */
public class Personagem extends JFrame {
    String nome;
    int vida = 3;
    int energia = 3;
    int id;
    int pontos;
    
    boolean alive;
    javax.swing.JLabel barVida;
    javax.swing.JLabel barEnergia;
    javax.swing.JLabel nome3;

    
    public int getPontos() {
        return pontos;
    }
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public boolean  isAlive(){
     return alive;
}
    public void serAlive(boolean alive){
        this.alive = alive;
    }
    public void a (String id){
        //vidaBar
    }

    public Personagem(String nome ,
                      int id, javax.swing.JLabel barVida,
                      javax.swing.JLabel barEnergia,
                      javax.swing.JLabel nome3 ) 
    {
        this.nome = nome;
        this.vida = 3;
        this.energia = 3;
        this.id = id;
        this.barEnergia = barEnergia;
        this.barVida = barVida;
        this.nome3 = nome3;
        this.pontos = 0;
        
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
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    public void diplayStatusVida (int vida, javax.swing.JLabel barVida ){
        switch (vida) {
            
            
            case 1 -> {
                barVida.setText(" ❤");
                this.vida = 1;
            }
            case 0 ->{
                barVida.setText(" ");
                this.alive = false;
            }
            case 2 -> {
                barVida.setText(" ❤ ❤");
                this.vida = 2;

            }
            case 3->{
                barVida.setText(" ❤ ❤ ❤ ");
                this.vida = 3;
            }
        
            default -> {
            }
         }
    }
    public void displayStatusEnergia(int energia, javax.swing.JLabel barEnergia){
        switch (energia) {
            case 1 -> {
                barEnergia.setText(" ✨");
                this.energia = 1;
            }
            case 0 ->{
                barEnergia.setText(" ");
                this.energia = 0;
            }
            case 2 -> {
                barEnergia.setText(" ✨ ✨");
                this.energia = 2;

            }
            case 3->{
                barEnergia.setText(" ✨ ✨ ✨ ");
                this.energia = 3;
            }
        
            default -> {
            }
         }
    }
    public void displayPersonagem(int energia,int vida, javax.swing.JLabel barVida,javax.swing.JLabel barEnergia){
        this.diplayStatusVida(this.vida,barVida);
        this.displayStatusEnergia(this.energia, barEnergia);
        this.setNome(this.getNome());
    }
    public boolean temEnergia(){
        boolean temEnergia;
        if(this.getEnergia()>0){
            temEnergia = true;
        }
        else{
            temEnergia = false;
        }
        return temEnergia;
    }
    public boolean temVida(){
        boolean temVida;
        if(this.getVida()>0){
            temVida = true;
        }
        else{
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
    
    

}
