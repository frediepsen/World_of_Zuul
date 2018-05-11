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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import tela.Jogo;

/**
 *
 * @author Usuario
 */
public class Setup {
    private long head;
    private long chest;
    private long rightHand;
    private long leftHand;
    private long legs;
    private long arms;
    private long id;
    
    private ArrayList<Item> itens;
    
    
    private final String LOAD = "SELECT head, chest, right_hand, left_hand, legs, arms FROM setup";
    
    public Setup(long id){
        this.id = id;
        itens = new ArrayList<>();
        load();        
    }
    
    private void load(){
        try{
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jogo", "username", "password");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(LOAD);
        
            Item i;
            rs.next();
            
            
            head = rs.getLong("head");
            chest = rs.getLong("chest");
            rightHand = rs.getLong("right_hand");
            leftHand = rs.getLong("left_hand");
            legs = rs.getLong("legs");
            arms = rs.getLong("arms");
            
            if(head > 0){
                rs = st.executeQuery("SELECT attack, defense, name FROM head WHERE id_head = " + head + ";");
                i = new Item(head, rs.getString("name"), rs.getInt("attack"), rs.getInt("defense"));
                itens.add(i);
                
            }
            if(chest > 0){
                rs = st.executeQuery("SELECT attack, defense, name FROM chest WHERE id_chest = " + chest + ";");
                i = new Item(chest, rs.getString("name"), rs.getInt("attack"), rs.getInt("defense"));
                itens.add(i);
            }
            if(rightHand > 0){
                rs = st.executeQuery("SELECT attack, defense, name FROM right_hand WHERE id_right_hand = " + rightHand + ";");
                i = new Item(rightHand, rs.getString("name"), rs.getInt("attack"), rs.getInt("defense"));
                itens.add(i);
            }
            if(leftHand > 0){
                rs = st.executeQuery("SELECT attack, defense, name FROM left_hand WHERE id_left_hand = " + leftHand + ";");
                i = new Item(leftHand, rs.getString("name"), rs.getInt("attack"), rs.getInt("defense"));
                itens.add(i);
            }
            if(legs > 0){
                rs = st.executeQuery("SELECT attack, defense, name FROM legs WHERE id_legs = " + legs + ";");
                i = new Item(legs, rs.getString("name"), rs.getInt("attack"), rs.getInt("defense"));
                itens.add(i);
            }
            if(arms > 0){
                rs = st.executeQuery("SELECT attack, defense, name FROM arms WHERE id_arms = " + arms + ";");
                i = new Item(arms, rs.getString("name"), rs.getInt("attack"), rs.getInt("defense"));
                itens.add(i);
            }
        
        }
        catch(SQLException e){
            Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Erro no setup");
        }
        
        
    }

    public ArrayList<Item> getItens() {
        return new ArrayList<Item>(itens);
    }
}
