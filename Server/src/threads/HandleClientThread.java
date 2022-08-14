/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import communication.Operation;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.ResponseType;
import communication.Sender;
import controller.Controller;
import domen.Booking;
import domen.Movie;
import domen.Show;
import domen.User;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.Server;

/**
 *
 * @author aleks
 */
public class HandleClientThread extends Thread{
    
    private Socket socket;

    public HandleClientThread(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        while (!socket.isClosed()) {            
            handleClient(socket);
        }
    }

    private void handleClient(Socket socket) {
        while (true) {            
            try {
                //ObjectInputStream in = new ObjectInputStream(socket.getInputStream()); // staro
                
                
                //zahtev klijenta
                //Request request = (Request)in.readObject();  //staro resenje
                Request request = (Request)new Receiver(socket).receive();
                
                //odgovor za klijenta koji se puni u switch-u
                Response response = null;
                
                //zahtevana operacija
                switch(request.getOperation()){
                    case Operation.LOGIN:
                        response = login(request);
                        break;
                    case Operation.REGISTER:
                        response = register(request);
                        break;
                    case Operation.GET_ALL_MOVIES:
                        response = getAllMovies(request);
                        break;
                    case Operation.GET_ALL_SHOWS:
                        response = getAllShows(request);
                        break;
                    case Operation.BOOK:
                        response = book(request);
                        break;
                    case Operation.GET_ALL_BOOKINGS:
                        response = getAllBookings(request);
                        break;
                    case Operation.DELETE_BOOKING:
                        response = deleteBooking(request);
                        break;    
                }
                
                //vracanje odgovora klijentu
                /*ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()); //staro
                out.writeObject(response);
                out.flush();*/
                new Sender(socket).send(response);
                
            } catch (Exception ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
   
    
   
    private Response register(Request request) {
        Response response = new Response();
        try {
            User user = (User) request.getArgument();
            
            
            if(Controller.getInstance().register(user)){
                response.setResponseType(ResponseType.SUCCESS);
            } else {
                response.setResponseType(ResponseType.ERROR);
                response.setException(new Exception("Error reg"));
            }
            return response;
        } catch (Exception ex) {
            //Logger.getLogger(HandleClientThread.class.getName()).log(Level.SEVERE, null, ex);
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
            return response;
        }
    }
    
    private Response login(Request request){
        Response response = new Response();
        try {
            User user = (User) request.getArgument();
            //System.out.println("ovde");
            user = Controller.getInstance().login(user);
            //System.out.println(user.getIme());
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(user);
            return response;
        } catch (Exception ex) {
            //Logger.getLogger(HandleClientThread.class.getName()).log(Level.SEVERE, null, ex);
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
            return response;
        }
    }

    private Response getAllMovies(Request request) {
        Response response = new Response();
        try {
            List<Movie> movies = new ArrayList<>();   
            movies = Controller.getInstance().getAllMovies();
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(movies);
            return response;
        } catch (Exception ex) {
            //Logger.getLogger(HandleClientThread.class.getName()).log(Level.SEVERE, null, ex);
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
            return response;
        }
    }

    private Response getAllShows(Request request) {
        Response response = new Response();
        try {
            Show s = (Show) request.getArgument();
            System.out.println(s.getIdHall());
            List<Show> shows = new ArrayList<>();
            
            shows = Controller.getInstance().getAllShows(s);
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(shows);
            return response;
        } catch (Exception ex) {
            //Logger.getLogger(HandleClientThread.class.getName()).log(Level.SEVERE, null, ex);
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
            return response;
        }
    }

    private Response book(Request request) {
        Response response = new Response();
        try {
            Booking booking = (Booking) request.getArgument();
            Controller.getInstance().book(booking);
            response.setResponseType(ResponseType.SUCCESS);
            return response;
        } catch (Exception ex) {
            //Logger.getLogger(HandleClientThread.class.getName()).log(Level.SEVERE, null, ex);
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
            return response;
        }
    }

    private Response getAllBookings(Request request) {
        Response response = new Response();
        try {
            User user = (User) request.getArgument();
            List<Booking> bookings = new ArrayList<>();
            
            bookings = Controller.getInstance().getAllBookings(user);
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(bookings);
            return response;
        } catch (Exception ex) {
            //Logger.getLogger(HandleClientThread.class.getName()).log(Level.SEVERE, null, ex);
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
            return response;
        }
    }

    private Response deleteBooking(Request request) {
        Response response = new Response();
        try {
            Booking booking = (Booking) request.getArgument();
            System.out.println("bok");
            Controller.getInstance().deleteBooking(booking);
            response.setResponseType(ResponseType.SUCCESS);
            return response;
        } catch (Exception ex) {
            //Logger.getLogger(HandleClientThread.class.getName()).log(Level.SEVERE, null, ex);
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
            return response;
        }
    }
    
}
