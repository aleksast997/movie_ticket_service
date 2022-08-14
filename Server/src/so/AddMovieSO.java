/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Movie;
import java.sql.ResultSet;

/**
 *
 * @author aleks
 */
public class AddMovieSO extends AbstractSO{

    @Override
    protected void precondition(Object param) throws Exception {
        if(param == null || !(param instanceof Movie)){
            throw new Exception("Not movie object!");
        }
        Movie movie = (Movie) param;
        if(movie.getName().isEmpty() || movie.getDescription().isEmpty() || movie.getDuration().getTime() < 1800000){
            throw new Exception("Not valid movie");
        }
    }

    @Override
    protected Object executeOperation(Object param) throws Exception {
        Movie movie = (Movie) param;
        ResultSet rs = repository.getAll((Movie)param);
        while (rs.next()) {
            if(rs.getString("Name").equals(movie.getName())){
                throw new Exception("This movie exists!");
            }
            
        }
        repository.add((Movie)param);
        return param;
    }
    
}
