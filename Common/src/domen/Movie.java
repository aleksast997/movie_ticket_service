/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.Time;

/**
 *
 * @author aleks
 */
public class Movie implements GenericEntity{
    
    private Long idMovie;
    private String name;
    private String description;
    private double price;
    private Time duration;

    public Movie() {
    }

    public Movie(Long idMovie, String name, String description, double price, Time duration) {
        this.idMovie = idMovie;
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration = duration;
    }

    public Long getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Long idMovie) {
        this.idMovie = idMovie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    @Override
    public String getTableName() {
        return "movie";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "Name,Description,price,duration";
    }

    @Override
    public String getInesrtValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(name).append("'")
                .append(",").append("'").append(description).append("'")
                .append(",").append("'").append(price).append("'")
                .append(",").append("'").append(duration).append("'");
        return sb.toString();
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
        return "";
    }

    @Override
    public String getColNames() {
        return "*";
    }
    
    
    
    
}
