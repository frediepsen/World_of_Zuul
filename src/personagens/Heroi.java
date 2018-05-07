/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personagens;

import java.util.HashMap;
import itens.Arma;
import itens.Item;

/**
 * @author USUARIO
 */
public class Heroi extends Personagem{
    
    private Status stats;
    private Status iniciais;
    private int level;
    private int xpMax;
    private int xp;
    
    public Heroi(String name, int level ,int life, int att, int def, int xp, int xp_max) {
        super(name, life);
        stats = new Status(att, def);
        iniciais = new Status(att, def);
        this.level = level;
        this.xp = xp;
        this.xpMax = xp_max;
    }


    public Status getStats() {
        return stats;
    }

    public void setStats(Status stats) {
        this.stats = stats;
    }
    
//    public void addItem(Item item){
//        mochila.put(item.getNome(), item);
//    }
//    public void equipaArma(int a, int ag){
//        if(armaEquipada){
//            this.stats.setAttack(this.iniciais.getAttack());
//            this.stats.setAttack(this.stats.getAttack() + a);
//            //this.stats.setAgility(ag);
//        }
//        if(!armaEquipada){
//            this.stats.setAttack(stats.getAttack() + a);
//            //this.stats.setAgility(ag);
//            armaEquipada = true;
//        }
//    }
//    
//    public void desequipaArma(int a){
//        this.armaEquipada = false;
//        this.stats.setAttack(this.stats.getAttack() - a);
//        //this.stats.setAgility(10);
//    }
    
//    public int getArmaIndice() {
//        return armaIndice;
//    }
//
//    public void setArmaIndice(int armaIndice) {
//        this.armaIndice = armaIndice;
//    }

//    public boolean isArmaEquipada() {
//        return armaEquipada;
//    }
//
//    public void setArmaEquipada(boolean armaEquipada) {
//        this.armaEquipada = armaEquipada;
//    }
//
//    public int getArmaId() {
//        return armaId;
//    }
//
//    public void setArmaId(int armaId) {
//        this.armaId = armaId;
//    }
    
}
