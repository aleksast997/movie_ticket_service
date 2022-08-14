/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Booking;
import domen.Show;
import java.sql.ResultSet;

/**
 *
 * @author aleks
 */
public class DeleteBookingSO extends AbstractSO{

    @Override
    protected void precondition(Object param) throws Exception {
    }

    @Override
    protected Object executeOperation(Object param) throws Exception {
        Booking booking = (Booking) param;
        System.out.println("bok3");
        repository.delete((Booking)param);
        System.out.println("bok4");
        ResultSet rs = repository.getById(new Show(), booking.getIdShow());
        rs.next();
        Show s = new Show(rs.getLong("Id"), 
                        rs.getLong("IdMovie"), 
                        rs.getLong("IdHall"), 
                        rs.getDate("Date"), 
                        rs.getTime("TimeStart"), 
                        rs.getTime("TimeEnd"), 
                        rs.getInt("AvailableSeats"), 
                        rs.getString("Hall"));
        s.setAvailableSeats(s.getAvailableSeats()+booking.getAmount());
        System.out.println("mesta"+s.getAvailableSeats());
        repository.edit(s);
        return param;
    }
    
}
