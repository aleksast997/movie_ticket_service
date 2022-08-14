/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleks
 */
public class ServerThread extends Thread{
    
    private ServerSocket ss;
    private List<HandleClientThread> clients;

    public ServerThread() throws IOException {
        this.ss = new ServerSocket(9000);
        this.clients = new ArrayList<>();
    }

    @Override
    public void run() {
        while (!ss.isClosed()) {            
            try {
                //Controller.getInstance().connect();
                Socket socket = ss.accept();
                HandleClientThread client = new HandleClientThread(socket);
                client.start();
                clients.add(client);
            } catch (Exception ex) {
                throw  new RuntimeException("Server stopped");
            }
        }
    }
    
    
    
    
    
}
