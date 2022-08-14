/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author aleks
 */
public class Query implements GenericEntity{
    
    private String hall;
    private String movie;
    private Date date;
    private Time timeStart;
    private int AvailableSeats;

    public Query() {
    }

    public Query(String hall, String movie, Date date, Time timeStart, int AvailableSeats) {
        this.hall = hall;
        this.movie = movie;
        this.date = date;
        this.timeStart = timeStart;
        this.AvailableSeats = AvailableSeats;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Time timeStart) {
        this.timeStart = timeStart;
    }

    public int getAvailableSeats() {
        return AvailableSeats;
    }

    public void setAvailableSeats(int AvailableSeats) {
        this.AvailableSeats = AvailableSeats;
    }

    @Override
    public String getTableName() {
        return "shows, movie WHERE movie.IdMovie = shows.IdMovie ORDER BY shows.TimeStart";
    }

    @Override
    public String getColumnNamesForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getInesrtValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getKeyName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSetForUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getRowById() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSpecialQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColNames() {
        return "shows.Hall, movie.Name, shows.Date, shows.TimeStart, shows.AvailableSeats";
    }
    
}
