package db.repositories;

import model.stubs.StubEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

import static db.utils.HibernateUtils.*;

/**
 * Created by Marcin on 2016-08-20.
 */
@Repository
public class StubEntityRepository {

    public void saveEntites(List<StubEntity> entities) {
        Session session = getSession();
        session.beginTransaction();
        for(StubEntity entity : entities) {
            session.save(entity);
        }
        session.getTransaction().commit();
        session.close();
    }

    public List<StubEntity> getAllEntities() {
        Session session = getSession();
        List<StubEntity> result = session.createCriteria(StubEntity.class).list();
        session.close();
        return result;
    }
}
