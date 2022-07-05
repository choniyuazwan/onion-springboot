package id.choniyuazwan.onion.service;

import id.choniyuazwan.onion.domain.model.User;
import id.choniyuazwan.onion.domain.model.UserCredential;
import id.choniyuazwan.onion.domain.service.UserCredentialService;
import id.choniyuazwan.onion.domain.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.stereotype.Service;

import static org.mockito.Mockito.times;

@Service
@RunWith(MockitoJUnitRunner.class)
public class UserManagerTest {
  UserManager userManager;

  @Mock
  UserService userService;

  @Mock
  UserCredentialService userCredentialService;

  @Captor
  ArgumentCaptor<User> userCaptor;

  @Captor
  ArgumentCaptor<UserCredential> userCredentialCaptor;

  @Before
  public void before() {
    this.userManager = new UserManager(userService, userCredentialService);
  }

  @Test
  public void CreateUser() {
    Mockito.when(userService.add(Mockito.any())).thenReturn(true);

    Boolean result = userManager.createUser("a", "a", "a");

    Mockito.verify(userService, times(1)).add(Mockito.any());
    Assert.assertEquals(true, result);

    Mockito.verify(userCredentialService).add(userCredentialCaptor.capture());
    Mockito.verify(userService).add(userCaptor.capture());

    Mockito.verify(userCredentialService, times(1)).add(userCredentialCaptor.capture());
    Mockito.verify(userService, times(1)).add(userCaptor.capture());

    UserCredential userCredentialCaptorValue = userCredentialCaptor.getValue();
    User userCaptorValue = userCaptor.getValue();

    Assert.assertEquals("a", userCredentialCaptorValue.getPassword());
    Assert.assertEquals("a", userCaptorValue.getUsername());


//    tambahi ArgumentCaptor
//    Capture the argument of the doSomething function
//    Mockito.ArgumentCaptor<SomeData> captor = ArgumentCaptor.forClass(SomeData.class);
//    verify(other, times(1)).doSomething(captor.capture());
  }
}
