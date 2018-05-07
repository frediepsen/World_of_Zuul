/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itens;

/**
 *
 * @author Usuário
 */
public class Consumivel extends Item{
    
    private int recuperaVida;
    
    public Consumivel(int id) {
        super("Poção de Vida", id, 1);
        this.recuperaVida = 20;
    }
    //String nome, int id, int recuperaVida
    
    
}
