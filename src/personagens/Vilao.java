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
public class Vilao extends Status{
    
    private final String name;
    private final int gold;
    private final int xp;
    private Random r;
    
    public Vilao(Vilao v) {
        super(v.getAttack(), v.getDefense(), v.getLife());
        this.name = v.name;
        r  = new Random();
        gold = v.gold;
        xp = v.xp;
    }
    
    public Vilao(String name, int vida, int att, int def) {
        super(att, def, vida);
        this.name = name;
        r  = new Random();
        gold = (int)((vida / 10) + (att / 5) + (def / 5));
        xp = (int)((vida / 8) + (att / 4) + (def / 4));
    }

    public String getName() {
        return name;
    }
    
    public int sorte(){
        return r.nextInt(9);
    }

    public int getGold() {
        return gold;
    }

    public int getXp() {
        return xp;
    }
    
    
}
