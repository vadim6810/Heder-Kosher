package com.tel_ran.hederkosher.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Igor on 21.08.2016.
 */
public final class Loggers {
    public static Logger restLogger = LoggerFactory.getLogger("rest");
    public static Logger daoLogger = LoggerFactory.getLogger("dao");
    public static Logger securityLogger = LoggerFactory.getLogger("security");
    public static Logger hiberLogger = LoggerFactory.getLogger("org.hibernate");

    private Loggers() {
    }
}
