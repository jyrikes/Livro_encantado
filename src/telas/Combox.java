package telas;

import java.util.ArrayList;
import javax.swing.JComboBox;

import historia.Capitulo;
import historia.Escolhas;

public class Combox {

    public JComboBox<String> comboBox;
    public Capitulo capitulo;
    public Combox(TelaPricipal tela,ArrayList<Escolhas> escolhas , Capitulo capitulo){
        this.capitulo = capitulo;
        
        this.comboBox = new javax.swing.JComboBox<String>();
        for (Escolhas escolha : escolhas) {              
            this.comboBox.addItem(escolha.getEscolha());
        }

        this.comboBox.setBounds(30, 660,500, 100);
        this.comboBox.setFont(new java.awt.Font("SansSerif", 0, 24));
        System.out.println(comboBox);
        
        tela.getjPanel1().add(comboBox);
    }
    public Capitulo getCapitulo() {
        return capitulo;
    }
}
