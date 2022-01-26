package id.choniyuazwan.onion.infrastructure.db;

import id.choniyuazwan.onion.domain.model.User;
import id.choniyuazwan.onion.domain.service.UserRepository;
import id.choniyuazwan.onion.infrastructure.db.model.UserCredentialEntity;
import id.choniyuazwan.onion.infrastructure.db.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserJpaRepository extends CrudRepository<UserEntity, Integer>, UserRepository {
  default void add(User user) {
    final UserEntity entity = new UserEntity();
    entity.setUsername(user.getUsername());
    entity.setFullname(user.getFullname());
    entity.setPassword(new UserCredentialEntity(user.getPassword().getId(), user.getPassword().getPassword()));
//    entity.setPassword(user.getPassword());

    this.save(entity);
  }
}
