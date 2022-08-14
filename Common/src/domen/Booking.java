/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author aleks
 */
public class Booking implements GenericEntity{
    
    private Long idShow;
    private Long idUser;
    private int amount;
    private double price;
    private String movie;
    private String hall;
    private Timestamp start;

    public Booking() {
    }

    public Booking(Long idShow, Long idUser, int amount, double price, String movie, String hall, Timestamp start) {
        this.idShow = idShow;
        this.idUser = idUser;
        this.amount = amount;
        this.price = price;
        this.movie = movie;
        this.hall = hall;
        this.start = start;
    }

    public Long getIdShow() {
        return idShow;
    }

    public void setIdShow(Long idShow) {
        this.idShow = idShow;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    @Override
    public String getTableName() {
        return "booking";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "Id,IdUser,amount,price,Movie,Hall,DateTime";
    }

    @Override
    public String getInesrtValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(getIdShow()).append("'")
                .append(",").append("'").append(getIdUser()).append("'")
                .append(",").append("'").append(getAmount()).append("'")
                .append(",").append("'").append(getPrice()).append("'")
                .append(",").append("'").append(getMovie()).append("'")
                .append(",").append("'").append(getHall()).append("'")
                .append(",").append("'").append(getStart()).append("'");
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
        return String.format("Id = %d AND IdUser = %d", idShow, idUser);
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
