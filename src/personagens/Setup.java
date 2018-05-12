/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personagens;

import itens.Item;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    
    private final String LOAD = "SELECT head, chest, right_hand, left_hand, legs, arms FROM setup WHERE id_setup = ";
    private final String UPDATE1 = "UPDATE setup SET ";
    private final String UPDATE2 = "WHERE id_setup = ";
    
    public Setup(long id){
        this.ID = id;
        head = new Item();
        chest = new Item();
        rightHand = new Item();
        leftHand = new Item();
        legs = new Item();
        arms = new Item();
        load();        
    }
    
    private void load(){
        try{
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jogo", "username", "password");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(LOAD + ID + ";");
        
            Item i;
            rs.next();
            
            long idHead = rs.getLong("head");
            long idChest = rs.getLong("chest");
            long idRightHand = rs.getLong("right_hand");
            long idLeftHand = rs.getLong("left_hand");
            long idLegs = rs.getLong("legs");
            long idArms = rs.getLong("arms");
            
            if(idHead > 0){
                rs = st.executeQuery("SELECT attack, defense, name, tipo FROM itens WHERE id_item = " + idHead + ";");
                i = new Item(idHead, rs.getString("name"), rs.getInt("attack"), rs.getInt("defense"), rs.getString("tipo"));
                head = i;
            }
            if(idChest > 0){
                rs = st.executeQuery("SELECT attack, defense, name, tipoFROM itens WHERE id_item = " + idChest + ";");
                i = new Item(idChest, rs.getString("name"), rs.getInt("attack"), rs.getInt("defense"), rs.getString("tipo"));
                chest = i;
            }
            if(idRightHand > 0){
                rs = st.executeQuery("SELECT attack, defense, name, tipo FROM itens WHERE id_item = " + idRightHand + ";");
                i = new Item(idRightHand, rs.getString("name"), rs.getInt("attack"), rs.getInt("defense"), rs.getString("tipo"));
                rightHand = i;
            }
            if(idLeftHand > 0){
                rs = st.executeQuery("SELECT attack, defense, name, tipo FROM itens WHERE id_item = " + idLeftHand + ";");
                i = new Item(idLeftHand, rs.getString("name"), rs.getInt("attack"), rs.getInt("defense"), rs.getString("tipo"));
                leftHand = i;
            }
            if(idLegs > 0){
                rs = st.executeQuery("SELECT attack, defense, name, tipo FROM itens WHERE id_item = " + idLegs + ";");
                i = new Item(idLegs, rs.getString("name"), rs.getInt("attack"), rs.getInt("defense"), rs.getString("tipo"));
                legs = i;
            }
            if(idArms > 0){
                rs = st.executeQuery("SELECT attack, defense, name, tipo FROM itens WHERE id_item = " + idArms + ";");
                i = new Item(idArms, rs.getString("name"), rs.getInt("attack"), rs.getInt("defense"), rs.getString("tipo"));
                arms = i;
            }
            
            con.close();
        
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
        
        this.head = head;
    }

    public Item getChest() {
        return chest;
    }

    public void setChest(Item chest) {
        this.chest = chest;
    }

    public Item getRightHand() {
        return rightHand;
    }

    public void setRightHand(Item rightHand) {
        this.rightHand = rightHand;
    }

    public Item getLeftHand() {
        return leftHand;
    }

    public void setLeftHand(Item leftHand) {
        this.leftHand = leftHand;
    }

    public Item getLegs() {
        return legs;
    }

    public void setLegs(Item legs) {
        this.legs = legs;
    }

    public Item getArms() {
        return arms;
    }

    public void setArms(Item arms) {
        this.arms = arms;
    }
    
    private void update(String campo){
        try{
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jogo", "username", "password");
            Statement st = con.createStatement();
            st.executeUpdate(UPDATE1 + campo + UPDATE2 + ID + ";");
            
            con.close();
        }
        catch(Exception e){
            Logger.getLogger(Setup.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Erro no update");
        }
    }
}
