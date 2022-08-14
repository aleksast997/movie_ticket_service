/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author aleks
 */
public class User implements GenericEntity{
    private Long idUser;
    private String name;
    private String lastname;
    private String username;
    private String password;
    

    public User() {
    }

    public User(Long idUser, String ime, String prezime, String username, String password) {
        this.idUser = idUser;
        this.name = ime;
        this.lastname = prezime;
        this.username = username;
        this.password = password;
        
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return name +" "+ lastname;
    }

    @Override
    public String getTableName() {
        return "user";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "Name,Lastname,Username,Password";
    }

    @Override
    public String getInesrtValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(name).append("'")
                .append(",").append("'").append(lastname).append("'")
                .append(",").append("'").append(username).append("'")
                .append(",").append("'").append(password).append("'");
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
