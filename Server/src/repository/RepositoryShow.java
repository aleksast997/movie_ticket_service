/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import db.Broker;
import domen.GenericEntity;
import domen.Hall;
import domen.Show;
import java.sql.Connection;
import java.sql.Date;
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
public class RepositoryShow implements DBRepository<Show, Long> {
    
    private Connection connection;
    
    public List<Show> getAllShows(Show s) {
        List<Show> shows = new ArrayList<>();
        try {            
            String upit = "SELECT * FROM shows WHERE IdMovie = '"+s.getIdMovie()+"' AND Date = '"+s.getDate()+"'";
            connection = DBConnectionFactory.getInstance().getConnection();
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
    
    public List<Show> getAllShows(Hall hall, Date date) {
        List<Show> shows = new ArrayList<>();
        try {            
            String upit = "SELECT * FROM shows WHERE (IdHall = '"+hall.getIdHall()+"' AND Date = '"+date+"')";
            connection = DBConnectionFactory.getInstance().getConnection();
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
    
    /*public void addShow(Show show) {
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
            connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.execute(upit);
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

   

    @Override
    public GenericEntity add(Show show) throws Exception {
        /*String upit = "INSERT INTO shows(IdMovie, IdHall, Date, TimeStart, TimeEnd, AvailableSeats, Hall)"
                    + "VALUES ("
                    + "'"+show.getIdMovie()+"',"
                    + "'"+show.getIdHall()+"',"
                    + "'"+show.getDate()+"',"
                    + "'"+show.getTimeStart()+"',"
                    + "'"+show.getTimeEnd()+"',"
                    + "'"+show.getAvailableSeats()+"',"
                    + "'"+show.getHall()+"')";
            connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.execute(upit);
            statement.close();*/
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public void edit(Show t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Show t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet getById(Show s, Long k) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public ResultSet getAll(Show t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
