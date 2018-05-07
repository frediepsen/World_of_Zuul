/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personagens;

/**
 * @author USUARIO
 */
public class Vilao extends Personagem{
    
    private Status stats;
    
    public Vilao(String nome, int vidaMax, int a, int d, int ag) {
        super(nome, vidaMax);
        stats = new Status(a, d, ag);
    }

    public Status getStats() {
        return stats;
    }

    public void setStats(Status stats) {
        this.stats = stats;
    }
    
}
