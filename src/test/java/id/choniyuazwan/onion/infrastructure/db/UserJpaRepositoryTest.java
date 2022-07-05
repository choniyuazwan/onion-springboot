package id.choniyuazwan.onion.infrastructure.db;

import id.choniyuazwan.onion.domain.model.User;
import id.choniyuazwan.onion.domain.model.UserCredential;
import id.choniyuazwan.onion.infrastructure.db.model.UserCredentialEntity;
import id.choniyuazwan.onion.infrastructure.db.model.UserEntity;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserJpaRepositoryTest {

  @Autowired
  private UserJpaRepository userJpaRepository;

  @Test
  public void addUser() {
    try {
      UserCredentialEntity userCredentialEntity = new UserCredentialEntity(1, "a");
      UserEntity userEntity = new UserEntity("a", "a", userCredentialEntity);
      UserEntity result = userJpaRepository.save(userEntity);
//      Assertions.assertNotNull(result.getUsername());
      Assert.assertEquals("a", result.getUsername());
    } catch (Exception e) {
      Assertions.fail("add user ", e);
    }

  }
}
