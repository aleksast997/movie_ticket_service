/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import controller.Controller;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import viewForm.FrmClient;
import viewForm.Login;

/**
 *
 * @author aleks
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Client client = new Client();
        try {
            client.connect();
        } catch (IOException ex) {
            //Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    private void connect() throws IOException {
        Socket socket = new Socket("localhost",9000);
        System.out.println("Klijent se povezao");
        //daj kontroleru soket
        Controller.getInstance().setSocket(socket);
        //otvori formu 
         new Login().setVisible(true);
        //new FrmClient().setVisible(true);
        
        
    }
    
}
