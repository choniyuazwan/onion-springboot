package id.choniyuazwan.onion.domain.service;

import id.choniyuazwan.onion.domain.model.User;
import id.choniyuazwan.onion.domain.model.UserCredential;
import id.choniyuazwan.onion.domain.service.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
  UserService userService;

  @Mock
  UserRepository userRepository;

  @Before
  public void before() throws Exception {
    userService = new UserService(userRepository);
  }

  @Test
  public void add() {
    UserCredential userCredential = new UserCredential(1, "a");
    User user = new User("a", "a", userCredential);

    Mockito.when(userRepository.add(user)).thenReturn(true);
    Boolean result = userService.add(user);

    Mockito.verify(userRepository, times(1)).add(user);
    Assert.assertEquals(true, result);
  }

  @Test
  public void getPassword() {
    String username = "a";
    UserCredential userCredential = new UserCredential(1, "a");

    Mockito.when(userRepository.getPassword(username)).thenReturn(userCredential);
    userCredential = userService.getPassword(username);

    Mockito.verify(userRepository, times(1)).getPassword(username);
    Assert.assertEquals(userCredential, userCredential);
  }
}
