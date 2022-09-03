
package script;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
//import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.transform.Source;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

//import javax.swing.JButton;
//import javax.xml.transform.Source;
import historia.Capitulo;
import historia.Escolhas;
import historia.Historia;
import historia.Personagem;
import historia.Pessoa;
import telas.TelaPricipal;

/**
 *
 * @author JYrik
 */
public class CarregadorDoTexto {
    TelaPricipal tela;
     Scanner scam;
     public static Capitulo final3;
     public static Capitulo raiz;
    
   

    
    public CarregadorDoTexto(TelaPricipal tela) throws IOException {
        

    //tela.scam = new Scanner(tela.ler.getText());

        System.out.println("tela iniciou");
       // System.out.println(tela.btscam.nextLine());
        this.tela = tela;
        
        carregar();

    }

    /**
     * @throws IOException
     * 
     */
    public void carregar() throws IOException{
       
        //String a = scam.nextLine();

    ///Personagens

    LeitorObjetos ler = new LeitorObjetos();
    HashMap<String,Personagem> personagens = ler.lerPersonagensMap("rsc\\JsonFiles\\JsonPersonagens.json");
    HashMap<String, Capitulo> capitulos = ler.lerCapitulosMap("rsc\\JsonFiles\\JsonCapitulos.json", personagens,tela);

  

       Personagem protagnista = personagens.get("Protagonista");
       protagnista.setComponentesVisuais(tela.getVidaBar1(), tela.getEnergiaBar1(),tela.getNome3());
       Personagem antagonista = new Personagem("Antagonista", 2);
       antagonista.setComponentesVisuais(tela.getVidaBar3(), tela.getEnergiaBar3(), tela.getNome4());
       System.out.println(capitulos.get("Capitulo 1").getTexto());
       tela.getTexto().append(capitulos.get("Capitulo 1").getTexto());







        
        ///HISTÓRIA
        ///CAPITULO 1

    
        //String[] escolha1 = {"-SIM","-NÃO"};
        Capitulo capitulo1  = capitulos.get("Capitulo 1");

      ///CAPITULO 2 

       //String[] escolha2 = {"-SIM","-NÃO"};
       Capitulo primeiroSim = new Capitulo("Primeiro Sim",
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
                
                protagnista, 
                0, 
                0);


    ///CAPITULO 3
   // String[] escolhas3 = {"-itália","-Brasil","-Alemanha"};
    Capitulo segundoSim = new Capitulo("Capitulo 3",
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
               
               protagnista,
                0, 
                -1);

////CAPITULO 4
  
        Capitulo primeiroNao = new Capitulo("PrimeiroNao", """
                         
            .............................................
            Você escuta barulhos muito altos dentro da sua própria 
            mente , você começa a ver algumas imagens em delírio!!
            Por isso você sente que está perdendo vida !
            
            César algusto o imperador precisa de UMA casa ,
            você ficou preso num sono profundo , 
            
            decifre a senha pra despertar !
            
            DICA: Tó tfj rvf obeb tfj ! Tpv p bvups !
            """, protagnista, -1, 0);

    //CAPITULO 5


   
    
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
                         """, protagnista, +3, +3);
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
                         """, protagnista, 3, 3);
    final3 = new Capitulo("Terceiro final", 
    
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
                        + "VOCÊ FICOU SEM ENERGIA POR ISSO PERDEU TODA A VIDA !!", protagnista, -3, 0);


     Capitulo final4 = new Capitulo("4º Final", 
     "\n▒▒▒▒▒▒▒▒▒▒▒▄▄▄▄░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
    "▒▒▒▒▒▒▒▒▒▄██████▒▒▒▒▒▄▄▄█▄▒▒▒▒▒▒▒▒▒▒\n" +
    "▒▒▒▒▒▒▒▄██▀░░▀██▄▒▒▒▒████████▄▒▒▒▒▒▒\n" +
    "▒▒▒▒▒▒███░░░░░░██▒▒▒▒▒▒█▀▀▀▀▀██▄▄▒▒▒\n" +
    "▒▒▒▒▒▄██▌░░░░░░░██▒▒▒▒▐▌▒▒▒▒▒▒▒▒▀█▄▒\n" +
    "▒▒▒▒▒███░░▐█░█▌░██▒▒▒▒█▌▒▒▒▒▒▒▒▒▒▒▀▌\n" +
    "▒▒▒▒████░▐█▌░▐█▌██▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
    "▒▒▒▐████░▐░░░░░▌██▒▒▒█▌▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
    "▒▒▒▒████░░░▄█░░░██▒▒▐█▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
    "▒▒▒▒████░░░██░░██▌▒▒█▌▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
    "▒▒▒▒████▌░▐█░░███▒▒▒█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
    "▒▒▒▒▐████░░▌░███▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
    "▒▒▒▒▒████░░░███▒▒▒▒█▌▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
    "▒▒▒██████▌░████▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
    "▒▐████████████▒▒███▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
    "▒█████████████▄████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
    "██████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
    "██████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
    "█████████████████▀▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
    "█████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
    "████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
    "████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n"+
               
               "VOCÊ PERDEU UMA VIDA CONGELADO !!", protagnista, -1, 0);
    Capitulo final5 = new Capitulo("Final 5", "\n─────▄██▀▀▀▀▀▀▀▀▀▀▀▀▀██▄─────\n" +
    "────███───────────────███────\n" +
    "───███─────────────────███───\n" +
    "──███───▄▀▀▄─────▄▀▀▄───███──\n" +
    "─████─▄▀────▀▄─▄▀────▀▄─████─\n" +
    "─████──▄████─────████▄──█████\n" +
    "█████─██▓▓▓██───██▓▓▓██─█████\n" +
    "█████─██▓█▓██───██▓█▓██─█████\n" +
    "█████─██▓▓▓█▀─▄─▀█▓▓▓██─█████\n" +
    "████▀──▀▀▀▀▀─▄█▄─▀▀▀▀▀──▀████\n" +
    "███─▄▀▀▀▄────███────▄▀▀▀▄─███\n" +
    "███──▄▀▄─█──█████──█─▄▀▄──███\n" +
    "███─█──█─█──█████──█─█──█─███\n" +
    "███─█─▀──█─▄█████▄─█──▀─█─███\n" +
    "███▄─▀▀▀▀──█─▀█▀─█──▀▀▀▀─▄███\n" +
    "████─────────────────────████\n" +
    "─███───▀█████████████▀───████\n" +
    "─███───────█─────█───────████\n" +
    "─████─────█───────█─────█████\n" +
    "───███▄──█────█────█──▄█████─\n" +
    "─────▀█████▄▄███▄▄█████▀─────\n" +
    "──────────█▄─────▄█──────────\n" +
    "──────────▄█─────█▄──────────\n" +
    "───────▄████─────████▄───────\n" +
    "─────▄███████───███████▄─────\n" +
    "───▄█████████████████████▄───\n" +
    "─▄███▀───███████████───▀███▄─\n" +
    "███▀─────███████████─────▀███\n" +
    "▌▌▌▌▒▒───███████████───▒▒▐▐▐▐\n" +
    "─────▒▒──███████████──▒▒─────\n" +
    "──────▒▒─███████████─▒▒──────\n" +
    "───────▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒───────\n" +
    "─────────████░░█████─────────\n" +
    "────────█████░░██████────────\n" +
    "──────███████░░███████───────\n" +
    "─────█████──█░░█──█████──────\n" +
    "─────█████──████──█████──────\n" +
    "──────████──████──████───────\n" +
    "──────████──████──████───────\n" +
    "──────████───██───████───────\n" +
    "──────████───██───████───────\n" +
    "──────████──████──████───────\n" +
    "─██────██───████───██─────██─\n" +
    "─██───████──████──████────██─\n" +
    "─███████████████████████████─\n" +
    "─██─────────████──────────██─\n" +
    "─██─────────████──────────██─\n" +
    "────────────████─────────────\n" +
    "─────────────██──────────────\n"+
                        """
                             VOCÊ FOI CAPTURADO PELOS PALHAÇÕS DE VEMPTA 
                             E ACABOU EM UM PESADELO ETERNO !!
                             """, protagnista, 0, -1);
    

    String[]  escolhas6 ={"idade", "ideia","alfabeto"};
    Capitulo charada1 = new Capitulo("Charada 1",
    """
                     
        O rei tirano te encontrou e começa o duelo 
        
        Responda as charadas para vencer !!
        
        Eu sou algo que as pessoas amam ou odeiam.
        Eu mudo tanto a aparência das pessoas quanto seus pensamentos.
        Se uma pessoa cuida de si mesma, eu subo ainda mais. 
        Eu engano algumas pessoas. 
        E para outras, sou um verdadeiro mistério. 
        Algumas pessoas bem que tentam me esconder,
        mas uma hora, inevitavelmente, eu apareço. 
        Não importa o que as pessoas tentem, eu jamais cairei.
        Quem sou eu?
        
        """, antagonista, 0, 0);

    Capitulo charada2 = new Capitulo("Segunda charada ", """
        \nEu posso guardar tudo dentro de mim. 
        Tudo o que você pode imaginar:
         o vento, as florestas, o mundo, o universo e até Deus.
        Tudo o que vier à sua cabeça você pode encontrar dentro de mim.
           Quem sou eu?
            
            """, protagnista, 0, 0);


    String[] escolhas7 ={"Sim","Não"};
    Capitulo chamado = new Capitulo("Chamado","""
        \nO home se aproxima sem dizer o nome misteriosamente 
        ele desaparece e aparece na sua frente e fala:
        
        --- Eu preciso de você 
        
        Nesse momento você sente seu corpo viajando e do nada 
        aparece em um lago congelado , em frente a esse lago 
        você via uma lamparina a gás e o homem fala:
        
        --- Não se mova ..
        
        Você o obedece ?
        
        """, protagnista, 0, 0);


     Capitulo respErrado = new Capitulo("Resposta errada", """
        A sua resposta está errada por isso você perdeu 1 vida e 1 energia !
     """, protagnista, -1, -1);










   




     
    
//ESCOLHAS
          
          capitulo1.getEscolhas().add(new Escolhas("SIM", primeiroSim));
          capitulo1.getEscolhas().add(new Escolhas("NÃO", primeiroNao));
          primeiroSim.getEscolhas().add(new Escolhas("SIM",segundoSim));
          primeiroSim.getEscolhas().add(new Escolhas("Não", final5));
          segundoSim.getEscolhas().add(new Escolhas("Alemanha", chamado));
          segundoSim.getEscolhas().add(new Escolhas("itália", final1));
          segundoSim.getEscolhas().add(new Escolhas("Brasil", chamado));
          chamado.getEscolhas().add(new Escolhas("SIM", charada1));
          chamado.getEscolhas().add(new Escolhas("NÃO", final4));
          
          primeiroNao.getEscolhas().add(new Escolhas("sócrates",final1));
          primeiroNao.getEscolhas().add(new Escolhas("aristoteles",final3 ));
          raiz = capitulo1;
          
          
      
      



    
          System.out.println("Criando Json");

          LinkedList<Capitulo> lis = new LinkedList<Capitulo>();
          //ArrayList<Capitulo> lis = new ArrayList<>();
          lis.add(capitulo1);
          lis.add(primeiroSim);
          lis.add(primeiroNao);
          lis.add(segundoSim);
          lis.add(chamado);
          lis.add(charada1);
          lis.add(charada2);
          lis.add(final1);
          lis.add(final2);
          lis.add(final3);
          lis.add(final4);
          lis.add(final5);
          lis.add(respErrado);
          System.out.println("tentando gson");
          System.out.println(lis);
     
         
          ArrayList<Personagem> personagensList = new ArrayList<Personagem>();
          personagensList.add(protagnista);
          personagensList.add(antagonista);
          
         
      Escritor escritor = new Escritor();
      escritor.escreverCapitulo("rsc\\JsonFiles\\JsonCapitulos.json", lis);
      
          
      
      
      
     
    
    raiz.displayCapitulo(raiz.getPersonagem().getBarEnergia(),raiz.getPersonagem().getBarVida());


         
          System.out.println("continuo");
          
    
    }

}
