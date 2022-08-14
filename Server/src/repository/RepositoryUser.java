/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import db.Broker;
import domen.GenericEntity;
import domen.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aleks
 */
public class RepositoryUser implements  DBRepository<User, Long>{
    
    private Connection connection;
    
    public boolean register(User user) {
        try {
            connection = DBConnectionFactory.getInstance().getConnection();
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

    public User login(User user) throws SQLException {
        try {
            String upit = "SELECT * FROM user WHERE (Username = '"+user.getUsername()+"' AND Password = '"+user.getPassword()+"')";
            System.out.println("ovde3");
            connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            System.out.println("ovde4");
            ResultSet rs = statement.executeQuery(upit);
            rs.next();
            user = new User(rs.getLong("IdUser"), rs.getString("Ime"), rs.getString("Prezime"), rs.getString("Username"), rs.getString("Password"));
            rs.close();
            statement.close();
            return user;
        } catch (Exception ex) {
            //Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

   

    @Override
    public GenericEntity add(User t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(User t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(User t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet getById(User u, Long k) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet getAll(User t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
