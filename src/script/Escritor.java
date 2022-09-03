package script;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import historia.Capitulo;
import historia.Personagem;

public class Escritor{
    public void escreverCapitulo(String caminhoArquivo, LinkedList<Capitulo> lis) throws IOException{
        try {
            Gson json = new GsonBuilder().setPrettyPrinting().create();
            FileWriter filewriter = new FileWriter(caminhoArquivo);
            for (Capitulo c : lis){
                String ca = json.toJson(c.getHistoria());
                filewriter.write(ca);

            }
            filewriter.flush();
            filewriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void escreverPersonagem(String caminhoArquivo, LinkedList<Personagem> lis) throws IOException{
        try {
            Gson json = new GsonBuilder().setPrettyPrinting().create();
            FileWriter filewriter = new FileWriter(caminhoArquivo);
            for (Personagem personagem : lis){
                String ca = json.toJson(personagem.p);
                filewriter.write(ca);

            }
            filewriter.flush();
            filewriter.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
