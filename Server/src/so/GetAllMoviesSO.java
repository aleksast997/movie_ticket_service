/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Movie;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import repository.RepositoryMovie;

/**
 *
 * @author aleks
 */
public class GetAllMoviesSO extends AbstractSO{
    

    @Override
    protected void precondition(Object param) throws Exception {
    }

    @Override
    protected Object executeOperation(Object param) throws Exception {
        List<Movie> movies = new ArrayList<>();
        ResultSet rs = repository.getAll((Movie)param);
        while (rs.next()) {
            movies.add(new Movie(rs.getLong("IdMovie"), rs.getString("Name"), rs.getString("Description"), rs.getDouble("price"), rs.getTime("duration")));
        }
        return movies;
    }
    
}
