/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personagens;

import java.util.Random;

/**
 * @author Frederico Iepsen
 */
public abstract class Personagem {
    private String nome;
    private int vida;
    private boolean vivo = true;
    Random r = new Random();

    public Personagem(String nome, int vidaMax){
        this.nome = nome;
        this.vida = vidaMax;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    public int sorte(){
        return r.nextInt(10);
    }
    
    public boolean mortoOuVivo(){
        return this.vivo;
    }
}
