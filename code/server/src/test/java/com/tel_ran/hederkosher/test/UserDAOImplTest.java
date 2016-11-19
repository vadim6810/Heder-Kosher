package com.tel_ran.hederkosher.test;

import com.tel_ran.hederkosher.model.common.entity.Room;
import com.tel_ran.hederkosher.model.security.dao.RoleDAO;
import com.tel_ran.hederkosher.model.security.dao.UserDAO;
import com.tel_ran.hederkosher.model.security.entity.Role;
import com.tel_ran.hederkosher.model.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Igor on 05.08.2016.
 */

public class UserDAOImplTest implements UserDAO {

    private static final AtomicLong COUNTER = new AtomicLong();

    private static List<User> users;

    @Autowired
    private RoleDAO roleDAO;

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

    public boolean isUserExist(User user) {
        return users.contains(user);
    }

    @Override
    public boolean createUser(User user) {
        user.setId(COUNTER.incrementAndGet());
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

    @PostConstruct
    private List<User> populateDummyUsers(){
        users = new ArrayList<>();

        Role roleAdmin = roleDAO.findByName("ADMIN");
        Role roleManager = roleDAO.findByName("MANAGER");
        Role roleTrainer = roleDAO.findByName("TRAINER");
        Role roleClient = roleDAO.findByName("CLIENT");

        Room gym = new Room(); gym.setName("Gym");
        Room pool = new Room(); pool.setName("Pool");
        Room sauna = new Room(); sauna.setName("Sauna");

        User sam = new User(COUNTER.incrementAndGet(),"Sam@hk.co.il", "123qwe", new Date());
        sam.setRole(gym, roleAdmin);
        users.add(sam);

        User tom = new User(COUNTER.incrementAndGet(),"Tom@hk.co.il", "qweasd", new Date());
        tom.setRole(gym, roleManager);
        tom.setRole(pool, roleTrainer);
        users.add(tom);

        User jerome = new User(COUNTER.incrementAndGet(),"Jerome@hk.co.il", "asdzxc", new Date());
        jerome.setRole(sauna, roleManager);
        jerome.setRole(pool, roleTrainer);
        users.add(jerome);

        User silvia = new User(COUNTER.incrementAndGet(),"Silvia@hk.co.il", "zxc123", new Date());
        silvia.setRole(gym, roleClient);
        silvia.setRole(pool, roleClient);
        silvia.setRole(sauna, roleClient);
        users.add(silvia);

        return users;
    }
}
