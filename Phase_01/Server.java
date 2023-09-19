package Phase_01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    
    private static final int PORT = 9090;

    public static void main(String[] args) throws IOException{

        // THIS PROGRAM WILL ONLY CONNET AND NOTIFY A CLIENT 
        // THEN CLOSE AS IT IS A SINGLE INTERACTION

        ServerSocket listener = new ServerSocket(PORT);

        System.out.println("[SERVER] Waiting for client to connect");

        Socket client = listener.accept();
        System.out.println("[SERVER] A client is connected");
        PrintWriter out = new PrintWriter(client.getOutputStream());
        out.println("Connected to the server");

        System.out.println("[SERVER] single interaction done. Server closed!");

        client.close(); // as the single interaction is completed
        listener.close(); // server has met its goal too :D

    }
}
