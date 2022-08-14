/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Query;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleks
 */
public class GetQuerySO extends AbstractSO{

    @Override
    protected void precondition(Object param) throws Exception {
    }

    @Override
    protected Object executeOperation(Object param) throws Exception {
        List<Query> data = new ArrayList<>();
        ResultSet rs = repository.getAll((Query)param);
        while (rs.next()) {
            data.add(new Query(rs.getString("Hall"), 
                    rs.getString("Name"), 
                    rs.getDate("Date"), 
                    rs.getTime("TimeStart"), 
                    rs.getInt("AvailableSeats")));
            
        }
        return data;
    }
    
}
