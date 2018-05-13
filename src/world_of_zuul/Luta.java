package world_of_zuul;

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
    
    public Luta(Heroi h, Vilao v){
        this.heroi = h;
        this.vilao = v;
    }
    
    public void pancadaria(){
        h = heroi.sorte();
        v = vilao.sorte();
        
        if(h > v){
            vilao.setLife(vilao.getLife() - heroi.getAttack());
        }
        else{
            if(v > h){
                heroi.setVidaAtual(heroi.getLife() - vilao.getAttack());
            }
            else{
                heroi.setVidaAtual(heroi.getLife() - vilao.getAttack());
                vilao.setLife(vilao.getLife() - heroi.getAttack());
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
