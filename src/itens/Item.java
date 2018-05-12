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
    public enum Type {HEAD, CHEST, RHAND, LHAND, LEGS, ARMS, DHAND};
    private Type type;
    private boolean equipped;
    
    public Item(){};
    
    public Item(long id, String name, int att, int def, String tipo) {
        super(att, def);
        this.name = name;
        this.equipped = false;
        this.id = id;
        if(tipo.equals("HEAD")){
            type = Type.HEAD;
        }
        else{
            if(tipo.equals("CHEST")){
                type = Type.CHEST;
            }
            else{
                if(tipo.equals("ARMS")){
                    type = Type.ARMS;
                }
                else{
                    if(tipo.equals("RHAND")){
                        type = Type.RHAND;
                    }
                    else{
                        if(tipo.equals("LHAND")){
                            type = Type.LHAND;
                        }
                        else{
                            if(tipo.equals("DHAND")){
                                type = Type.DHAND;
                            }
                            else{
                                type = Type.LEGS;
                            }
                        }
                    }
                }
            }
        }
        
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public boolean isEquipped() {
        return equipped;
    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }
    
}
