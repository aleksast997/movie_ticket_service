/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Booking;
import domen.Hall;
import domen.Movie;
import domen.Show;
import domen.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.DBConnectionFactory;
import view.Upit;

/**
 *
 * @author aleks
 */
public class Broker {
    
    private Connection connection;
    

  
    
    
    
    
    
    public void connect() throws SQLException{
        if(connection == null || connection.isClosed()){
            try {
                String url = "jdbc:mysql://localhost:3306/psprojekat";//ime baze na crtu
                String username = "root";
                String password = "";
                connection = DriverManager.getConnection(url, username, password);
                connection.setAutoCommit(false);
                System.out.println("Uspena konekcija sa bazom");
            } catch (SQLException ex) {
                //Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
                throw ex;
            }
        }
    }
    
    public void disconnect() throws SQLException {
        if(connection != null){
            try {
                connection.close();
                System.out.println("Uspesno raskinuta konekcija");
            } catch (SQLException ex) {
                //Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
                throw ex;
            }
        }
    }
    
    public void commit() throws SQLException {
        if(connection != null){
            try {
                connection.commit();
            } catch (SQLException ex) {
                //Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
                throw ex;
            }
        }
    }
    
    public void rollback() throws SQLException{
        if(connection != null){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                //Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
                throw ex;
            }
        }
    }

    public List<Upit> vratiUpit() {
        List<Upit> data = new ArrayList<>();
        try {
            String upit = "SELECT shows.Hall, movie.Name, shows.Date, shows.TimeStart, shows.AvailableSeats FROM shows, movie WHERE movie.IdMovie = shows.IdMovie ORDER BY shows.TimeStart";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            rs.next();
            while (!rs.isAfterLast()) { 
                data.add(new Upit(rs.getString("Hall"), rs.getString("Name"), rs.getDate("Date"), rs.getTime("TimeStart"), rs.getInt("AvailableSeats")));
                rs.next();
            }
            rs.close();
            statement.close();
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public boolean register(User user) {
        try {
            String upit = "INSERT INTO user( Ime, Prezime, Username, Password) "
                    + "VALUES ('"+user.getName()+"','"+user.getLastname()+"','"+user.getUsername()+"','"+user.getPassword()+"')";
            Statement statement = connection.createStatement();
            statement.execute(upit);
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public User login(User user) {
        try {
            String upit = "SELECT * FROM user WHERE (Username = '"+user.getUsername()+"' AND Password = '"+user.getPassword()+"')";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            rs.next();
            user = new User(rs.getLong("IdUser"), rs.getString("Ime"), rs.getString("Prezime"), rs.getString("Username"), rs.getString("Password"));
            rs.close();
            statement.close();
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        try {    
            String upit = "SELECT * FROM movie";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            rs.next();
            while (!rs.isAfterLast()) {
                movies.add(new Movie(rs.getLong("IdMovie"), rs.getString("Name"), rs.getString("Description"), rs.getInt("Price"), rs.getTime("duration")));  
                rs.next();
            }
            rs.close();
            statement.close();
            return movies;
        } catch (SQLException ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return movies;
    }

    public List<Show> getAllShows(Show s) {
        List<Show> shows = new ArrayList<>();
        try {            
            String upit = "SELECT * FROM shows WHERE IdMovie = '"+s.getIdMovie()+"' AND Date = '"+s.getDate()+"'";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            if(rs.next() == false) return shows;
            while (!rs.isAfterLast()) {
                shows.add(new Show(rs.getLong("Id"), rs.getLong("IdMovie"), rs.getLong("IdHall"), rs.getDate("Date"), rs.getTime("TimeStart"), rs.getTime("TimeEnd"), rs.getInt("AvailableSeats"), rs.getString("Hall")));  
                rs.next();
            }
            rs.close();
            statement.close();
            return shows;
        } catch (SQLException ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return shows;
    }

    public void book(Booking booking) throws Exception {
        try {
            String upit = "INSERT INTO booking(Id, IdUser, amount, price, Movie, Hall, DateTime) "
                    + "VALUES ("
                    + "'"+booking.getIdShow()+"',"
                    + "'"+booking.getIdUser()+"',"
                    + "'"+booking.getAmount()+"',"
                    + "'"+booking.getPrice()+"',"
                    + "'"+booking.getMovie()+"',"
                    + "'"+booking.getHall()+"',"
                    + "'"+booking.getStart()+"');";
            String upit2 = "UPDATE shows SET AvailableSeats = AvailableSeats - '"+booking.getAmount()+"' WHERE Id = '"+booking.getIdShow()+"'";
            Statement statement = connection.createStatement();
            statement.execute(upit);
            statement.execute(upit2);
            statement.close();
        } catch (Exception ex) {
            //Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    public List<Booking> getAllBookings(User user) {
        List<Booking> bookings = new ArrayList<>();
        try {
            String upit = "SELECT * FROM booking WHERE IdUser = '"+user.getIdUser()+"'";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            if(rs.next() == false) return bookings;
            while (!rs.isAfterLast()) {                
                bookings.add(new Booking(rs.getLong("Id"), rs.getLong("IdUser"), rs.getInt("Amount"), rs.getInt("Price"), rs.getString("Movie"), rs.getString("Hall"), rs.getTimestamp("DateTime")));
                rs.next();
            }
            rs.close();
            statement.close();
            return bookings;
        } catch (SQLException ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bookings;
    }

    public void deleteBooking(Booking booking) {
        try {
            String upit = "DELETE FROM booking WHERE (Id = '"+booking.getIdShow()+"' AND IdUser = '"+booking.getIdUser()+"' AND DateTime = '"+booking.getStart()+"')";
            String upit2 = "UPDATE shows SET AvailableSeats = AvailableSeats + '"+booking.getAmount()+"' WHERE Id = '"+booking.getIdShow()+"'";
            Statement statement = connection.createStatement();
            statement.execute(upit);
            statement.execute(upit2);
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addMovie(Movie movie) {
        try {
            String upit = "INSERT INTO movie( Name, Description, price, duration) "
                    + "VALUES ('"+movie.getName()+"','"+movie.getDescription()+"','"+movie.getPrice()+"','"+movie.getDuration()+"')";
            Statement statement = connection.createStatement();
            statement.execute(upit);
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Hall> getAllHalls() {
        List<Hall> halls = new ArrayList<>();
        try {    
            String upit = "SELECT * FROM hall";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            rs.next();
            while (!rs.isAfterLast()) {
                halls.add(new Hall(rs.getLong("IdHall"), rs.getString("Name"), rs.getInt("Capacity")));  
                rs.next();
            }
            rs.close();
            statement.close();
            return halls;
        } catch (SQLException ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return halls;
    }

    public List<Show> getAllShows(Hall hall, Date date) {
        List<Show> shows = new ArrayList<>();
        try {            
            String upit = "SELECT * FROM shows WHERE (IdHall = '"+hall.getIdHall()+"' AND Date = '"+date+"')";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
           
            if(rs.next() == false) return shows;
            while (!rs.isAfterLast()) {
                shows.add(new Show(rs.getLong("Id"), rs.getLong("IdMovie"), rs.getLong("IdHall"), rs.getDate("Date"), rs.getTime("TimeStart"), rs.getTime("TimeEnd"), rs.getInt("AvailableSeats"), rs.getString("Hall")));  
                rs.next();
            }
            rs.close();
            statement.close();
            return shows;
        } catch (SQLException ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return shows;
    }

    public void addShow(Show show) {
        try {
            String upit = "INSERT INTO shows(IdMovie, IdHall, Date, TimeStart, TimeEnd, AvailableSeats, Hall)"
                    + "VALUES ("
                    + "'"+show.getIdMovie()+"',"
                    + "'"+show.getIdHall()+"',"
                    + "'"+show.getDate()+"',"
                    + "'"+show.getTimeStart()+"',"
                    + "'"+show.getTimeEnd()+"',"
                    + "'"+show.getAvailableSeats()+"',"
                    + "'"+show.getHall()+"')";
            Statement statement = connection.createStatement();
            statement.execute(upit);
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    
}
