package id.choniyuazwan.onion.infrastructure.db;

import id.choniyuazwan.onion.domain.model.User;
import id.choniyuazwan.onion.domain.service.UserRepository;
import id.choniyuazwan.onion.infrastructure.db.model.UserEntity;
import id.choniyuazwan.onion.infrastructure.db.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Service
public class UserJpaRepository implements UserRepository {

  @PersistenceContext
  private EntityManager em;

  @Autowired
  private UserRepo userRepo;

  @Override
  public void add(User user) {
    final UserEntity entity = new UserEntity();
    entity.setUsername(user.getUsername());
    entity.setFullname(user.getFullname());

    userRepo.save(entity);
  }
}
