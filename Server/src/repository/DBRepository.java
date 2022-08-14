/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.sql.SQLException;

/**
 *
 * @author aleks
 */
public interface  DBRepository<T, K> extends Repository<T, K>{
    
    default public void connect() throws SQLException{
        DBConnectionFactory.getInstance().getConnection();
    }
    
    default  public void disconnect() throws SQLException {
        DBConnectionFactory.getInstance().getConnection().close();
    }
    
    default public void commit() throws SQLException{
        DBConnectionFactory.getInstance().getConnection().commit();
    }
    
    default public void rollback() throws SQLException {
    DBConnectionFactory.getInstance().getConnection().rollback();
    }
    
}
