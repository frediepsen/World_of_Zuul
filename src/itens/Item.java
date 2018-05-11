/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itens;

import personagens.Status;

/**
 * @author USUARIO
 */
public class Item extends Status{
    
    private String name;
    private long id;
    
    public Item(long id, String name, int att, int def) {
        super(att, def);
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }
    
    
}
