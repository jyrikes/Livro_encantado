package script;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;


public class ControleBotoeSelecionados {
    private String nmBotao;
    public Boolean b;
    
    // Tinha criado antes um arquivo referenciasBoto~es classe que 
    //tinha attibutos um JButton e um boolena selecionado.
    
    
    private Map<JButton,Boolean>ReferenciasBotoes;

    public ControleBotoeSelecionados() {
        this.ReferenciasBotoes = new HashMap<>();
    }
    

    public String getNmBotao() {
        return nmBotao;
    }

    public void setNmBotao(String nmBotao) {
        this.nmBotao = nmBotao;
    }

    public Map<JButton, Boolean> getReferenciasBotoes() {
        return ReferenciasBotoes;
    }

    public void setReferenciasBotoes(Map<JButton, Boolean> ReferenciasBotoes) {
        this.ReferenciasBotoes = ReferenciasBotoes;
    }
    
    public void adicionarBotoes(JButton botao){
        this.ReferenciasBotoes.put(botao, Boolean.FALSE);
        
    }
    public void alterarSelecao(JButton botao, boolean selecionado){
        b =this.ReferenciasBotoes.get(botao);
        b = selecionado;
    }
     public void botaoLiberado(JButton botao){
        b =this.ReferenciasBotoes.get(botao);
        b = false;
    }
    public void zerarSelecoes(){
        for(boolean b :this.ReferenciasBotoes.values()) {
            b = false;
        }
        
    }
}
