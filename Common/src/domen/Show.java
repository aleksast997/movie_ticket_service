/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author aleks
 */
public class Show implements GenericEntity{
    
    private Long idShow;
    private Long idMovie;
    private Long idHall;
    private Date date;
    private Time timeStart;
    private Time timeEnd;
    private int availableSeats;
    private String hall;

    public Show() {
    }

    public Show(Long idMovie, Date start) {
        this.idMovie = idMovie;
        this.date = start;
    }

    public Show(Long idShow, int availableSeats) {
        this.idShow = idShow;
        this.availableSeats = availableSeats;
    }
    
    

    public Show(Long idShow, Long idMovie, Long idHall, Date date, Time timeStart, Time timeEnd, int availableSeats, String hall) {
        this.idShow = idShow;
        this.idMovie = idMovie;
        this.idHall = idHall;
        this.date = date;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.availableSeats = availableSeats;
        this.hall = hall;
    }

    public Long getId() {
        return idShow;
    }

    public void setId(Long id) {
        this.idShow = id;
    }

    public Long getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Long idMovie) {
        this.idMovie = idMovie;
    }

    public Long getIdHall() {
        return idHall;
    }

    public void setIdHall(Long idHall) {
        this.idHall = idHall;
    }

    public Long getIdShow() {
        return idShow;
    }

    public void setIdShow(Long idShow) {
        this.idShow = idShow;
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

    public Time getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Time timeEnd) {
        this.timeEnd = timeEnd;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    @Override
    public String getTableName() {
        return "shows";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "IdMovie,IdHall,Date,TimeStart,TimeEnd,AvailableSeats,Hall";
    }

    @Override
    public String getInesrtValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(getIdMovie()).append("'")
                .append(",").append("'").append(getIdHall()).append("'")
                .append(",").append("'").append(getDate()).append("'")
                .append(",").append("'").append(getTimeStart()).append("'")
                .append(",").append("'").append(getTimeEnd()).append("'")
                .append(",").append("'").append(getAvailableSeats()).append("'")
                .append(",").append("'").append(getHall()).append("'");
        return sb.toString();    
    }

    @Override
    public String getKeyName() {
        return "Id";
    }

    @Override
    public String getSetForUpdate() {
        return String.format("AvailableSeats = %d", availableSeats);
    }
    
    @Override
    public String getRowById(){
        return String.format("Id = %d", idShow);
    }

    @Override
    public String getSpecialQuery() {
        return String.format(" WHERE (IdHall = %d AND Date = M/d/yyyy)", idHall, date);
    }

    @Override
    public String getColNames() {
        return "*";
    }

    
    
}
