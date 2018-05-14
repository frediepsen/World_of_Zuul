/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personagens;

import itens.Bag;
import itens.Item;
import java.util.Random;
import tela.Jogo;
import tela.LevelUp;

/**
 * @author USUARIO
 */
public class Heroi extends Status{
    
    private final int ID;
    private final String name;
    private int level;
    private int vidaAtual;
    private int xpMax;
    private int xp;
    private final Setup setup;
    private final Bag bag;
    private int gold;
    
    private final String UPDATE1 = "UPDATE herois SET ";
    private final String UPDATE2 = "WHERE id = ";
    
    public Heroi(int id, String name, int level ,int life, int att, int def, int xp, int xp_max, long setup, long bag, int gold) {
        super(att, def, life);
        this.ID = id;
        this.name = name;
        this.level = level;
        this.vidaAtual = life;
        this.xp = xp;
        this.xpMax = xp_max;
        this.gold = gold;
        this.bag = new Bag(bag);
        this.setup = new Setup(setup);
    }
    
    public int getLevel() {
        return level;
    }

    public int getXpMax() {
        return xpMax;
    }

    public int getXp() {
        return xp;
    }

    public String getName() {
        return name;
    }
    
    public void increaseXp(int xp){
        this.xp += xp;
        while(this.xp >= xpMax){
            levelUp();
        }
        System.out.println(this.xp);
        update( "xp=" + this.xp);
    }
    private void levelUp(){
        level ++;
        xp = xp - xpMax;
        xpMax = xpMax + (int)(xpMax * 0.17);
        update("level=" + this.level + ", xp_max=" + this.xpMax);
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public void setVidaAtual(int vidaAtual) {
        this.vidaAtual = vidaAtual;
    }

    public int getGold() {
        return gold;
    }
    
    public void increaseGold(int g){
        this.gold += g;
        update("gold = " + this.gold);
    }
    
    public void takeDamage(int damage){
        float i = damage * (150 / (float)( this.getDefense()+100 ) );
        this.setVidaAtual(this.getVidaAtual() - (int)i );
    }
    
    public void equip(Item i){
        switch(i.getType()){
            case HEAD:
                setAttack(this.getAttack() - setup.getHead().getAttack() + i.getAttack());
                setDefense(this.getDefense() - setup.getHead().getDefense() + i.getDefense());
                setup.setHead(i);
                break;
            case CHEST:
                setAttack(this.getAttack() - setup.getChest().getAttack() + i.getAttack());
                setDefense(this.getDefense() - setup.getChest().getDefense() + i.getDefense());
                setup.setChest(i);
                break;
            case LEGS:
                setAttack(this.getAttack() - setup.getLegs().getAttack() + i.getAttack());
                setDefense(this.getDefense() - setup.getLegs().getDefense() + i.getDefense());
                setup.setLegs(i);
                break;
            case ARMS:
                setAttack(this.getAttack() - setup.getArms().getAttack() + i.getAttack());
                setDefense(this.getDefense() - setup.getArms().getDefense() + i.getDefense());
                setup.setArms(i);
                break;
            case RHAND:
                setAttack(this.getAttack() - setup.getRightHand().getAttack() + i.getAttack());
                setDefense(this.getDefense() - setup.getRightHand().getDefense() + i.getDefense());
                setup.setRightHand(i);
                break;
            case LHAND:
                setAttack(this.getAttack() - setup.getLeftHand().getAttack() + i.getAttack());
                setDefense(this.getDefense() - setup.getLeftHand().getDefense() + i.getDefense());
                setup.setLeftHand(i);
                break;
            case DHAND:
                break;
        }
        
        update("attack = " + getAttack() + ", defense = " + getDefense());
    }
    
    private void update(String campo){
        Jogo.c.executaQ(UPDATE1 + campo + UPDATE2 + ID + ";");
    }
    
    public Bag getBag(){
        return new Bag(bag);
    }
    
    public void save(){
        Jogo.c.executaQ("UPDATE herois SET life=" + this.getLife() + ", attack=" + this.getAttack() + ", defense=" + this.getDefense() 
                        + ", level=" + this.level + ", xp=" + this.xp + ", xp_max=" + this.xpMax + ", gold=" + this.gold + " WHERE id = " 
                        + ID);
    }
}
