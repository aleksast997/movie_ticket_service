/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.User;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import repository.RepositoryUser;

/**
 *
 * @author aleks
 */
public class RegisterUserSO extends AbstractSO{
    
    

    @Override
    protected void precondition(Object param) throws Exception {
        if(param == null || !(param instanceof User)){
            throw new Exception("Invalid user!");
        }
        User user = (User)param;
        if(user.getName().isEmpty() || user.getLastname().isEmpty() || user.getUsername().isEmpty() || user.getPassword().isEmpty()){
            throw new Exception("Invalid user atributes!");
        }
    }

    @Override
    protected Object executeOperation(Object param) throws Exception {
        User user = (User) param;
        ResultSet rs = repository.getAll(new User());
        while(rs.next()){
            if(rs.getString("username").equals(user.getUsername())){
                throw new Exception("This user allready exist!");
            }
        }
        repository.add((User)param);
        return param;
        
        /*if(storageUser.register((User)param)) return param;
        return null;*/
    }

   
    
    
    
}
