package id.choniyuazwan.onion.service;

import id.choniyuazwan.onion.domain.model.User;
import id.choniyuazwan.onion.domain.model.UserCredential;
import id.choniyuazwan.onion.domain.service.UserCredentialService;
import id.choniyuazwan.onion.domain.service.UserService;
import id.choniyuazwan.onion.domain.service.repository.UserCredentialRepository;
import id.choniyuazwan.onion.domain.service.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.stereotype.Service;

@Service
@RunWith(MockitoJUnitRunner.class)
public class UserManagerTest {
  @InjectMocks
  UserManager userManager;

  @Mock
  UserService userService;

  @Mock
  UserCredentialService userCredentialService;

  @Mock
  UserRepository userRepository;

  @Mock
  UserCredentialRepository userCredentialRepository;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void CreateUser() {

    UserCredential userCredential = new UserCredential(1, "a");
    User user = new User("a", "a", userCredential);
//    Mockito.lenient().doNothing().when(userCredentialService).add(userCredential);
//    Mockito.when(userService.add(user)).thenReturn(true);
    Mockito.lenient().doNothing().when(userCredentialRepository).add(userCredential);
    Mockito.when(userRepository.add(user)).thenReturn(true);

    Boolean result = userManager.createUser("a", "a", "a");
    Assert.assertEquals(true, result);
  }
}
