/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Booking;
import domen.User;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleks
 */
public class GetAllBookings extends AbstractSO{

    @Override
    protected void precondition(Object param) throws Exception {
    }

    @Override
    protected Object executeOperation(Object param) throws Exception {
        User user = (User)param;
        List<Booking> bookings = new ArrayList<>();
        ResultSet rs = repository.getAll(new Booking());
        while (rs.next()) {
            if(rs.getLong("IdUser") == user.getIdUser()){
                bookings.add(new Booking(rs.getLong("Id"), rs.getLong("IdUser"), rs.getInt("Amount"), rs.getInt("Price"), rs.getString("Movie"), rs.getString("Hall"), rs.getTimestamp("DateTime")));
            }
        }
        return bookings;
    }
    
}
