
package script;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.xml.transform.Source;

import historia.Capitulo;
import historia.Personagem;
import telas.TelaPricipal;

/**
 *
 * @author JYrik
 */
public class ScriptPrincipal {
    TelaPricipal tela;
    Scanner scam;
    
   

    
    public ScriptPrincipal(TelaPricipal tela) {
        
     







    //tela.scam = new Scanner(tela.ler.getText());

        System.out.println("tela iniciou");
       // System.out.println(tela.btscam.nextLine());
        this.tela = tela;
        logica();

    }

    public void logica(){
        
    
        Personagem personagem = new Personagem("Protagonista", 1, tela.vidaBar1, tela.energiaBar1,tela.nome3);
        
        ///HISTÓRIA
        ///CAPITULO 1
    
        String[] escolha1 = {"-SIM","-NÃO"};
        Capitulo capitulo1 = new Capitulo("Capitulo 1",
                                          
        """ 
                                            █▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█ 
                                            █---╦─╦╔╗╦─╔╗╔╗╔╦╗╔╗--█ 
                                            █---║║║╠─║─║─║║║║║╠─--█ 
                                            █---╚╩╝╚╝╚╝╚╝╚╝╩─╩╚╝--█
                                            █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█
                                            .........
                                                                 ............
                                                      .............
                                            Terra de Nor 2000 anos depois da Era de Vemptor ......
                                              
                                                                   O livro do tempo repousava sobre 
                                                                     a proteção da árvore sagrada ,
                                                                        quando suas páginas correram em direção
                                                                 as planícies do sul .....
                                                    2020 do tempo comum .... 
                                                                        O despertador toca 
                             
                                                                      Acordar?
                                                  """,
                                          escolha1, 
                                          personagem,
                                          0,
                                        0,
                                          tela.texto);

      ///CAPITULO 2 

       String[] escolha2 = {"-SIM","-NÃO"};
       Capitulo capitulo2 = new Capitulo("Capitulo2",
       """                     
        ╔══╗ 
         ║██║ \
         ║(O)║♫ ♪ ♫ ♪\
          ╚══╝\n" +
         ▄ █ ▄ █ ▄ ▄ █ ▄ █ ▄ █
         "Min- - - - - - - - - - - -●Max\\

---------------------------------------------
Você acabou de acordar um pouco sonolento vai 
para o banheiro escovar os dentes , você repara em algo
esquisito na mesa de jantar .

Você olha para fora do quarto e vê um livro estranho 
você vai pegar o livro ? )
                """, 
                escolha2,
                personagem, 
                0, 
                0, 
                tela.texto);


    ///CAPITULO 3
    String[] escolhas3 = {"-itália","-Brasil","-Alemanha"};
    Capitulo capitulo3 = new Capitulo("Capitulo 3",
    """
                         
        Você ainda está sonolento por isso perdeu 1 ponto de energia 
        para pegar o livro !!
        
        ..............................................
    https://i.ytimg.com/vi/xB_O0Adpm80/maxresdefault.jpg
        ...............................................
        Você toca no livro e no mesmo instante 
        
    o livro se abre no país em que as pessoas viraram pedras
              por causa de um vulcão.
        -Qual o país ? 
        Pergunta um homem em pé de frente a janela .
        
        Qual sua resposta ?
        .....
        
              """,
               escolhas3, 
               personagem,
                0, 
                -1, 
                tela.texto);

////CAPITULO 4
        String[] escolhas4 ={"sócrates","platão","aristóteles"};
        Capitulo capitulo4 = new Capitulo("Capitulo4", """
                         
            .............................................
            Você escuta barulhos muito altos dentro da sua própria 
            mente , você começa a ver algumas imagens em delírio!!
            Por isso você sente que está perdendo vida !
            
            César algusto o imperador precisa de UMA casa ,
            você ficou preso num sono profundo , 
            
            decifre a senha pra despertar !
            
            DICA: Tó tfj rvf obeb tfj ! Tpv p bvups !
            """, escolhas4, personagem, -1, 0, tela.texto);

    String[] escolha5 = null;
    Capitulo final1 = new Capitulo("PrimeiroFinal", 
    "\n_¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶\n" +
"_¶¶___________________________________¶¶\n" +
"_¶¶___________________________________¶¶\n" +
"__¶¶_________________________________¶¶_\n" +
"__¶¶_________________________________¶¶_\n" +
"___¶¶_______________________________¶¶__\n" +
"___¶¶______________________________¶¶___\n" +
"____¶¶¶__________________________¶¶¶____\n" +
"_____¶¶¶¶_¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶_¶¶¶¶_____\n" +
"_______¶¶¶¶_¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶_¶¶¶¶_______\n" +
"_________¶¶¶¶_¶¶¶¶¶¶¶¶¶¶¶¶_¶¶¶¶_________\n" +
"___________¶¶¶¶¶_¶¶¶¶¶¶¶_¶¶¶¶___________\n" +
"______________¶¶¶¶_¶¶¶_¶¶¶______________\n" +
"________________¶¶¶_¶_¶¶________________\n" +
"_________________¶¶¶_¶¶_________________\n" +
"__________________¶¶_¶¶_________________\n" +
"__________________¶¶_¶__________________\n" +
"__________________¶¶_¶¶_________________\n" +
"________________¶¶¶_¶_¶¶¶_______________\n" +
"_____________¶¶¶¶¶__¶__¶¶¶¶¶____________\n" +
"__________¶¶¶¶¶_____¶_____¶¶¶¶__________\n" +
"________¶¶¶¶________¶_______¶¶¶¶¶_______\n" +
"_______¶¶¶__________¶__________¶¶¶¶_____\n" +
"_____¶¶¶____________¶____________¶¶¶____\n" +
"____¶¶¶_____________¶______________¶¶___\n" +
"___¶¶¶______________¶_______________¶¶__\n" +
"___¶¶_______________¶________________¶¶_\n" +
"__¶¶________________¶________________¶¶_\n" +
"__¶¶_______________¶¶¶________________¶_\n" +
"__¶¶_¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶_¶¶\n" +
"__¶¶_¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶_¶¶\n" +
"__¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶\n"
   +"""
                         VOCÊ GANHOU O PODER DE VIAJAR NO TEMPO E ENTRE REINOS
                         AGORA VOCÊ É UM VIAJANTE DO TEMPO !!
                         """, escolha5 , personagem, +3, +3, tela.texto);
    Capitulo final2 = new Capitulo("Segundo final", 
    "\n_________________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶__________________\n" +
"_____________¶¶¶________________¶¶¶_______________\n" +
"___________¶¶______________________¶¶¶¶___________\n" +
"_________¶¶¶__________________________¶¶¶_________\n" +
"_______¶¶¶___________________¶¶¶¶_______¶¶________\n" +
"_¶¶¶¶¶¶__¶¶¶¶¶¶¶¶¶¶¶¶¶_____¶¶¶__¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶__\n" +
"__¶¶¶¶____¶¶¶¶¶¶¶¶¶_¶¶¶¶¶¶¶¶¶____¶¶¶¶¶¶¶¶¶¶¶¶¶¶___\n" +
"___¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶___¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶____¶¶¶____\n" +
"__¶___¶¶¶¶¶¶¶¶______¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶______¶¶__¶__\n" +
"_¶¶___¶¶¶¶¶¶¶¶¶______¶¶¶¶¶¶¶¶¶¶¶¶¶¶_______¶¶__¶¶__\n" +
"¶______¶¶¶¶¶¶¶¶_____¶¶¶___¶¶¶¶¶¶¶¶¶___¶¶¶¶¶____¶__\n" +
"¶__________¶¶¶¶¶¶¶¶¶¶¶______¶¶¶¶¶¶¶¶¶¶¶__¶______¶¶\n" +
"¶_______________________________________________¶¶\n" +
"¶________¶¶_____________________________________¶¶\n" +
"¶______¶¶¶¶_________________________¶¶¶¶________¶¶\n" +
"¶_____¶__¶¶_________________________¶¶¶¶________¶¶\n" +
"¶_________¶¶¶______________________¶¶___________¶¶\n" +
"¶___________¶¶¶__________________¶¶¶____________¶¶\n" +
"¶¶____________¶¶¶¶____________¶¶¶¶_____________¶__\n" +
"_¶¶______________¶¶¶¶¶¶¶¶¶¶¶¶¶¶________________¶__\n" +
"__¶___________________________________________¶¶__\n" +
"___¶¶________________________________________¶¶___\n" +
"____¶¶______________________________________¶¶____\n" +
"_____¶¶___________________________________¶¶______\n" +
"_______¶¶_______________________________¶¶¶_______\n" +
"_________¶¶___________________________¶¶¶_________\n" +
"__________¶¶¶¶_____________________¶¶_____________\n" +
"______________¶¶¶¶_____________¶¶¶¶¶______________\n" +
"___________________¶¶¶¶¶¶¶¶¶¶¶¶___________________\n"+
                    """
                         VOCÊ FOI PARA A TERRA DE NOR 
                           SE ALIANDO AS TROPAS DE RESISTÊNCIA 
                           CONTRA A TIRANIA DO REI VEMPTOR ...
                              A ALIANÇA VENCEU E VC FOI COROADO REI DE NOR !!!
                         """, null, personagem, 3, 0,tela.texto);
    Capitulo final3 = new Capitulo("Terceiro final", 
    
    "\n───────▄█──────────█─────────█▄───────\n" +
    "─────▐██──────▄█──███──█▄─────██▌─────\n" +
    "────▐██▀─────█████████████────▀██▌────\n" +
    "───▐██▌─────██████████████─────▐██▌───\n" +
    "───████────████████████████────████───\n" +
    "──▐█████──██████████████████──█████▌──\n" +
    "───████████████████████████████████───\n" +
    "────███████▀▀████████████▀▀███████────\n" +
    "─────█████▌──▄▄─▀████▀─▄▄──▐█████─────\n" +
    "───▄▄██████▄─▀▀──████──▀▀─▄██████▄▄───\n" +
    "──██████████████████████████████████──\n" +
    "─████████████████████████████████████─\n" +
    "▐██████──███████▀▄██▄▀███████──██████▌\n" +
    "▐█████────██████████████████────█████▌\n" +
    "▐█████─────██████▀──▀██████─────█████▌\n" +
    "─█████▄─────███────────███─────▄█████─\n" +
    "──██████─────█──────────█─────██████──\n" +
    "────█████────────────────────█████────\n" +
    "─────█████──────────────────█████─────\n" +
    "──────█████────────────────█████──────\n" +
    "───────████───▄────────▄───████───────\n" +
    "────────████─██────────██─████────────\n" +
    "────────████████─▄██▄─████████────────\n" +
    "───────████████████████████████───────\n" +
    "───────████████████████████████───────\n" +
    "────────▀█████████▀▀█████████▀────────\n" +
    "──────────▀███▀────────▀███▀──────────\n"+
    ""
                        + "VOCÊ FICOU SEM ENERGIA POR ISSO PERDEU TODA A VIDA !!", null, personagem, 0, 0, tela.texto);



       capitulo1.displayCapitulo(tela.energiaBar1, tela.vidaBar1);
       
       int idEscolha = capitulo1.getIdEscolha();
        idEscolha = 0;

       if(idEscolha == 0 && capitulo1.personagem.temEnergia() && capitulo1.personagem.temVida() ){
        
            
            capitulo1.personagem.setPontos( capitulo1.personagem.getPontos()+1);
            capitulo2.displayCapitulo(tela.energiaBar1, tela.vidaBar1);

            idEscolha = capitulo2.getIdEscolha();

            idEscolha =0;

              if(idEscolha == 0 && capitulo2.personagem.temEnergia() && capitulo2.personagem.temVida() ){
                
                capitulo2.personagem.setPontos( capitulo2.personagem.getPontos()+1);
                capitulo3.displayCapitulo(tela.energiaBar1, tela.vidaBar1);
                idEscolha = capitulo2.getIdEscolha();

                if(idEscolha ==0 && capitulo3.personagem.temEnergia()&& capitulo3.personagem.temVida() ){
                   
                    capitulo3.personagem.setPontos( capitulo3.personagem.getPontos()+1);
                    finais(final2);

                }
                
    
              }

       }
       else if(idEscolha == 1 && capitulo1.personagem.temEnergia() && capitulo1.personagem.temVida() ) {
        capitulo1.personagem.setPontos( capitulo1.personagem.getPontos()-1);
        capitulo4.displayCapitulo(tela.energiaBar1, tela.vidaBar1);
        idEscolha =0;
        if(idEscolha == 0 && capitulo1.personagem.temEnergia() && capitulo1.personagem.temVida()){
            capitulo4.personagem.setPontos( capitulo1.personagem.getPontos()-1);
            System.out.println(capitulo4.personagem.getPontos());
            finais( final1);
        }

       }


        
       
    
    
      }
      public void finais( Capitulo capitulo){
        
            capitulo.displayCapitulo(tela.energiaBar1, tela.vidaBar1);
            
        }

      
      public void action(){
        
        tela.enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });
      }
     
   
     

    
    
    public void enviarActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Botão apertado");

            tela.controle.alterarSelecao((JButton)evt.getSource(),true);
            System.out.println(tela.controle.b);
            tela.textoLido = scam.nextLine();



            //((JButton) evt.getSource()).setName("Apertado");       
     }

     public void test(){
       
            action();
            tela.controle.b = false;
            System.out.println(tela.controle.b);

            

        
        //System.out.println("Apertado");
     }
  
     public String l(){
        System.out.println("Ligar scanner");
        String nome = scam.nextLine();
        System.out.println("passpi");
        System.out.println(nome);
        
        while(nome.equals(null) || nome.equals(" ")){
            System.out.println("procurando");
            if(tela.controle.b == true){
                nome = scam.nextLine();
               System.out.println(nome);

            }
             

        }
        return nome;
     }
   
    
    }

