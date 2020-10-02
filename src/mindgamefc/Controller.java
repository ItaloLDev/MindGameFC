/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mindgamefc;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author itlac
 */
public class Controller {
    Socket s_atacante, s_defensor;
    Scanner in_atacante, in_defensor;
    PrintWriter out_atacante, out_defensor;
    String def_jogada = null;
    String atac_jogada = null;

    public Controller(Socket atacante, String a_jogada, Socket defensor, String d_jogada) throws IOException{
        this.s_atacante = atacante;
        in_atacante = new Scanner(this.s_atacante.getInputStream());
        this.s_defensor = defensor;
        in_defensor = new Scanner(this.s_defensor.getInputStream());
        def_jogada = d_jogada;
        atac_jogada = a_jogada;
    }

    public int run() {
        Jogador atacante = new Jogador('X');
        Jogador defensor = new Jogador('#');
        
        defensor.setCasa(def_jogada.toLowerCase().charAt(0));
        defensor.setPosicao(Integer.parseInt(Character.toString(def_jogada.charAt(1))));
        
        atacante.setCasa(atac_jogada.toLowerCase().charAt(0));
        atacante.setPosicao(Integer.parseInt(Character.toString(atac_jogada.charAt(1))));
        
        Campo campo = new Campo();
        campo.inicializarCampo();
        campo.setJogadaDefensor(defensor);
        if(campo.setJogadaAtacante(atacante)){
            if(campo.isGol()){
                return 1;
            }else{
                return 2;
            }
        }else{
            return 3;
        }
    }
}
    
    
    
