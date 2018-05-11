/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personagens;

import itens.Item;
import java.util.HashMap;
import java.util.Random;

/**
 * @author USUARIO
 */
public class Heroi extends Status{
    
    private String name;
    private int level;
    private int xpMax;
    private int xp;
    private Setup s;
    private Random r = new Random();
    
    public Heroi(String name, int level ,int life, int att, int def, int xp, int xp_max, long setup) {
        super(att, def, life);
        this.name = name;
        this.level = level;
        this.xp = xp;
        this.xpMax = xp_max;
        s = new Setup(setup);
        equipAll();
    }
    
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXpMax() {
        return xpMax;
    }

    public void setXpMax(int xpMax) {
        this.xpMax = xpMax;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public String getName() {
        return name;
    }
    
    public int sorte(){
        return r.nextInt(9);
    }
    
    public void equip(int att, int def){
        setAttack(getAttack() + att);
        setDefense(getDefense() + def);
    }

    private void equipAll() {
        for(Item i : s.getItens()){
            equip(i.getAttack(), i.getDefense());
        }
    }
    
    public void xpUp(int xp){
        this.xp += xp;
        while(xp >= xpMax){
            levelUp();
        }
    }
    private void levelUp(){
        level ++;
        xp = xp - xpMax;
        xpMax = xpMax + (int)(xpMax * 0.17);
    }
    
}
