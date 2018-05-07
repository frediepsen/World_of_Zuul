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
    private int defense;
    //private int agility;
    
    public Status(int attack, int defense){
        this.attack = attack;
        this.defense = defense;
        //this.agility = agility;
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

//    public int getAgility() {
//        return agility;
//    }
//
//    public void setAgility(int agility) {
//        this.agility = agility;
//    }
    
}
