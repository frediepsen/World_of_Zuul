/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personagens;

/**
 * @author USUARIO
 */
public abstract class Status {
    private int attack;
    private int defense;
    private int life;
    
    public Status(int attack, int defense){
        this.attack = attack;
        this.defense = defense;
    }
    
    public Status(int attack, int defense, int life){
        this.attack = attack;
        this.defense = defense;
        this.life = life;
    }

    public Status(){
    }
    
    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
    
    
}
