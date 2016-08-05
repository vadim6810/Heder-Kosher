package com.tel_ran.hederkosher.model.security.dao;

import com.tel_ran.hederkosher.model.security.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Igor on 05.08.2016.
 */
public class UserDAOImplTest implements UserDAO{

    private static final AtomicLong counter = new AtomicLong();

    private static List<User> users;

    static{
        users= populateDummyUsers();
    }


    @Override
    public User findByID(long id) {
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    @Override
    public User findByMail(String mail) {
        for(User user : users){
            if(user.getEmail().equalsIgnoreCase(mail)){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAllUser() {
        return users;
    }

    @Override
    public boolean isUserExist(User user) {
        return users.contains(user);
    }

    @Override
    public boolean createUser(User user) {
        user.setId(counter.incrementAndGet());
        users.add(user);
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        int index = users.indexOf(user);
        users.set(index, user);
        return true;
    }

    @Override
    public boolean deleteUser(long id) {
        boolean result = false;
        for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                result = true;
            }
        }
        return result;
    }

    private static List<User> populateDummyUsers(){
        List<User> users = new ArrayList<User>();
        users.add(new User(counter.incrementAndGet(),"Sam", "123qwe", new Date()));
        users.add(new User(counter.incrementAndGet(),"Tom", "qweasd", new Date()));
        users.add(new User(counter.incrementAndGet(),"Jerome", "asdzxc", new Date()));
        users.add(new User(counter.incrementAndGet(),"Silvia", "zxc123", new Date()));
        return users;
    }
}
