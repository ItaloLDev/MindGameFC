/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mindgamefc;

import java.util.Scanner;

/**
 *
 * @author itlac
 */
public class Mensagens {
    
    public static void apresentacao() {

        System.out.println("####################################");
        System.out.println("----BEM VINDO AO MIND GAME F.C!----");
        System.out.print("\n");
        System.out.println(">>>REGRAS<<<");
        System.out.println("- O jogo é baseado na adivinhação;");
        System.out.println("- Os dois jogadores, um atacante e um defensor," +
                " tem até **5 jogadas disponíveis**;");
        System.out.println("- O tabuleiro é formado por 3 FAIXAS, que vão de A à C, tendo a quarta faixa D que é o GOL"+
            "\nAs FAIXAS A e C possuem 4 casas, de 0 à 3, e a FAIXA B possui 3 casas, de 0 a 2. A faixa D(GOL) possui 3 casas, equiavelentes ao canto "
                + "esquerdo,meio do gol e canto direito");
        System.out.println("- A cada rodada, tanto o defensor quanto o atacante escolhem suas JOGADAS,"
                + " compostas de LETRA DA FAIXA e NUMERO DA CASA;");
        System.out.println("- O jogo acaba se o atacante fizer o gol (chegar na faixa D(GOL) sem ter a bola roubada) ou" +
                " se o defensor conseguir recuperar a bola (acertar onde o atacante vai ir naquela rodada);");
        System.out.println("- O defensor também controla o goleiro, podendo defender o 'chute' do atacante;");
        System.out.println("- As movimentações são livres dentro do número de jogadas, porém O ATACANTE SÓ PODE CHUTAR PARA O GOL "
                + "\n(SELECIONAR ALGUMA CASA NA FAIXA D)"
                + "quando estiver na faixa C  ;");
        System.out.println("####################################");
    }
    
    public static String exibirJogada(Scanner inUser, int numJogadas, String jogador){
        String jogada = null;
        System.out.println("\n\n********* " + jogador + " *********");
        System.out.println("\nJogadas disponiveis: " + numJogadas);
        System.out.println("\nFAIXAS A e C = 4 CASAS (0 à 3) || FAIXAS B e D(GOL) = 3 CASAS (0 à 2)");
        System.out.println("\n\nEscolha uma FAIXA e uma CASA (Exemplo - A1): ");
        jogada = inUser.nextLine().toUpperCase();
        return jogada;
    }
    
    public static void localizacaoAtual(){
        
    }
}
