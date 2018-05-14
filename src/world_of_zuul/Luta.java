package world_of_zuul;

import java.util.Random;
import personagens.Heroi;
import personagens.Vilao;

/**
 * @author USUARIO
 */
public class Luta {
    private Heroi heroi;
    private Vilao vilao;
    
    private int h;
    private int v;
    private Random r;
    
    public Luta(Heroi h, Vilao v){
        this.heroi = h;
        this.vilao = v;
        this.r = new Random();
    }
    
    public void pancadaria(){
        h = r.nextInt(99);
        v = r.nextInt(99);
        
        if(h > v){
            vilao.takeDamage(heroi.getAttack());
        }
        else{
            if(v > h){
                heroi.takeDamage(vilao.getAttack());
            }
            else{
                heroi.takeDamage(vilao.getAttack());
                vilao.takeDamage(heroi.getAttack());
            }
        }
    }

    public Heroi getHeroi() {
        return heroi;
    }

    public void setHeroi(Heroi heroi) {
        this.heroi = heroi;
    }

    public Vilao getVilao() {
        return vilao;
    }

    public void setVilao(Vilao vilao) {
        this.vilao = vilao;
    }
}
