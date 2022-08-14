/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domen.Booking;
import domen.Hall;
import domen.Movie;
import domen.Query;
import domen.Show;
import domen.User;
import java.sql.Date;
import java.util.List;
import repository.Repository;
import repository.RepositoryBooking;
import repository.RepositoryDBGeneric;
import repository.RepositoryHall;
import repository.RepositoryMovie;
import repository.RepositoryShow;
import repository.RepositoryUser;
import so.AbstractSO;
import so.AddBookingSO;
import so.AddMovieSO;
import so.AddShowSO;
import so.DeleteBookingSO;
import so.GetAllBookings;
import so.GetAllHallsSO;
import so.GetAllMoviesSO;
import so.GetAllShows;
import so.GetQuerySO;
import so.GetShowsByMovieDateSO;
import so.LoginUserSO;
import so.RegisterUserSO;

/**
 *
 * @author aleks
 */
public class Controller {
    
    private static Controller instance;
    //private static Broker broker;
    
    
    private final RepositoryUser storageUser;
    private final RepositoryHall storageHall; 
    private final RepositoryMovie storageMovie;
    private final RepositoryBooking storageBooking;
    private final RepositoryShow storageShow;
    private final Repository repositoryGeneric;
    
    
    
    private Controller(){   
        //broker = new Broker();
        this.storageUser = new RepositoryUser();
        this.storageHall = new RepositoryHall();
        this.storageMovie = new RepositoryMovie();
        this.storageShow = new RepositoryShow();
        this.storageBooking = new RepositoryBooking();
        this.repositoryGeneric = new RepositoryDBGeneric();
    }
    
    public static  Controller getInstance(){
        if(instance == null) instance = new Controller();
        return instance;
    }
    
   /* public void connect(){
        try {
            broker.connect();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void disconnect(){
        try {
            broker.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   

    public List<Upit> vratiUpit() {
        List<Upit> data = new ArrayList<>();
        try {
            data = broker.vratiUpit();
            broker.commit();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }*/

    public boolean register(User user) throws Exception {
        AbstractSO registerUserSO = new RegisterUserSO();
            return (User) registerUserSO.execute(user) != null;
        /*if(storageUser.register(user)){
        try {
        storageUser.commit();
        return true;
        } catch (SQLException ex) {
        //Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        storageUser.rollback();
        }
        }
        return false;*/            
            

        
    }

    public User login(User user) throws Exception {
        AbstractSO loginUserSO = new LoginUserSO();
        return (User)loginUserSO.execute(user);
        /*try {
            user = storageUser.login(user);
            storageUser.commit();
            System.out.println(user.getIme());
            return user;
        } catch (SQLException ex) {
            //Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            storageUser.rollback();
            throw ex;
        }*/
        
    }

    public List<Movie> getAllMovies() throws Exception {
        AbstractSO getAllMovies = new GetAllMoviesSO();
        return (List<Movie>) getAllMovies.execute(new Movie());
        
        /*try {
            return storageMovie.getAll();
        } catch (Exception ex) {
            //Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }*/
    }

    public List<Show> getAllShows(Show s) throws Exception {
        //return storageShow.getAllShows(s);
        AbstractSO getAllShows = new GetShowsByMovieDateSO();
        return (List<Show>) getAllShows.execute(s);
    }

    public void book(Booking booking) throws Exception {
        AbstractSO addBooking = new AddBookingSO();
        addBooking.execute(booking);
        /*try {
            storageBooking.add(booking);
            storageBooking.commit();
        } catch (Exception ex) {
            //Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            storageBooking.rollback();
            throw ex;
        }*/
    }

    public List<Booking> getAllBookings(User user) throws Exception {
        AbstractSO getAllBookings = new GetAllBookings();
        return (List<Booking>) getAllBookings.execute(user);
        //return storageBooking.getAllBookings(user);
    }

    

    public void deleteBooking(Booking booking) throws Exception {
        
        AbstractSO deleteBooking = new DeleteBookingSO();
        deleteBooking.execute(booking);
        /*try {
            storageBooking.delete(booking);
            storageBooking.commit();
        } catch (Exception ex) {
            //Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            storageBooking.rollback();
            throw ex;
        }*/
    }

    public void addMovie(Movie movie) throws Exception {
        
        AbstractSO addMovie = new AddMovieSO();
        addMovie.execute(movie);
        
        /*try {
            storageMovie.add(movie);
            storageMovie.commit();
        } catch (Exception ex) {
            //Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            storageMovie.rollback();
            throw ex;
        }*/
    }

    public List<Hall> getAllHalls() throws Exception {
        AbstractSO getAllHalls = new GetAllHallsSO();
        return (List<Hall>) getAllHalls.execute(new Hall());
        /*try {
            return storageHall.getAll();
        } catch (Exception ex) {
            //Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }*/
    }

    public List<Show> getAllShows(Hall hall, Date date) throws Exception {
        //return storageShow.getAllShows(hall, date);
        AbstractSO getAll = new GetAllShows();
        Show s = new Show();
        s.setDate(date);
        s.setIdHall(hall.getIdHall());
        return (List<Show>) getAll.execute(s);
    }

    public void addShow(Show show) throws Exception {
        
        AbstractSO addShow = new AddShowSO();
        addShow.execute(show);
        
        /*try {
            storageShow.add(show);
            storageShow.commit();
        } catch (Exception ex) {
            //Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            storageShow.rollback();
            throw ex;
        }*/
    }

    public List<Query> getQuery() throws Exception{
        AbstractSO getQuery = new GetQuerySO();
        return (List<Query>) getQuery.execute(new Query());
    }
    
    
    
}
