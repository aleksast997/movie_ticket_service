/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Show;

/**
 *
 * @author aleks
 */
public class AddShowSO extends AbstractSO{

    @Override
    protected void precondition(Object param) throws Exception {
        if(param == null || !(param instanceof Show)){
            throw new Exception("Null show!!!");
        }
        Show show = (Show) param;
        if(show.getDate() == null || show.getIdMovie() == null || show.getIdHall() == null){
            throw new Exception("Wrong show");
        }
    }

    @Override
    protected Object executeOperation(Object param) throws Exception {
        repository.add((Show)param);
        return param;
    }
    
    
}
