/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import domen.GenericEntity;
import java.sql.ResultSet;

/**
 *
 * @author aleks
 */
public interface Repository<T, K> {
    ResultSet getAll(T t) throws Exception;
    GenericEntity add(T t) throws Exception;
    void edit(T t) throws Exception;
    void delete(T t) throws Exception;
    ResultSet getById(T t, K k) throws Exception;
}
