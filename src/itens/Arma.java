/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itens;

import itens.Item;
import personagens.Status;

/**
 *
 * @author Usuário
 */
public class Arma extends Item{
    
    private Status stats;
    
    public Arma(String nome, int id, int a, int d, int ag, int peso) {
        super(nome, id, peso);
        stats = new Status(a, d, ag);
    }

    public Status getStats() {
        return stats;
    }

//    public void setStats(Status stats) {
//        this.stats = stats;
//    }
    
}
