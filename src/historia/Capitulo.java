
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
    public Historia h = new Historia();

    private TelaPricipal tela;
    public String nome = h.nome;
    public Personagem personagem;
    public String texto = h.texto;
    public ArrayList<Escolhas> escolhas;
    public int altVida = h.altVida;
    public int altEnergia = h.altEnergia;
    public int idEscolha;
    public static Combox cb;

    /// componentes swing
    javax.swing.JLabel barVida;
    javax.swing.JLabel barEnergia;
    public javax.swing.JTextArea area;

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
        h.nome = nome;
        this.personagem = personagem;
        h.texto = texto;
        this.escolhas = new ArrayList<>();
        h.altVida = altVida;
        h.altEnergia = altEnergia;
       
        
        // this.proximos = proximos;

    }
    
    public Capitulo(){

    }
///colocar isso na clase personagem 
    public void mudarPersonagem() {
        personagem.setEnergia(personagem.p.getEnergia() + h.altEnergia);
        personagem.setVida(personagem.p.getVida() + h.altVida);
    }

    public void displayCapitulo(javax.swing.JLabel barVida, javax.swing.JLabel barEnergia) {
        // Mexendo no personagem do capitulo
        this.mudarPersonagem();
        personagem.displayPersonagem(personagem.p.getEnergia(), personagem.p.getVida(), barVida, barEnergia);
        System.out.println(personagem.p.getEnergia());

        area.append(h.texto + "\n");

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
                    if (tela.textoLido.equals(escolhas.get(i).escolha))
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
            this.escolhas.get(i).capituloEscolhido.displayCapitulo(personagem.getBarEnergia(), personagem.getBarVida());

        }
        else{
            CarregadorDoTexto.final3.displayCapitulo(tela.getEnergiaBar1(), tela.vidaBar1);
        }

    }

}