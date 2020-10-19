package mindgamefc;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Servidor em rede");
            Socket defensor = server.accept();
            if(defensor.isConnected())
                System.out.println("Defensor conectado");

            Socket atacante = server.accept();
            if(atacante.isConnected())
                System.out.println("Atacante conectado");
            
            PrintWriter out_atacante, out_defensor;
            out_atacante = new PrintWriter(atacante.getOutputStream(), true);
            out_defensor = new PrintWriter(defensor.getOutputStream(), true);
            
            System.out.println("Defina o numero de jogadas disponíveis");
            int numJogadas = new Scanner(System.in).nextInt();
            out_atacante.println(numJogadas);
            out_defensor.println(numJogadas);
            
            Scanner in_atacante, in_defensor;
            in_atacante = new Scanner(atacante.getInputStream());
            in_defensor = new Scanner(defensor.getInputStream());
            
            String atac_jogada, def_jogada;
            
            int resultado = 0;
            
            while (resultado != 3) {
                def_jogada = in_defensor.nextLine();
                atac_jogada = in_atacante.nextLine();
                Controller controller = new Controller (atacante, atac_jogada, defensor, def_jogada);
                resultado = controller.run();
                switch (resultado) {
                    case 1:
                        out_atacante.println(1);
                        out_defensor.println(1);
                        out_defensor.println(atac_jogada);
                        break;
                    case 2:
                        out_atacante.println(0);
                        out_defensor.println(0);
                        out_defensor.println(atac_jogada);
                        break;
                    case 3:
                        out_atacante.println(-1);
                        out_defensor.println(-1);
                        out_defensor.println(atac_jogada);
                        break;
                    default:
                        break;
                }
            }
        } catch (IOException e) {
                e.getMessage();
        }
    }
}
