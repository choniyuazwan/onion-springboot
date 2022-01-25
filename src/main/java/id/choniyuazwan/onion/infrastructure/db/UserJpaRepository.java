package id.choniyuazwan.onion.infrastructure.db;

import id.choniyuazwan.onion.domain.model.User;
import id.choniyuazwan.onion.domain.service.UserRepository;
import id.choniyuazwan.onion.infrastructure.db.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends CrudRepository<UserEntity, Integer>, UserRepository {
  default void add(User user) {
    final UserEntity entity = new UserEntity();
    entity.setUsername(user.getUsername());
    entity.setFullname(user.getFullname());

    this.save(entity);
  }
}
