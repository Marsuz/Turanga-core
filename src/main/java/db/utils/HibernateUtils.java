package db.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Created by Marcin on 2016-08-20.
 */
public class HibernateUtils {
    private static SessionFactory sessionFactory;
    private static final StandardServiceRegistry serviceRegistry;

    static {
        serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
    }

    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }
}