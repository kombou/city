package org.study.city.configuration.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Map;

public abstract class HibernateConfiguration {

    protected SessionFactory sessionFactory;
    protected Configuration configuration;

    private Map<String ,String> configProperties;

    public abstract void configure();

    public void addClass(Class type) {

        configuration.addAnnotatedClass(type);
    }

    public void buildSessionFactory() {

        sessionFactory = configuration.buildSessionFactory();
    }

    public SessionFactory sessionFactory() {
        return sessionFactory;
    }

}
