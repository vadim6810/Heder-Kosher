/**
 * Created by Ruslan on 30.08.2016.
 */

package com.tel_ran.hederkosher.model.common.dao;

import com.tel_ran.hederkosher.exception.TemplateNotFoundException;
import com.tel_ran.hederkosher.model.common.entity.Message;

import java.util.List;

public interface MessageDao {
        boolean addMessage(Message message,Long idProgram, Long idTask, Long idUser);
        boolean updateMessage(Message message);
        boolean deleteMessage(long id);
        boolean deleteAllMessages();

        Message getById(long id) throws TemplateNotFoundException;
        List<Message> getAllMessages();
        List<Message> getAllMessagesActives();
        List<Message> getMessagesByLikeName(String name);

        List<Message> getMessagesByState(String name);
        List<Message> getMessagesByType(String name);

        List<Message> getMessagesByProgram(long idProgram);
        boolean deleteMessagesByProgram(long idProgram);

        List<Message> getMessagesByTask(long idTask);
        boolean deleteMessagesByTask(long idTask);

        List<Message> getMessagesByUserFrom(long idUser);
        boolean deleteMessagesByUserFrom(long idUser);


}
