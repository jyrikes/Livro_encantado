package script;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import historia.Capitulo;
import historia.Escolhas;
import historia.Historia;
import historia.Personagem;

public class Escritor{
    public void escreverCapitulo(String caminhoArquivo, Capitulo atual) throws IOException{
        Historia[] historias = {atual.historia};
        try {
            Gson json = new GsonBuilder().setPrettyPrinting().create();
            FileWriter filewriter = new FileWriter(caminhoArquivo);
        
            String ca = json.toJson(historias);
            filewriter.write(ca);
            filewriter.flush();
            filewriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void escreverCapitulos(String caminhoArquivo, ArrayList<Capitulo> lis) throws IOException{
        ArrayList<Historia> his = new ArrayList<>();
        for (Capitulo cap : lis) {
            his.add(cap.historia);
        }
        try {
            Gson json = new GsonBuilder().setPrettyPrinting().create();
            FileWriter filewriter = new FileWriter(caminhoArquivo);
        
            String ca = json.toJson(his);
            filewriter.write(ca);
            filewriter.flush();
            filewriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void escreverPersonagem(String caminhoArquivo, Personagem personagem) throws IOException{
        try {
            Gson json = new GsonBuilder().setPrettyPrinting().create();
            FileWriter filewriter = new FileWriter(caminhoArquivo);
            String ca = json.toJson(personagem.p);
            filewriter.write(ca);
            filewriter.flush();
            filewriter.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void escreverPersonagens(String caminhoArquivo, ArrayList<Personagem> lis) throws IOException{
        try {
            Gson json = new GsonBuilder().setPrettyPrinting().create();
            FileWriter filewriter = new FileWriter(caminhoArquivo);
            String ca = json.toJson(lis);
            filewriter.write(ca);
            filewriter.flush();
            filewriter.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void escreverEscolha(String caminhoArquivo, ArrayList<Escolhas> escolhas){
        try {


            Gson json = new GsonBuilder().setPrettyPrinting().create();
            FileWriter file = new FileWriter(caminhoArquivo);
          for (Escolhas escolha : escolhas) {
            String ca = json.toJson(escolha.getConteudo());
            file.append(ca);
          }
          file.flush();
          file.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
