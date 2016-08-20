package com.tel_ran.hederkosher.model.security.dao.implementation;

import com.tel_ran.hederkosher.model.security.entity.Token;
import com.tel_ran.hederkosher.model.security.entity.User;
import com.tel_ran.hederkosher.model.security.dao.TokenDAO;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@Service("tokenDAOService")
public class TokenDAOImplTest implements TokenDAO {
    private static final AtomicLong counter = new AtomicLong();
    private List<Token> tokens = new ArrayList<>();

    @Override
    public User getUser(String stToken) throws UsernameNotFoundException {
        for (Iterator<Token> it = tokens.iterator(); it.hasNext();) {
            Token token = it.next();
            if (stToken.equals(token.getToken())) {
                return token.getUser();
            }
        }
        throw new UsernameNotFoundException("User for token " + stToken + " not found");
    }

    @Override
    public Token createToken(User user) {
        Token res = new Token();
        res.setToken(DigestUtils.md5DigestAsHex(user.toString().getBytes()));
        res.setUser(user);
        res.setTsCreate(new Date());
        this.deleteToken(user);
        this.tokens.add(res);
        return res;
    }

    @Override
    public void deleteToken(User user) {
        for (Iterator<Token> it = tokens.iterator(); it.hasNext();) {
            Token token = it.next();
            if (token.getUser() == user) {
                it.remove();
            }
        }
    }

    @Override
    public void deleteToken(String stToken) {
        for (Iterator<Token> it = tokens.iterator(); it.hasNext();) {
            Token token = it.next();
            if (stToken.equals(token.getToken())) {
                it.remove();
            }
        }
    }
}
