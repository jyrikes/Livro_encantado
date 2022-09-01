package historia;

import java.io.Serializable;

public class Historia implements Serializable {

    private static final long serialVersionUID = 1L;
    public String nome;
    public String texto;
    public int altVida;
    public int altEnergia;

    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
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

}
