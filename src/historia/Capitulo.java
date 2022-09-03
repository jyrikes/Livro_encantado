
package historia;

import java.io.Serializable;
import java.util.ArrayList;
//import java.util.Scanner;

import script.CarregadorDoTexto;
import telas.Combox;
import telas.TelaPricipal;

/**
 *
 * @author JYrik
 */
public class Capitulo implements Serializable {
    private static final long serialVersionUID = 1L;
    public  Historia historia = new Historia();


    private TelaPricipal tela;
    private String nome = historia.getNome();
    private Personagem personagem;
    private String texto = historia.getTexto();
    private ArrayList<Escolhas> escolhas;
    private int altVida = historia.getAltVida();
    private int altEnergia = historia.getAltEnergia();
    private int idEscolha;
    private static Combox cb;
    private javax.swing.JLabel barVida;
    private javax.swing.JLabel barEnergia;
    private javax.swing.JTextArea area;

    
    public  Historia getHistoria() {
        return historia;
    }

    public void setHistoria(Historia historia) {
        this.historia = historia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public ArrayList<Escolhas> getEscolhas() {
        return escolhas;
    }

    public void setEscolhas(ArrayList<Escolhas> escolhas) {
        this.escolhas = escolhas;
    }

    public int getAltVida() {
        return altVida;
    }

    public void setAltVida(int altVida) {
        this.altVida = altVida;
    }

    public int getAltEnergia() {
        return altEnergia;
    }

    public void setAltEnergia(int altEnergia) {
        this.altEnergia = altEnergia;
    }

    public static Combox getCb() {
        return cb;
    }

    public static void setCb(Combox cb) {
        Capitulo.cb = cb;
    }

    /// componentes swing
    

    // Capitulo[] proximos;
    public int getIdEscolha() {
        return idEscolha;
    }

    public void setIdEscolha(int idEscolha) {
        this.idEscolha = idEscolha;
    }
    public void setTela(TelaPricipal tela){
        this.tela = tela;

    }
    public TelaPricipal getTela(){

        return this.tela;
    }
    public void setArea(javax.swing.JTextArea area){
        this.area = area;

    }
    
    
    public Capitulo(String nome,
            String texto,
            Personagem personagem,
            int altVida,
            int altEnergia
            )

    {
        historia.setNome(nome);
        this.personagem = personagem;
        historia.setTexto(texto);
        this.escolhas = new ArrayList<>();
        historia.setAltVida(altVida);
        historia.setAltEnergia(altEnergia);
        historia.setNomePersonagem(personagem.getName());
       
        
        // this.proximos = proximos;

    }
    
    public Capitulo(){

    }
    public Capitulo(Historia h, Personagem personagem, TelaPricipal tela){
        historia.setNome(h.getNome());
        this.personagem = personagem;
        historia.setTexto(h.getTexto());
        this.escolhas = new ArrayList<>();
        historia.setAltVida(h.getAltVida());
        historia.setAltEnergia(h.getAltEnergia());
        this.setTela(tela);
        this.setArea(tela.getTexto());
    }

///colocar isso na clase personagem 
public void mudarPersonagem() {
    personagem.setEnergia(personagem.p.getEnergia() + this.getHistoria().getAltEnergia());
    personagem.setVida(personagem.p.getVida() + this.getHistoria().getAltVida());
}


    public void displayCapitulo(javax.swing.JLabel barVida, javax.swing.JLabel barEnergia) {
        // Mexendo no personagem do capitulo
        this.mudarPersonagem();
        personagem.displayPersonagem(personagem.p.getEnergia(), personagem.p.getVida(), barVida, barEnergia);
        System.out.println(personagem.p.getEnergia());

        area.append(historia.getTexto() + "\n");

        if (this.escolhas.size() > 0) {

            // ele ta pegando o elemento estático

            if (cb != null) {
                this.tela.getjPanel1().remove(cb.comboBox);
            }
            cb = new Combox(tela, escolhas, this);

        } else {
            area.append(" ");
        }

    }

    public int escolher(TelaPricipal tela) {

        // tela.scam = new Scanner(tela.getTextoLido());

        int idEscolha = -1;

        if (escolhas.size() > 0) {

            while (idEscolha == -1) {

                // System.out.println(idEscolha);

                tela.setTextoLido(Capitulo.cb.comboBox.getSelectedItem().toString());

                for (int i = 0; i < escolhas.size(); i++) {
                    if (tela.getTextoLido().equals(escolhas.get(i).getEscolha()))
                        idEscolha = i;
                }

            }

        }

        return idEscolha;

    }

    public void acaoEscolher(Capitulo capitulo) {
        if (capitulo.personagem.temEnergia()) {

            int i = escolher(tela);
            System.out.println(i);
            // this.escolhas.get(i).capituloEscolhido.displayCapitulo(
            // this.escolhas.get(i).capituloEscolhido.barVida,this.escolhas.get(i).capituloEscolhido.barEnergia);
            this.escolhas.get(i).getCapituloEscolhido().displayCapitulo(personagem.getBarEnergia(), personagem.getBarVida());

        }
        else{
            CarregadorDoTexto.final3.displayCapitulo(tela.getEnergiaBar1(), tela.getVidaBar1());
        }

    }

}