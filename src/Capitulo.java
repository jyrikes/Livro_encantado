
import javax.swing.JTextArea;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author JYrik
 */
public class Capitulo  {

    /**
     *
     * @param escolhaSim
     * @param texto
     */
  
    String nome = "Inicio de Tudo";
    Personagem p1; 
    String historia ;
    String escolha1 ;
    String escolha2 ;
    javax.swing.JTextArea area;
    javax.swing.JLabel barVida;
    javax.swing.JLabel barEnergia;
    
 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Personagem getP1() {
        return p1;
    }

    public void setP1(Personagem p1) {
        this.p1 = p1;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getEscolha1() {
        return escolha1;
    }

    public void setEscolha1(String escolha1) {
        this.escolha1 = escolha1;
    }

    public String getEscolha2() {
        return escolha2;
    }

    public void setEscolha2(String escolha2) {
        this.escolha2 = escolha2;
    }

   
    public Capitulo(String nome, Personagem p1, javax.swing.JTextArea area) {
        this.p1 = p1;
        this.area = area;
        this.nome = nome;
        
    }
    
//    
//    public  void displayEscolha(String escolha, javax.swing.JLabel label, int vidaAlt , int enerAlt){
//        p1.setEnergia(p1.getEnergia()+ enerAlt);
//        p1.setVida(p1.getVida()+ vidaAlt);
//        label.setText(escolha);
//        p1.displayPersonagem(p1.getEnergia(),p1.getVida());
//
//    }
    
    
    public  void displayEscolha(String escolha,int vidaAlt , int enerAlt, javax.swing.JLabel barVida, javax.swing.JLabel barEnergia)
    {
        
        p1.setEnergia(p1.getEnergia()+ enerAlt);
        p1.setVida(p1.getVida()+ vidaAlt);
        area.append(escolha);
        p1.displayPersonagem(p1.getEnergia(),p1.getVida(),barVida,barEnergia);
    }



   
}
