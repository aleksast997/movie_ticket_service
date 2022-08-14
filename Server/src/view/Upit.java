/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author aleks
 */
public class Upit {
    private String hall;
    private String movie;
    private Date date;
    private Time timeStart;
    private int AvailableSeats;

    public Upit() {
    }

    public Upit(String hall, String movie, Date date, Time timeStart, int AvailableSeats) {
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
    
    
    
}
