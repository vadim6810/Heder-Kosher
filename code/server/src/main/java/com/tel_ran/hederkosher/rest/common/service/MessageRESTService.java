package com.tel_ran.hederkosher.rest.common.service;

import com.tel_ran.hederkosher.model.common.entity.Message;
import com.tel_ran.hederkosher.rest.ServiceResult;

public interface MessageRESTService {
    //CRUD ALL
    ServiceResult getAllMessages();
    ServiceResult getMessagesByLikeName(String name);
    ServiceResult getMessagesByState(String name);
    ServiceResult getMessagesByType(String name);
    ServiceResult deleteAllMessages();

    //CRUD ID
    ServiceResult createMessage(Message message);
    ServiceResult findMessageByID(long id);
    ServiceResult updateMessage(Message message);
    ServiceResult deleteMessage(long id);


    //CRUD for PROGRAM
    ServiceResult createMessageByProgram(long idProgram, Message message);
    //    ServiceResult setMessageToPerson(long idPerson,long id);
    ServiceResult getMessagesByProgram(long idProgram);
    ServiceResult deleteMessagesByProgram(long idProgram);

    //CRUD for TASK
    ServiceResult createMessageByTask(long idTask, Message message);
    //    ServiceResult setMessageToTask(long idRoom,long id);
    ServiceResult getMessagesByTask(long idTask);
    ServiceResult deleteMessagesByTask(long idTask);


    //CRUD for USER_FROM
    ServiceResult createMessageByUser(long idUser, Message message);
    //    ServiceResult setMessageToUser(long idGym,long id);
    ServiceResult getMessagesByUserFrom(long idUser);
    ServiceResult deleteMessagesByUserFrom(long idUser);

}
