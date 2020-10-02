package mindgamefc;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientAtacante {
    static char  faixaAnterior;
    public static void main(String[] args) {

        Mensagens.apresentacao();
        try {
            
            //region variaveis
            Socket client = new Socket("", 1234);
            Scanner inServer = new Scanner(client.getInputStream());
            Scanner inUser = new Scanner(System.in);
            PrintWriter outServer = new PrintWriter(client.getOutputStream(),true);
            String jogada =  "";
            faixaAnterior = ' ';
            int numJogadas = 4;
            int resultado = 0;
            //endregion
            
            while (resultado == 0 && numJogadas != 0) {
                jogada = Mensagens.exibirJogada(inUser, numJogadas, "ATACANTE");
                if(validarJogadaAtacante(jogada)){
                    System.out.println("\n####################################");
                    System.out.println("JOGADA VALIDA, AGUARDANDO RESPOSTA...");
                    numJogadas -= 1;
                    outServer.println(jogada);
                    resultado = Integer.parseInt(inServer.next());
                    divulgarResultado(resultado);
                    System.out.println("####################################\n");
                }
            }
            fecharConexoes(client,outServer, inServer );
            System.out.println("FIM DE JOGO");
        } catch (Exception e) {
                e.printStackTrace();
        }
    }

   private static boolean validarJogadaAtacante(String jogada) {
        int posi = Integer.parseInt(Character.toString(jogada.charAt(1)));
        char faixa = jogada.charAt(0);
        
        switch (faixa){
            case 'A':
                if(posi > 3 || posi < 0){
                    System.out.println("\n\nCASA inválida");
                    return false;
                }else{
                    faixaAnterior = 'A';
                    return true;
                }

            case 'B':
               if(posi > 2 || posi < 0){
                    System.out.println("\n\nCASA inválida");
                    return false;
                }else{
                   faixaAnterior = 'B';
                    return true;
                }

            case 'C':
                if(posi > 3 || posi < 0){
                    System.out.println("\n\nCASA inválida");
                    return false;
                }else{
                    faixaAnterior = 'C';
                    return true;
                }

            case 'D':
                if( faixaAnterior == 'C'){
                    if(posi > 2 || posi < 0){
                        System.out.println("\n\nCASA inválida");
                        return false;
                    }else{
                        return true;
                    }
                }else{
                    System.out.println("\n\nVOCÊ NÃO PODE CHUTAR DE TÃO LONGE, CHEGUE MAIS PERTO!");
                    return false;
                }

            default:
                System.out.println("\n\nJOGADA inválida");
                return false;
        }
    }
    
    public static void fecharConexoes(Socket clientSocket, PrintWriter outToServer, Scanner inFromServer) throws IOException {
        clientSocket.close();
        outToServer.close();
        inFromServer.close();
    }
    
    private static void divulgarResultado(int resultado) {
        switch (resultado) {
            case -1:
                System.out.println("\nEssa não, o time adversário roubou a bola =(");
                break;
            case 0:
                System.out.println("\nVocê segue com a bola! Calcule bem sua proxima jogada...");
                break; 
            case 1:
                System.out.println("\n\nQUE GOLAAAAAAAÇO, JOGADA DE VIDEO-GAME!!!!!!!!\n");
                break;
            default:
                break;
        }
    }
}
