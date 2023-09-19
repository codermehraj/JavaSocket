package Phase_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class Server {
    
    private static final int PORT = 9090;

    public static void main(String[] args) throws IOException{

        // THIS PROGRAM WILL ONLY CONNET AND NOTIFY A CLIENT 
        // THEN CLOSE AS IT IS A SINGLE INTERACTION

        ServerSocket listener = new ServerSocket(PORT);

        System.out.println("[SERVER] Waiting for client to connect");

        Socket client = listener.accept();
        System.out.println("[SERVER] A client is connected");
        
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);

        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));        

        try{
            while(true){
                String clientMessage = in.readLine();
                System.out.println("[CLIENT] " + clientMessage);
                out.println("I got you message :D");
            }
        } finally {
            out.close();
            in.close();
        }        

    }
}
