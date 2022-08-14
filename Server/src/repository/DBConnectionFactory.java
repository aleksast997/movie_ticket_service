/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aleks
 */
public class DBConnectionFactory {
    
    private Connection connection;
    private static DBConnectionFactory instance;

    public DBConnectionFactory() {
    }
    
    
    
    public static DBConnectionFactory getInstance(){
        if(instance == null){
            instance = new DBConnectionFactory();
        }
        return instance;
    }

    
    
    
    
    public Connection getConnection() throws SQLException{
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
        return connection;
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
}
