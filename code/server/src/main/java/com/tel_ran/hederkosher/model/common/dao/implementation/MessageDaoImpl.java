/**
 * Created by Ruslan on 31.08.2016.
 */

package com.tel_ran.hederkosher.model.common.dao.implementation;

import com.tel_ran.hederkosher.exception.TemplateNotFoundException;
import com.tel_ran.hederkosher.model.common.dao.MessageDao;
import com.tel_ran.hederkosher.model.common.entity.*;
import com.tel_ran.hederkosher.model.security.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MessageDaoImpl implements MessageDao {

    @PersistenceContext(name = "HKSpringHibernate")    //@PersistenceContext
    EntityManager em;

    public MessageDaoImpl() {
    }

    @Override
    @Transactional
    public boolean addMessage(Message message,Long idProgram, Long idTask, Long idUser) {
        if ((message==null) || (em.find(Message.class,message.getId())!=null))
            return false;
        Program program;
        Task task;
        User user;
        if ((idProgram!=null) && ((program=em.find(Program.class,idProgram))!=null)) {
            message.setProgram(program);
        }
        if ((idTask!=null) && ((task=em.find(Task.class,idTask))!=null)) {
            message.setTask(task);
        }
        if ((idUser!=null) && ((user=em.find(User.class,idUser))!=null)) {
            message.setUserFrom(user);
        }

        em.persist(message);
        return true;
    }

    @Override
    @Transactional
    public boolean updateMessage(Message message) {
        if ((message==null) || (em.find(Message.class,message.getId())==null))
            return false;

        em.merge(message);
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
    public List<Message> getMessagesByLikeName(String name) {
        List<Message> message=null;

        if (name!=null)
            try{
                message = (List<Message>) em.createQuery("SELECT p FROM Message p WHERE p.text like :name")
                        .setParameter("name", "%"+name+"%")
                        .getResultList();
            } catch (Exception e){
            }

        return message;
    }

    @Override
    public List<Message> getAllMessages(){
        List<Message> message=null;

        try{
            message = (List<Message>) em.createQuery("SELECT p FROM Message p")
                    .getResultList();
        } catch (Exception e){
        }

        return message;
    }

    @Override
    public List<Message> getAllMessagesActives() {
        List<Message> message=null;

        try{
            message = (List<Message>) em.createQuery("SELECT p FROM Message p where enable is true ")
                    .getResultList();
        } catch (Exception e){
        }

        return message;
    }

    @Override
    @Transactional
    public boolean deleteAllMessages()  {
        try{
            List<Message> messages = (List<Message>) em.createQuery("SELECT p FROM Message p")
                    .getResultList();
            for (Message message: messages) {
                em.remove(message);
            }
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<Message> getMessagesByState(String name) {
        List<Message> messages=null;
        if (name!=null && MessageState.valueOf(name)!=null)
            try{
                messages = (List<Message>) em.createQuery("SELECT p FROM Message p WHERE p.state = :name")
                        .setParameter("name", MessageState.valueOf(name))
                        .getResultList();
            } catch (Exception e){
            }
        return messages;
    }

    @Override
    public List<Message> getMessagesByType(String name) {
        List<Message> messages=null;
        if (name!=null && MessageType.valueOf(name)!=null)
            try{
                messages = (List<Message>) em.createQuery("SELECT p FROM Message p WHERE p.type = :name")
                        .setParameter("name", MessageType.valueOf(name))
                        .getResultList();
            } catch (Exception e){
            }
        return messages;
    }

    @Override
    public List<Message> getMessagesByProgram(long programId) {
        List<Message> messages=null;
        try{
            messages = (List<Message>) em.createQuery("SELECT m FROM Message m WHERE m.program.id = :programId")
                    .setParameter("programId", programId)
                    .getResultList();
        } catch (Exception e){
        }
        return messages;
    }

    @Override
    @Transactional
    public boolean deleteMessagesByProgram(long idProgram) {
// now not method   program.setMessage !
//        Program program= em.find(Program.class,idProgram);
//        if (program==null) return false;
//        em.refresh(program);
//        program.setMessage(null);
//        return true;

// that not to been
       List<Message> messages = getMessagesByProgram(idProgram);
        if (messages == null) return false;
        try{
            for (Message message : messages) {
                em.remove(message);
            }
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<Message> getMessagesByTask(long idTask) {
        List<Message> messages=null;
        try{
            messages = (List<Message>) em.createQuery("SELECT m FROM Message m WHERE m.task.id = :idTask")
                    .setParameter("idTask", idTask)
                    .getResultList();
        } catch (Exception e){
        }
        return messages;
    }

    @Transactional
    @Override
    public boolean deleteMessagesByTask(long idTask) {
        List<Message> messages = getMessagesByTask(idTask);
        if (messages == null) return false;
        try{
            for (Message message : messages) {
                em.remove(message);
            }
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<Message> getMessagesByUserFrom(long idUser) {
        List<Message> messages=null;
        try{
            messages = (List<Message>) em.createQuery("SELECT m FROM Message m WHERE m.userFrom.id = :idUser")
                    .setParameter("idUser", idUser)
                    .getResultList();
        } catch (Exception e){
        }
        return messages;
    }

    @Transactional
    @Override
    public boolean deleteMessagesByUserFrom(long idUser) {
        List<Message> messages = getMessagesByUserFrom(idUser);
        if (messages == null) return false;
        try{
            for (Message message : messages) {
                em.remove(message);
            }
        } catch (Exception e){
            return false;
        }
        return true;
    }


}

