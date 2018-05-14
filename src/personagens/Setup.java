/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personagens;

import itens.Bag;
import itens.Item;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tela.Jogo;

/**
 *
 * @author Usuario
 */
public class Setup {
    private Item head;
    private Item chest;
    private Item rightHand;
    private Item leftHand;
    private Item legs;
    private Item arms;
    
    private final long ID;
    
    
    private final String LOAD = "SELECT head, chest, right_hand, left_hand, legs, arms FROM setups WHERE id_setup = ";
    private final String UPDATE1 = "UPDATE setups SET ";
    private final String UPDATE2 = "WHERE id_setup = ";
    private final String SELECT = "SELECT attack, defense, name, tipo FROM itens WHERE id_item = ";
    
    public Setup(long id, Bag b){
        this.ID = id;
        head = new Item();
        chest = new Item();
        rightHand = new Item();
        leftHand = new Item();
        legs = new Item();
        arms = new Item();
        load(b);        
    }
    
    private void load(Bag b){
        try{
            ResultSet rs = Jogo.c.getRS(LOAD + ID + ";");
        
            Item i;
            rs.next();
            
            long idHead = rs.getLong("head");
            long idChest = rs.getLong("chest");
            long idRightHand = rs.getLong("right_hand");
            long idLeftHand = rs.getLong("left_hand");
            long idLegs = rs.getLong("legs");
            long idArms = rs.getLong("arms");
            
            if(idHead > 0){
                
                i = b.findItemById(idHead);
                i.setEquipped(true);
                head = i;
            }
            if(idChest > 0){
                
                i = b.findItemById(idChest);
                i.setEquipped(true);
                chest = i;
            }
            if(idRightHand > 0){
                i = b.findItemById(idRightHand);
                i.setEquipped(true);
                rightHand = i;
            }
            if(idLeftHand > 0){
                i = b.findItemById(idLeftHand);
                i.setEquipped(true);
                leftHand = i;
            }
            if(idLegs > 0){
                i = b.findItemById(idLegs);
                i.setEquipped(true);
                legs = i;
            }
            if(idArms > 0){
                i = b.findItemById(idArms);
                i.setEquipped(true);
                arms = i;
            }
            
        }
        catch(SQLException e){
            Logger.getLogger(Setup.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Erro no setup");
        }
        
        
    }

    public Item getHead() {
        return head;
    }

    public void setHead(Item head) {
        update("head = " + head.getId());
        this.head.setEquipped(false);
        head.setEquipped(true);
        this.head = head;
        
    }

    public Item getChest() {
        return chest;
    }

    public void setChest(Item chest) {
        update("chest = " + chest.getId());
        this.chest.setEquipped(false);
        chest.setEquipped(true);
        this.chest = chest;
    }

    public Item getRightHand() {
        return rightHand;
    }

    public void setRightHand(Item rightHand) {
        update("right_hand = " + rightHand.getId());
        this.rightHand.setEquipped(false);
        rightHand.setEquipped(true);
        this.rightHand = rightHand;
    }

    public Item getLeftHand() {
        return leftHand;
    }

    public void setLeftHand(Item leftHand) {
        update("left_hand = " + leftHand.getId());
        this.leftHand.setEquipped(false);
        leftHand.setEquipped(true);
        this.leftHand = leftHand;
    }

    public Item getLegs() {
        return legs;
    }

    public void setLegs(Item legs) {
        update("legs = " + legs.getId());
        this.legs.setEquipped(false);
        legs.setEquipped(true);
        this.legs = legs;
    }

    public Item getArms() {
        return arms;
    }

    public void setArms(Item arms) {
        update("arms = " + arms.getId());
        this.arms.setEquipped(false);
        arms.setEquipped(true);
        this.arms = arms;
    }
    
    private void update(String campo){
        Jogo.c.executaQ(UPDATE1 + campo + UPDATE2 + ID + ";");
    }
}
