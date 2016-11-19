/**
 * Created by Ruslan on 31.08.2016.
 */

package com.tel_ran.hederkosher.model.common.dao.implementation;

import com.tel_ran.hederkosher.exception.TemplateNotFoundException;
import com.tel_ran.hederkosher.model.common.dao.IMessageDao;
import com.tel_ran.hederkosher.model.common.dao.IRoomDao;
import com.tel_ran.hederkosher.model.common.entity.Message;
import com.tel_ran.hederkosher.model.common.entity.Room;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MessageDaoImpl implements IMessageDao {

    @PersistenceContext(name = "HKSpringHibernate")    //@PersistenceContext
    EntityManager em;

    public MessageDaoImpl() {
    }

    @Override
    @Transactional
    public boolean addMessage(Message message) {
        if ((message==null) || (em.find(Message.class,message.getId())!=null))
            return false;
        em.persist(message);
        return true;
    }

    @Override
    @Transactional
    public boolean updateMessage(Message message) {
        if ((message==null) || (em.find(Message.class,message.getId())==null))
            return false;

        em.persist(message);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteMessage(long id)  {
        Message message =em.find(Message.class,id);
            if (message==null)
                return false;
            em.remove(message);
            return true;
        }

    @Override
    public Message getById(long id) throws TemplateNotFoundException {
        Message message = em.find(Message.class,id);
        if (message==null)
            throw new TemplateNotFoundException("Message",id);
        return message;
    }

    @Override
    public List<Message> getByLikeName(String name) {
        List<Message> message=null;

        if (name!=null)
            try{
                message = (List<Message>) em.createQuery("SELECT p FROM Message p WHERE name like :name")
                        .setParameter("name", name);
            } catch (Exception e){
            }

        return message;
    }

    @Override
    public List<Message> getAllMessages(){
        List<Message> message=null;

        try{
            message = (List<Message>) em.createQuery("SELECT p FROM Message p");
        } catch (Exception e){
        }

        return message;
    }

    @Override
    public List<Message> getAllMessagesActives() {
        List<Message> message=null;

        try{
            message = (List<Message>) em.createQuery("SELECT p FROM Message p where isEnable is true ");
        } catch (Exception e){
        }

        return message;
    }

    @Override
    public List<Message> getByState(String name) {
        return null;
    }

    @Override
    public List<Message> getByType(String name) {
        return null;
    }

    @Override
    public List<Message> getByProgram(long id) {
        return null;
    }

    @Override
    public List<Message> getByTask(long id) {
        return null;
    }

    @Override
    public List<Message> getByUserFrom(long id) {
        return null;
    }


}

