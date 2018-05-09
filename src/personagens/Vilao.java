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
    
    private String name;
    private Random r = new Random();
    
    public Vilao(String name, int vida, int att, int def) {
        super(att, def, vida);
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public int sorte(){
        return r.nextInt(9);
    }
    
}
