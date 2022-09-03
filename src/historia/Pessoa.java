package historia;

import java.io.Serializable;

public class Pessoa implements Serializable{

    private static final long serialVersionUID = 1L;
    private String nome;
    private int vida =3;
    private int energia =3;
    private int id;
    private boolean alive;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getVida() {
        return vida;
    }
    /**
     * @param vida
     */
    public void setVida(int vida) {
        this.vida = vida;
    }
    public int getEnergia() {
        return energia;
    }
    /**
     * @param energia
     */
    public void setEnergia(int energia) {
        this.energia = energia;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public boolean isAlive() {
        return alive;
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
    
}
