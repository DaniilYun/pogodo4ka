package com.popa.pogodo4ka.dao;

import com.popa.pogodo4ka.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserDao implements GenericDao<User>{
    private  static  List<User> users = new ArrayList<>();

 static {
     User i = new User("admin", "admin");
     User y = new User("user","user");
     User u = new User("valera", "valera");
     u.setRoot(true);
     users.add(i);
     users.add(y);
     users.add(u);
 }

    @Override
    public void add(User object) {
        users.add(object);
    }

    @Override
    public void update(User object) {
        for (User s:users) {
            if (s.getName().equals(object.getName())){
                s.setPassword(object.getPassword());
                s.setRoot(object.isRoot());
            }
        }
    }

    @Override
    public void delete(User object) {
        for (User s:users) {
            if (s.getName().equals(object.getName())){
                users.remove(s);
            }
        }
    }

    public List<User> getAll() {
        return users;
    }

    public User getUserByKey(String name){
        for (User s:users) {
            if (s.getName().equals(name)){
                return s;
            }
        }return null;
    }
}
