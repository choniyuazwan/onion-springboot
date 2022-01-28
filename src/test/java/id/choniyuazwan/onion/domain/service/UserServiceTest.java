package id.choniyuazwan.onion.domain.service;

import id.choniyuazwan.onion.domain.model.User;
import id.choniyuazwan.onion.domain.model.UserCredential;
import id.choniyuazwan.onion.domain.service.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
  @InjectMocks
  UserService userService;

  @Mock
  UserRepository userRepository;

  @Test
  public void add() {
    UserCredential userCredential = new UserCredential(1, "a");
    User user = new User("a", "a", userCredential);

    Mockito.when(userRepository.add(user)).thenReturn(true);

    Boolean result = userService.add(user);
    Assert.assertEquals(true, result);
  }

  @Test
  public void getPassword() {
    String username = "a";
    UserCredential userCredential = new UserCredential(1, "a");

    Mockito.when(userRepository.getPassword(username)).thenReturn(userCredential);
    userCredential = userService.getPassword(username);
    Assert.assertEquals(userCredential, userCredential);
  }
}
