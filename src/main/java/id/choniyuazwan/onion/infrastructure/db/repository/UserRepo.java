package id.choniyuazwan.onion.infrastructure.db.repository;

import id.choniyuazwan.onion.infrastructure.db.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<UserEntity, Integer> {

}
