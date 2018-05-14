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
    private int vidaMax;
    
    public Vilao(Vilao v) {
        super(v.getAttack(), v.getDefense(), v.getLife());
        this.name = v.name;
        vidaMax = v.getLife();
        gold = v.gold;
        xp = v.xp;
    }
    
    public Vilao(String name, int vida, int att, int def) {
        super(att, def, vida);
        this.name = name;
        vidaMax = vida;
        gold = (int)((vida / 10) + (att / 5) + (def / 5));
        xp = (int)((vida / 8) + (att / 4) + (def / 4));
    }

    public String getName() {
        return name;
    }

    public int getGold() {
        return gold;
    }

    public int getXp() {
        return xp;
    }

    public int getVidaMax() {
        return vidaMax;
    }
    
    public void takeDamage(int damage){
        float i = damage * (150 / (float)( this.getDefense()+100 ) );
        this.setLife(this.getLife() - (int)i );
    }
    
}
