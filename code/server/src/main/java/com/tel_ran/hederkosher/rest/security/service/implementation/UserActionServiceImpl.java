package com.tel_ran.hederkosher.rest.security.service.implementation;

import com.tel_ran.hederkosher.model.security.Token;
import com.tel_ran.hederkosher.model.security.User;
import com.tel_ran.hederkosher.model.security.dao.TokenDAO;
import com.tel_ran.hederkosher.model.security.dao.UserDAO;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.ServiceResultFactory;
import com.tel_ran.hederkosher.rest.security.service.UserActionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Igor on 05.08.2016.
 */

@Service("userActionService")
public class UserActionServiceImpl implements UserActionsService{
    @Autowired
    UserDAO userDAO;

    @Autowired
    TokenDAO tokenDAO;

    @Override
    public ServiceResult login(String login, String pass) {
        ServiceResult res;

        User user = userDAO.findByMail(login);
        if (user == null) {
            return ServiceResultFactory.CREDENTIALS_NOT_FOUND;
        }
        //TODO: insert passhash checking

        res = ServiceResultFactory.OK;
        Token token = tokenDAO.createToken(user);
        res.setData(token.getToken());
        return res;
    }

    @Override
    public ServiceResult logout() {
        return null;
    }
}
