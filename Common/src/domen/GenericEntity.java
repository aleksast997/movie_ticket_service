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
public interface  GenericEntity extends Serializable{

    public String getTableName();

    public String getColumnNamesForInsert();

    public String getInesrtValues();

    public void setId(Long id);
    
    public String getKeyName();

    public String getSetForUpdate();
    
    public String getRowById();
    
    public String getSpecialQuery();
    
    public String getColNames();
   
    
}
