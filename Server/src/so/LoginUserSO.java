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
public class LoginUserSO extends AbstractSO{
    
    @Override
    protected void precondition(Object param) throws Exception{
        if(param == null || !(param instanceof User)){
            throw new Exception("Invalid user!");
        }
        //provera vrednostnih ogranicenja
        User user = (User) param;
        if(user.getUsername().isEmpty()){
            throw new Exception("Username is empty");
        }
    }

    @Override
    protected Object executeOperation(Object param) throws Exception{
        List<User> users = new ArrayList<>();
        User user = (User)param;
        ResultSet rs = repository.getAll((User)param);
        while (rs.next()) {
            users.add(new User(rs.getLong("IdUser"), rs.getString("Name"), rs.getString("Lastname"), rs.getString("Username"), rs.getString("Password")));          
        }
        for(User u : users){
            if(u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())){
                return u;
            }
        }
        throw new Exception("User not found!");
    }

    
    
    
    
}
