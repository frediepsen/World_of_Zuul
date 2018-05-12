/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itens;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Bag {
    private ArrayList<Item> itens;
    private final long ID;
    
    private final String LOAD = "SELECT itens FROM bags WHERE id_bag = ";
    
    public Bag(long id){
        itens = new ArrayList<>();
        this.ID = id;
        load();
    }
    public Bag(Bag b){
        itens = b.getItens();
        ID = b.ID;
    }
    
    public ArrayList<Item> getItens(){
        return new ArrayList<Item>(itens);
    }
    
    private void load(){
        try{
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jogo", "user", "pw");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(LOAD + ID + ";");
            
            rs.next();
            Array in = rs.getArray("itens");
            
            if(!in.equals(null)){
                BigDecimal[] l = (BigDecimal[]) in.getArray();
                Item n = new Item();
                for(BigDecimal id : l){
                    
                    rs = st.executeQuery("SELECT id_item, name, attack, defense, tipo FROM itens WHERE id_item = " + id + ";");
                    if(rs.next()){
                        n = new Item(rs.getInt("id_item"), rs.getString("name"), rs.getInt("attack"), rs.getInt("defense"), rs.getString("tipo"));
                    }
                    
                    itens.add(n);
                }
            }
            
            
            con.close();
        }
        catch(Exception ex){
            Logger.getLogger(Bag.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro Bag");
        }
    }
    
    public Item findItemById(long id){
        for(Item i : itens){
            if(id == i.getId()){
                return i;
            }
        }
        return null;
    }
}
