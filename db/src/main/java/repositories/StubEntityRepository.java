package repositories;

import org.springframework.data.repository.CrudRepository;
import stubs.StubEntity;

/**
 * Created by Marcin on 2016-08-20.
 */

public interface StubEntityRepository extends CrudRepository<StubEntity, Long> {

}
