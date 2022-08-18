
package historia;

import java.util.ArrayList;
//import java.util.Scanner;


import telas.Combox;
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
    public ArrayList<Escolhas> escolhas ;
    int altVida;
    int altEnergia;
    int idEscolha;
    public static Combox cb;
 

    ///componentes swing
    javax.swing.JLabel barVida;
    javax.swing.JLabel barEnergia;
    javax.swing.JTextArea area;






    //Capitulo[] proximos;
    public int getIdEscolha() {
        return idEscolha;
    }

    public void setIdEscolha(int idEscolha) {
        this.idEscolha = idEscolha;
    }



    


  
        

    
    public Capitulo(String nome,
                    String texto, 
                    Personagem personagem,
                    int altVida,
                    int altEnergia,
                    TelaPricipal tela
                    )

    {
        this.nome = nome;
        this.personagem = personagem;
        this.texto = texto;
        this.escolhas = new ArrayList<>();
        this.altVida = altVida;
        this.altEnergia = altEnergia;
        this.tela =tela;
        this.area = tela.texto;
        //this.proximos = proximos;
       
    }






    public void mudarPersonagem(){
        personagem.setEnergia(personagem.getEnergia()+ altEnergia);
        personagem.setVida(personagem.getVida()+ altVida);
    }






    public  void displayCapitulo(javax.swing.JLabel barVida, javax.swing.JLabel barEnergia)
    {
        //Mexendo no personagem do capitulo
        this.mudarPersonagem();
        personagem.displayPersonagem(personagem.getEnergia(),personagem.getVida(),barVida,barEnergia);
        

        
       
        area.append(texto+"\n");
        

        if(this.escolhas.size() > 0){
            
          cb = new Combox(tela, escolhas,this);
         
        }
        else{
            area.append(" "); 
        }
   
       
       
    }




    public int escolher( TelaPricipal tela){
       
        //tela.scam = new Scanner(tela.getTextoLido());

       
        

            int idEscolha =-1;

                if(escolhas.size()>0){

                    while(idEscolha ==-1){

                        //System.out.println(idEscolha);

                        tela.setTextoLido(Capitulo.cb.comboBox.getSelectedItem().toString());

                        
                        for(int i = 0; i<escolhas.size(); i++){
                            if(tela.textoLido.equals(escolhas.get(i).escolha))
                            idEscolha = i;
                        }
            
                    }
        
                }
                
                return idEscolha;

    
            

        }
        public  void acaoEscolher(Capitulo capitulo){
            if(capitulo.personagem.temEnergia()){

        
                int i = escolher(tela);
                System.out.println(i);
                //this.escolhas.get(i).capituloEscolhido.displayCapitulo( this.escolhas.get(i).capituloEscolhido.barVida,this.escolhas.get(i).capituloEscolhido.barEnergia);
                this.escolhas.get(i).capituloEscolhido.displayCapitulo(tela.vidaBar1,tela.energiaBar1);
        
                }

        }
       

       
                
            
           
    }