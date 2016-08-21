package com.tel_ran.hederkosher.service;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HibUtilImpl implements HibUtil{
    private static SessionFactory sessionFactory;

    static {
        try {
            StandardServiceRegistry standardRegistry;
            standardRegistry = new StandardServiceRegistryBuilder()
                    .configure( "hibernate.cfg.xml" )
                    .build();

            MetadataSources ms = new MetadataSources( standardRegistry );

            ms = addClassesFromPackage(ms, "com.tel_ran.hederkosher.model.security.entity");
            ms = addClassesFromPackage(ms, "com.tel_ran.hederkosher.model.common.entity");

            Metadata metadata = ms.getMetadataBuilder()
                    .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE )
                    .build();

            sessionFactory = metadata.getSessionFactoryBuilder().build();
            //sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            e.printStackTrace(); //throw new ExceptionInInitializerError(e);
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static MetadataSources addClassesFromPackage(MetadataSources ms, String packageName) {
        List<Class<?>> classes = ClassFinder.find(packageName);
        for (Class clazz : classes) {
            ms.addAnnotatedClassName(clazz.getCanonicalName());
        }
        return ms;
    }
}
