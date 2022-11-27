package hello.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            synchronized (HibernateUtil.class){
                if (sessionFactory == null){
                    sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
                }
            }
        }

        return sessionFactory;
    }

    public static synchronized void closeSessionFactory(){
        if (sessionFactory != null){
            sessionFactory.close();
        }
    }

}
