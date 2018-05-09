/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personagens;

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
    
}
