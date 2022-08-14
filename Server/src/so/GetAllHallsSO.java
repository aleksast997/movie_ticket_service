/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Hall;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleks
 */
public class GetAllHallsSO extends AbstractSO{
    
    @Override
    protected void precondition(Object param) throws Exception {
    }

    @Override
    protected Object executeOperation(Object param) throws Exception {
        List<Hall> halls = new ArrayList<>();
        ResultSet rs = repository.getAll((Hall)param);
        while (rs.next()) {
            halls.add(new Hall(rs.getLong("IdHall"), rs.getString("Name"), rs.getInt("Capacity")));
        }
        return halls;
    }
    
}
