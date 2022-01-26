package id.choniyuazwan.onion.infrastructure.db;

import id.choniyuazwan.onion.domain.model.UserCredential;
import id.choniyuazwan.onion.domain.service.UserCredentialRepository;
import id.choniyuazwan.onion.infrastructure.db.model.UserCredentialEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserCredentialJpaRepository extends CrudRepository<UserCredentialEntity, Integer>, UserCredentialRepository {
  default void add(UserCredential userCredential) {
    final UserCredentialEntity entity = new UserCredentialEntity();
      entity.setPassword(userCredential.getPassword());

      this.save(entity);
      userCredential.setId(entity.getId());
  }
}
