package id.choniyuazwan.onion.service;

import id.choniyuazwan.onion.domain.service.UserCredentialService;
import id.choniyuazwan.onion.domain.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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

//    tambahi ArgumentCaptor
//    Capture the argument of the doSomething function
//    Mockito.ArgumentCaptor<SomeData> captor = ArgumentCaptor.forClass(SomeData.class);
//    verify(other, times(1)).doSomething(captor.capture());
  }
}
