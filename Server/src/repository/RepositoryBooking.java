/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import db.Broker;
import domen.Booking;
import domen.GenericEntity;
import domen.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aleks
 */
public class RepositoryBooking implements DBRepository<Booking, Long>{
    
    private Connection connection;
    
    /*public void deleteBooking(Booking booking) {
        try {
            String upit = "DELETE FROM booking WHERE (Id = '"+booking.getIdShow()+"' AND IdUser = '"+booking.getIdUser()+"' AND DateTime = '"+booking.getStart()+"')";
            String upit2 = "UPDATE shows SET AvailableSeats = AvailableSeats + '"+booking.getAmount()+"' WHERE Id = '"+booking.getIdShow()+"'";
            connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.execute(upit);
            statement.execute(upit2);
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    
    
    /*public void book(Booking booking) throws Exception {
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
            connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.execute(upit);
            statement.execute(upit2);
            statement.close();
        } catch (Exception ex) {
            //Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }*/
    
    
    public List<Booking> getAllBookings(User user) {
        List<Booking> bookings = new ArrayList<>();
        try {
            String upit = "SELECT * FROM booking WHERE IdUser = '"+user.getIdUser()+"'";
            connection = DBConnectionFactory.getInstance().getConnection();
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

   

    @Override
    public GenericEntity add(Booking booking) throws Exception {
        /*String upit = "INSERT INTO booking(Id, IdUser, amount, price, Movie, Hall, DateTime) "
                    + "VALUES ("
                    + "'"+booking.getIdShow()+"',"
                    + "'"+booking.getIdUser()+"',"
                    + "'"+booking.getAmount()+"',"
                    + "'"+booking.getPrice()+"',"
                    + "'"+booking.getMovie()+"',"
                    + "'"+booking.getHall()+"',"
                    + "'"+booking.getStart()+"');";
            String upit2 = "UPDATE shows SET AvailableSeats = AvailableSeats - '"+booking.getAmount()+"' WHERE Id = '"+booking.getIdShow()+"'";
            connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.execute(upit);
            statement.execute(upit2);
            statement.close();*/
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public void edit(Booking t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Booking booking) throws Exception {
        String upit = "DELETE FROM booking WHERE (Id = '"+booking.getIdShow()+"' AND IdUser = '"+booking.getIdUser()+"' AND DateTime = '"+booking.getStart()+"')";
            String upit2 = "UPDATE shows SET AvailableSeats = AvailableSeats + '"+booking.getAmount()+"' WHERE Id = '"+booking.getIdShow()+"'";
            connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.execute(upit);
            statement.execute(upit2);
            statement.close();
    }

    @Override
    public ResultSet getById(Booking b, Long k) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet getAll(Booking t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
