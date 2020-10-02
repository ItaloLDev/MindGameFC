/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mindgamefc;

/**
 *
 * @author itlac
 */
public class Jogador {
    
    private char simbolo;
    private char casa; private int posicao;
    private int numJogadas = 5;
    
    public Jogador(char simbolo){
        this.simbolo = simbolo;
    }

    public int getNumJogadas(){
        return this.numJogadas;
    }

    public void updateJogadas(){
        this.numJogadas -= 1;
    }

    public char getCasa() {
        return casa;
    }

    public void setCasa(char casa) {
        this.casa = casa;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
    
    public char getSimbolo(){
        return simbolo;
    }

}
