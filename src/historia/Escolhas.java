package historia;

public class Escolhas {
    String escolha;
    Capitulo capituloEscolhido;
   
    public Escolhas(String escolhas, Capitulo capituloEscolhido ){
        this.escolha = escolhas;
        this.capituloEscolhido = capituloEscolhido;

    }
    public String getEscolha() {
        return escolha;
    }
    public void setEscolha(String escolha) {
        this.escolha = escolha;
    }
    
}
