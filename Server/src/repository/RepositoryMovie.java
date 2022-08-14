/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import db.Broker;
import domen.GenericEntity;
import domen.Movie;
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
public class RepositoryMovie implements DBRepository<Movie, Long> {
    
    private Connection connection;
    
   /* public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        try {    
            String upit = "SELECT * FROM movie";
            connection = DBConnectionFactory.getInstance().getConnection();
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
    }*/
    
     /*public void addMovie(Movie movie) {
        try {
            String upit = "INSERT INTO movie( Name, Description, price, duration) "
                    + "VALUES ('"+movie.getName()+"','"+movie.getDescription()+"','"+movie.getPrice()+"','"+movie.getDuration()+"')";
            connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.execute(upit);
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

    public List<Movie> getAll() throws Exception {
        List<Movie> movies = new ArrayList<>();

        String upit = "SELECT * FROM movie";
        connection = DBConnectionFactory.getInstance().getConnection();
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

    }

    @Override
    public GenericEntity add(Movie t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Movie movie) throws Exception {
        String upit = "INSERT INTO movie( Name, Description, price, duration) "
                    + "VALUES ('"+movie.getName()+"','"+movie.getDescription()+"','"+movie.getPrice()+"','"+movie.getDuration()+"')";
            connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.execute(upit);
            statement.close();
    }

    @Override
    public void delete(Movie t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet getById(Movie m ,Long k) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet getAll(Movie t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
