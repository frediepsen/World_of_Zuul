/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personagens;

import itens.Bag;
import itens.Item;
import itens.Item.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author USUARIO
 */
public class Heroi extends Status{
    
    private final int ID;
    private String name;
    private int level;
    private int vidaAtual;
    private int xpMax;
    private int xp;
    private Setup setup;
    private Random r = new Random();
    private Bag bag;
    
    private final String UPDATE1 = "UPDATE herois SET ";
    private final String UPDATE2 = "WHERE id = ";
    
    public Heroi(int id, String name, int level ,int life, int att, int def, int xp, int xp_max, long setup, long bag) {
        super(att, def, life);
        this.ID = id;
        this.name = name;
        this.level = level;
        this.vidaAtual = life;
        this.xp = xp;
        this.xpMax = xp_max;
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
    
    public int sorte(){
        return r.nextInt(9);
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

    public int getVidaAtual() {
        return vidaAtual;
    }

    public void setVidaAtual(int vidaAtual) {
        this.vidaAtual = vidaAtual;
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
        try{
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jogo", "user", "pw");
            Statement st = con.createStatement();
            st.executeUpdate(UPDATE1 + campo + UPDATE2 + ID + ";");
            
            con.close();
        }
        catch(Exception e){
            Logger.getLogger(Heroi.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Erro no update/heroi");
        }
    }
    
    public Bag getBag(){
        return new Bag(bag);
    }
}
