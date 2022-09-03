package script;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.HashMap;
import java.util.LinkedList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import historia.Capitulo;
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
    HashMap<String,Capitulo> lerCapitulosMap(String caminhoArquivo, HashMap<String, Personagem> persongens, TelaPricipal tela) throws IOException{

        HashMap<String, Capitulo> capitulos = new HashMap<>();
        try {
            Gson json = new GsonBuilder().setPrettyPrinting().create();
            FileReader filereader = new FileReader(caminhoArquivo);
            java.lang.reflect.Type tipoLista = new TypeToken<LinkedList<Historia>>() {
            }.getType();
            LinkedList<Historia> historia = json.fromJson(filereader, tipoLista);
            for (Historia h : historia) {
                
                Capitulo cap = new Capitulo(h,persongens.get(h.getNomePersonagem()),tela);
                capitulos.put(h.getNome(),cap);
            
            }

            filereader.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();    
        }


        return capitulos;

    }

}
