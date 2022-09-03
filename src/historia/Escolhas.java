package historia;

public class Escolhas {
    private String escolha;
    private Capitulo capituloEscolhido;
   
  
    public Escolhas(String escolhas, Capitulo capituloEscolhido ){
        this.escolha = escolhas;
        this.capituloEscolhido = capituloEscolhido;

    }
    public String getEscolha() {
        return escolha;
    }
  
    public Capitulo getCapituloEscolhido() {
        return capituloEscolhido;
    }
    
}
