/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Show;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleks
 */
public class GetAllShows extends AbstractSO{

    @Override
    protected void precondition(Object param) throws Exception {
        
        if(param == null || !(param instanceof Show)){
            throw new Exception("Null show!!!");
        }
        
        
    }

    @Override
    protected Object executeOperation(Object param) throws Exception {
        Show show = (Show) param;
        List<Show> shows = new ArrayList<>();
        ResultSet rs = repository.getAll((Show)param);
        while (rs.next()) {
            if(rs.getLong("IdHall") == show.getIdHall() && rs.getDate("Date").equals(show.getDate())){
                shows.add(new Show(rs.getLong("Id"), rs.getLong("IdMovie"), rs.getLong("IdHall"), rs.getDate("Date"), rs.getTime("TimeStart"), rs.getTime("TimeEnd"), rs.getInt("AvailableSeats"), rs.getString("Hall")));
            }
        }
        return shows;
    }
    
}
