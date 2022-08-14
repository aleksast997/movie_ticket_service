    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import domen.GenericEntity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleks
 */
public class RepositoryDBGeneric implements DBRepository<GenericEntity, Long>{

    @Override
    public ResultSet getAll(GenericEntity entity) throws Exception {
        //List<GenericEntity> all = new ArrayList<>();
        try {
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT ").append(entity.getColNames()).append(" FROM ")
                    .append(entity.getTableName());
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            //System.out.println(entity.toString());
            return rs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public GenericEntity add(GenericEntity entity) throws Exception {
        try {
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ")
                    .append(entity.getTableName())
                    .append("(")
                    .append(entity.getColumnNamesForInsert())
                    .append(")")
                    .append("VALUES (")
                    .append(entity.getInesrtValues())
                    .append(")");
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            //ResultSet rs = statement.getGeneratedKeys();
            /*if(rs.next()){
                Long id = rs.getLong(1);
                entity.setId(id);
            }
            statement.close();
            rs.close();*/
            //System.out.println(entity.toString());
            return entity;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void edit(GenericEntity entity) throws Exception {
        Connection connection = DBConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE ")
                    .append(entity.getTableName())
                    .append(" SET ")
                    .append(entity.getSetForUpdate())
                    .append(" WHERE ")
                    .append(entity.getRowById());
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
    }

    @Override
    public void delete(GenericEntity entity) throws Exception {
        Connection connection = DBConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM ")
                    .append(entity.getTableName())
                    .append(" WHERE ")
                    .append(entity.getRowById());
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
    }

    @Override
    public ResultSet getById(GenericEntity entity, Long k) throws Exception {
        try {
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM  ")
                    .append(entity.getTableName())
                    .append(" WHERE ").append(entity.getKeyName())
                    .append(" = '").append(k.toString()).append("'");
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            //System.out.println(entity.toString());
            return rs;
        } catch (Exception e) {
            throw e;
        }
    }
    
}
