package db.repositories;

import model.stubs.StubEntity;
import org.hibernate.Session;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Marcin on 2016-08-20.
 */

public interface StubEntityRepository extends CrudRepository<StubEntity, Long> {

}
