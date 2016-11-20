/**
 * Created by Ruslan on 30.08.2016.
 */

package com.tel_ran.hederkosher.model.common.dao;

import com.tel_ran.hederkosher.exception.TemplateNotFoundException;
import com.tel_ran.hederkosher.model.common.entity.Message;

import java.util.List;

public interface MessageDao {
        boolean addMessage(Message obj);
        boolean updateMessage(Message obj);
        boolean deleteMessage(long id);
        Message getById(long id) throws TemplateNotFoundException;
        List<Message> getByLikeName(String name);
        List<Message> getAllMessages();
        List<Message> getAllMessagesActives();

        List<Message> getByState(String name);
        List<Message> getByType(String name);
        List<Message> getByProgram(long id);
        List<Message> getByTask(long id);
        List<Message> getByUserFrom(long id);


}
