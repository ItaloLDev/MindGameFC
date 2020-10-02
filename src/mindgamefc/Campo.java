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
public class Campo {
    
    private char a[] = new char[4];
    private char b[] = new char[3];
    private char c[] = new char[4];
    private char d[] = new char[3];

    public void inicializarCampo(){
        for(int i = 0; i < a.length; i++){
            a[i] = ' ';
            c[i] = ' ';
        }
        for(int i = 0; i < b.length; i++){
            b[i] = ' ';
            d[i] = ' ';
        }
    }
    
    public boolean setJogadaAtacante(Jogador j ){
        switch (j.getCasa()) {
            case 'a':
                if(a[j.getPosicao()] != ' ' && a[j.getPosicao()] != j.getSimbolo() )
                    return false;
                a[j.getPosicao()] = j.getSimbolo();
                return true;
            case 'b':
                if(b[j.getPosicao()] != ' '  && b[j.getPosicao()] != j.getSimbolo() )
                    return false;
                b[j.getPosicao()] = j.getSimbolo();
                return true;
            case 'c':
                if(c[j.getPosicao()] != ' '  && c[j.getPosicao()] != j.getSimbolo() )
                    return false;
                c[j.getPosicao()] = j.getSimbolo();
                return true;
            case 'd':
                if(d[j.getPosicao()] != ' '  && d[j.getPosicao()] != j.getSimbolo() )
                    return false;
                d[j.getPosicao()] = j.getSimbolo();
                return true;
            default:
                break;
        }
        return true;
    }

    public boolean setJogadaDefensor(Jogador j ){
        switch (j.getCasa()) {
            case 'a':
                a[j.getPosicao()] = j.getSimbolo();
                return true;
            case 'b':
                b[j.getPosicao()] = j.getSimbolo();
                return true;
            case 'c':
                c[j.getPosicao()] = j.getSimbolo();
                return true;
            case 'd':
                d[j.getPosicao()] = j.getSimbolo();
                return true;
            default:
                break;
        }
        return true;
    }
    
    public boolean isGol(){
        for(int i = 0; i < d.length; i++){
            if(d[i] == 'X')
                return true;
        }
        return false;
    }

    
}
