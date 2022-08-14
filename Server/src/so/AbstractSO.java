/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Hall;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import repository.DBRepository;
import repository.Repository;
import repository.RepositoryDBGeneric;
import view.Upit;

/**
 *
 * @author aleks
 */
public abstract class AbstractSO {
    
    protected final Repository repository;

    public AbstractSO() {
        this.repository = new RepositoryDBGeneric();
    }
    
    public Object execute(Object param) throws Exception {
        try {
            Object o = null;
            precondition(param);
            startTransaction();
            o = executeOperation(param);
            commitTransaction();
            return o;
        } catch (Exception ex) {
            rollbackTransaction();
            throw ex;
        }
    }

    protected abstract void precondition(Object param) throws Exception;

    private void startTransaction() throws SQLException {
        ((DBRepository)repository).connect();
    }

    protected abstract Object executeOperation(Object param) throws Exception;

    protected  void commitTransaction() throws Exception{
        ((DBRepository)repository).commit();
    }

    protected  void rollbackTransaction() throws Exception{
        ((DBRepository)repository).rollback();
    }

    
}
