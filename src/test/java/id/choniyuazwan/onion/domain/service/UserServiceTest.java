package id.choniyuazwan.onion.domain.service;

import id.choniyuazwan.onion.domain.model.User;
import id.choniyuazwan.onion.domain.model.UserCredential;
import id.choniyuazwan.onion.domain.service.repository.UserRepository;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserServiceTest {
  UserService userService;
  private static User user;
  private static UserCredential userCredential;

  @Mock
  UserRepository userRepository;

//  @InjectMocks
//  private UserService userService;

  @Before
  public void before() throws Exception {
    userService = new UserService(userRepository);
  }

  @BeforeAll
  public static void init() {
    userCredential = new UserCredential(1, "a");
    user = new User("a", "a", userCredential);

//    p1 = new Product("P1", "Created Dummy Product", 100);
//    p2 = new Product("P2", "Created For Update Dummy Product", 200);
  }

  @Test
  public void add() {
//    UserCredential userCredential = new UserCredential(1, "a");
//    User user = new User("a", "a", userCredential);
//
//    Mockito.when(userRepository.add(user)).thenReturn(true);
//    Boolean result = userService.add(user);
//
//    Mockito.verify(userRepository, times(1)).add(user);
//    Assert.assertEquals(true, result);

    Mockito.when(userRepository.add(user)).thenReturn(true);
    MatcherAssert.assertThat(userService.add(user), is(true));
    Mockito.verify(userRepository, times(1)).add(user);

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
