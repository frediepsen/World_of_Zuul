/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personagens;

/**
 *
 * @author USUARIO
 */
public class Status {
    private int attack;
    private int defence;
    private int agility;
    
    public Status(int attack, int defence, int agility){
        this.attack = attack;
        this.defence = defence;
        this.agility = agility;
    }

    public Status(){
    }
    
    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }
    
}
