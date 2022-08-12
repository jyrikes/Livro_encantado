
package historia;

import java.util.ArrayList;
import java.util.Scanner;

import telas.TelaPricipal;


/**
 *
 * @author JYrik
 */
public class Capitulo {
    TelaPricipal tela;

    String nome;
    public Personagem personagem;
    String texto;
    String[] escolhas ;
    int altVida;
    int altEnergia;
    int idEscolha;
    public int getIdEscolha() {
        return idEscolha;
    }

    public void setIdEscolha(int idEscolha) {
        this.idEscolha = idEscolha;
    }
    javax.swing.JLabel barVida;
    javax.swing.JLabel barEnergia;
    javax.swing.JTextArea area;

    


  
        

    
    public Capitulo(String nome,
                    String texto, 
                    String[] escolhas,
                    Personagem personagem,
                    int altVida,
                    int altEnergia,
                    javax.swing.JTextArea area)
    {
        this.nome = nome;
        this.personagem = personagem;
        this.texto = texto;
        this.escolhas = escolhas;
        this.altVida = altVida;
        this.altEnergia = altEnergia;
        this.area = area;
       
    }
    public void mudarPersonagem(){
        personagem.setEnergia(personagem.getEnergia()+ altEnergia);
        personagem.setVida(personagem.getVida()+ altVida);
    }

    public  void displayCapitulo(javax.swing.JLabel barVida, javax.swing.JLabel barEnergia)
    {
        this.mudarPersonagem();
        personagem.displayPersonagem(personagem.getEnergia(),personagem.getVida(),barVida,barEnergia);
        
       
        area.append(texto+"\n");
        

        if(escolhas != null){
            
            for (String escolha : escolhas) {
                area.append(escolha+"\n");
            }

        }
        else{
            area.append(" "); 
        }
    }
    public void escolher(Scanner scam){
        int idEscolha =-1;
        if(!escolhas.equals(null)){
            while(idEscolha ==-1){
                tela.textoLido = scam.nextLine();
                for(int i = 0; i<escolhas.length; i++){
                    if(tela.textoLido.equals(escolhas))
                    idEscolha = i;
                }
    
            }

        }
        

        this.setIdEscolha(idEscolha);



    }

    

    
}
