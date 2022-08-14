/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.ResponseType;
import communication.Sender;
import domen.User;
import java.net.Socket;

/**
 *
 * @author aleks
 */
public class Controller {
    
    private static Controller instance;
    private Socket socket;
    
    private User user; //napravi get
    
    private Controller(){}
    
    public static Controller getInstance(){
        if(instance == null) instance = new Controller();
        return instance;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public User getUser() {
        return user;
    }
    
    public Response ucitajCb(Request request) throws Exception{
        //posalji zahtev
        new Sender(socket).send(request);
        System.out.println("Zahtev poslat");
        //procitaj i vrati odgovor servera
        return (Response)new Receiver(socket).receive();
    }
    
    public Response login(Request request) throws Exception{
        //posalji zahtev
        new Sender(socket).send(request);
        //System.out.println("Zahtev poslat");
        //procitaj i vrati odgovor servera
        Response response = (Response) new Receiver(socket).receive();
        if(response.getResponseType().equals(ResponseType.SUCCESS)){
            this.user = (User) response.getResult();
        }
        return response;
    }

    public Response register(Request request) throws Exception {
        new Sender(socket).send(request);
        return (Response)new Receiver(socket).receive();
    }

    public Response getAllShows(Request request) throws Exception {
        new Sender(socket).send(request);
        return (Response)new Receiver(socket).receive();
    }

    public Response book(Request request) throws Exception {
        new Sender(socket).send(request);
        return (Response)new Receiver(socket).receive();
    }

    public Response getAllBookings(Request request) throws Exception {
        new Sender(socket).send(request);
        return (Response)new Receiver(socket).receive();
    }

    public Response deleteBooking(Request request) throws Exception {
        new Sender(socket).send(request);
        return (Response)new Receiver(socket).receive();
    }

    
}
