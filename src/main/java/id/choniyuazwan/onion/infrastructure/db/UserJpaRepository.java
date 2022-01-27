package id.choniyuazwan.onion.infrastructure.db;

import id.choniyuazwan.onion.domain.model.User;
import id.choniyuazwan.onion.domain.model.UserCredential;
import id.choniyuazwan.onion.domain.service.repository.UserRepository;
import id.choniyuazwan.onion.infrastructure.db.model.UserCredentialEntity;
import id.choniyuazwan.onion.infrastructure.db.model.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserJpaRepository extends CrudRepository<UserEntity, Integer>, UserRepository {

  default Boolean add(User user) {
    final UserEntity entity = new UserEntity();
    entity.setUsername(user.getUsername());
    entity.setFullname(user.getFullname());
    entity.setPassword(new UserCredentialEntity(user.getPassword().getId(), user.getPassword().getPassword()));

    this.save(entity);
    return true;
  }

  @Query
  UserEntity findByUsername(@Param("username") String username);

  default UserCredential getPassword(String username) {
    UserEntity userEntity = findByUsername(username) == null ? new UserEntity() : findByUsername(username);
    UserCredentialEntity password = userEntity.getPassword();
    return new UserCredential(password.getId(), password.getPassword());
  }
}
