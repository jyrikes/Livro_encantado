package script;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect.Type;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import historia.Capitulo;
import historia.ConteudoEscolhas;
import historia.Escolhas;
import historia.Historia;
import historia.Personagem;
import historia.Pessoa;
import telas.TelaPricipal;

public class LeitorObjetos {

    HashMap<String, Personagem> lerPersonagensMap(String caminhoArquivo) throws IOException {
        HashMap<String, Personagem> persongens = new HashMap<>();

        try {

            Gson json = new GsonBuilder().setPrettyPrinting().create();
            FileReader filereader = new FileReader(caminhoArquivo);

            java.lang.reflect.Type tipoLista = new TypeToken<LinkedList<Pessoa>>() {
            }.getType();
            LinkedList<Pessoa> pesoas = json.fromJson(filereader, tipoLista);
            for (Pessoa p : pesoas) {
                Personagem pesor = new Personagem(p);
                persongens.put(p.getNome(),pesor);
            
            }

            filereader.close();

        } catch (FileNotFoundException e) {
        
            e.printStackTrace();
        }
        return persongens;

    }
    HashMap<String,Capitulo> lerCapitulosMap(String caminhoArquivo,String caminhoEscolhas ,HashMap<String, Personagem> persongens, TelaPricipal tela) throws IOException{

        HashMap<String, Capitulo> capitulos = new HashMap<>();
        ArrayList<Capitulo> caps = new ArrayList<>();
        try {
            Gson json = new GsonBuilder().setPrettyPrinting().create();
            FileReader filereader = new FileReader(caminhoArquivo);
            
            java.lang.reflect.Type tipoLista = new TypeToken<LinkedList<Historia>>() {
            }.getType();
            LinkedList<Historia> historia = json.fromJson(filereader, tipoLista);
            HashMap<String,ConteudoEscolhas> conteudos =lerConteudoEscolhasMap(caminhoEscolhas);
            for (Historia h : historia) {
                
                Capitulo cap = new Capitulo(h,persongens.get(h.getNomePersonagem()),tela);
                capitulos.put(h.getNome(),cap);
                caps.add(cap);
               
            }
            ArrayList<String> chaves = new ArrayList<>();
            for (String key : conteudos.keySet()) {
                ConteudoEscolhas c = conteudos.get(key);
                String escolhas = c.getEscolha();
                Capitulo capituloAtual = capitulos.get(c.getNomeCapituloAtual());
                Capitulo capituloEscolhido = capitulos.get(c.getNomeCapituloEscolhido());
                 String idEscolhas = c.getIdEcolha();
               Escolhas e = new Escolhas(escolhas, capituloAtual, capituloEscolhido, idEscolhas);
               capituloAtual.getEscolhas().add(e);
            }
            
          
            filereader.close();
           
           

        } catch (FileNotFoundException e) {

            e.printStackTrace();    
        }


        return capitulos;

    }
   private HashMap<String,ConteudoEscolhas> lerConteudoEscolhasMap(String caminhoArquivo) throws IOException{
        HashMap<String,ConteudoEscolhas> conteudos = new HashMap<>();

        try {

            Gson json = new GsonBuilder().setPrettyPrinting().create();
            FileReader filereader = new FileReader(caminhoArquivo);

            java.lang.reflect.Type tipoLista = new TypeToken<LinkedList<ConteudoEscolhas>>() {
            }.getType();
            LinkedList<ConteudoEscolhas> conteudo = json.fromJson(filereader, tipoLista);
            for (ConteudoEscolhas cont : conteudo) {

                ConteudoEscolhas c = cont;
                conteudos.put(cont.getIdEcolha(),c);

            
            }

            filereader.close();

        } catch (FileNotFoundException e) {
        
            e.printStackTrace();
        }
        



        return conteudos;

    }

    String  lerNomeCapitulo(String caminhoArquivo) throws IOException {
        
        String nomeCapitulo;
      

        try {

            Gson json = new GsonBuilder().setPrettyPrinting().create();
            FileReader filereader = new FileReader(caminhoArquivo);

            java.lang.reflect.Type tipoLista = new TypeToken<LinkedList<Historia>>() {
            }.getType();
            LinkedList<Historia> historia = json.fromJson(filereader, tipoLista);
            
           
               nomeCapitulo = historia.get(0).getNome();
               filereader.close();
               return nomeCapitulo;
            

        } catch (FileNotFoundException e) {
        
            e.printStackTrace();
        }
        return null;

       

    }

}
