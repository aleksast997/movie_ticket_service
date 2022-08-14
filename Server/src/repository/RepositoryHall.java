/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import domen.GenericEntity;
import domen.Hall;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleks
 */
public class RepositoryHall implements DBRepository{ 
    
    private Connection connection;
    
    /*public List<Hall> getAllHalls() {
        List<Hall> halls = new ArrayList<>();
        try {    
            String upit = "SELECT * FROM hall";
            connection = DBConnectionFactory.getInstance().getConnection();
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
    }*/

    public List getAll() throws Exception {
        List<Hall> halls = new ArrayList<>();
        String upit = "SELECT * FROM hall";
        connection = DBConnectionFactory.getInstance().getConnection();
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
    }

    @Override
    public GenericEntity add(Object t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Object t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet getById(Object o, Object k) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet getAll(Object t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
