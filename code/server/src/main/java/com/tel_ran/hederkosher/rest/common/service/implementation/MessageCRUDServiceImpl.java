package com.tel_ran.hederkosher.rest.common.service.implementation;

import com.tel_ran.hederkosher.exception.TemplateNotFoundException;
import com.tel_ran.hederkosher.model.common.dao.MessageDao;
import com.tel_ran.hederkosher.model.common.dao.ProgramDao;
import com.tel_ran.hederkosher.model.common.dao.TaskDao;
import com.tel_ran.hederkosher.model.common.entity.Message;
import com.tel_ran.hederkosher.model.common.entity.Task;
import com.tel_ran.hederkosher.model.security.dao.UserDAO;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.ServiceResultFactory;
import com.tel_ran.hederkosher.rest.common.service.MessageRESTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.tel_ran.hederkosher.rest.ServiceResultFactory.Type;
import static com.tel_ran.hederkosher.rest.ServiceResultFactory.getResultObject;

@Service("messageCRUDService")
public class MessageCRUDServiceImpl implements MessageRESTService {

    @Autowired
    private MessageDao messageDao;
    @Autowired
    private ProgramDao programDao;
    @Autowired
    private TaskDao taskDao;
    @Autowired
    private UserDAO userDAO;

    private ServiceResult result;

    //CRUD ALL
    @Override
    public ServiceResult getAllMessages() {
        result = getResultObject(Type.OK);
        result.setData(messageDao.getAllMessages());
        return result;
    }
    @Override
    public ServiceResult getMessagesByLikeName(String name) {
        result = getResultObject(Type.OK);
        result.setData(messageDao.getMessagesByLikeName(name));
        return result;
    }

    @Override
    public ServiceResult getMessagesByState(String name) {
        result = getResultObject(Type.OK);
        result.setData(messageDao.getMessagesByState(name));
        return result;
    }

    @Override
    public ServiceResult getMessagesByType(String name) {
        result = getResultObject(Type.OK);
        result.setData(messageDao.getMessagesByType(name));
        return result;
    }

    @Override
    public ServiceResult deleteAllMessages() {
        if (messageDao.deleteAllMessages()) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.DELETING_ERROR);
        }
//        result.setData();
        return result;
    }

    //CRUD ID
    @Override
    public ServiceResult createMessage(Message message) {
        if (messageDao.addMessage(message,null,null,null)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.CREATING_ERROR);
        }
        result.setData(message);
        return result;
    }
    @Override
    public ServiceResult findMessageByID(long id) {
        Message message=null;
        try {
            message= messageDao.getById(id);
        } catch (TemplateNotFoundException e) {
            result = getResultObject(Type.NOT_FOUND);
            result.setData(id);
            result.setDescription(e.getMessage());
            return result;
        }
        result = ServiceResultFactory.OK;
        result.setData(message);
        return result;
    }
    @Override
    public ServiceResult updateMessage(Message message) {
        if (messageDao.updateMessage(message)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.UPDATING_ERROR);
        }
        result.setData(message);
        return result;
    }
    @Override
    public ServiceResult deleteMessage(long id) {
        if (messageDao.deleteMessage(id)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.DELETING_ERROR);
        }
        result.setData(id);
        return result;
    }



    //CRUD for PROGRAM
    @Override
    public ServiceResult createMessageByProgram(long idProgram, Message message) {
        if (messageDao.addMessage(message,idProgram,null,null)) { // && programDao.addMessageByPprogram(idProgram,message)
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.CREATING_ERROR);
        }
        result.setData(message);
        return result;
    }
    @Override
    public ServiceResult getMessagesByProgram(long idProgram) {
        result = getResultObject(Type.OK);
        result.setData(messageDao.getMessagesByProgram(idProgram));
        return result;
    }
    @Override
    public ServiceResult deleteMessagesByProgram(long idProgram) {
        if (messageDao.deleteMessagesByProgram(idProgram)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.DELETING_ERROR);
        }
        result.setData(idProgram);
        return result;
    }
//    @Override
//    public ServiceResult setMessageToProgram(long idProgram, long id) {
//        return null;
//    }


    //CRUD for TASK
    @Override
    public ServiceResult createMessageByTask(long idTask, Message message) {
        Task task = taskDao.getTaskById(idTask);

        if (messageDao.addMessage(message,null,idTask,null)) { // && taskDao.addMessageByTask(idTask,message)
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.CREATING_ERROR);
        }
        result.setData(message);
        return result;
    }
    @Override
    public ServiceResult getMessagesByTask(long idTask) {
        result = getResultObject(Type.OK);
        result.setData(messageDao.getMessagesByTask(idTask));
        return result;
    }
    @Override
    public ServiceResult deleteMessagesByTask(long idTask) {
        if (messageDao.deleteMessagesByTask(idTask)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.DELETING_ERROR);
        }
        result.setData(idTask);
        return result;
    }
//    @Override
//    public ServiceResult setMessageToTask(long idTask, long id) {
//        return null;
//    }


    //CRUD for USER_FROM
    @Override
    public ServiceResult createMessageByUser(long idUser, Message message) {
        if (messageDao.addMessage(message,null,null,idUser))  { //&& userDAO.addMessageByUser(idUser,message)
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.CREATING_ERROR);
        }
        result.setData(message);
        return result;
    }
    @Override
    public ServiceResult getMessagesByUserFrom(long idUser) {
        result = getResultObject(Type.OK);
        result.setData(messageDao.getMessagesByUserFrom(idUser));
        return result;
    }
    @Override
    public ServiceResult deleteMessagesByUserFrom(long idUser) {
        if (messageDao.deleteMessagesByUserFrom(idUser)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.DELETING_ERROR);
        }
        result.setData(idUser);
        return result;

    }

//    @Override
//    public ServiceResult setMessageToUser(long idUser, long id) {
//        return null;
//    }

}
