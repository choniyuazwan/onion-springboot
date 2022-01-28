package id.choniyuazwan.onion.service;

import id.choniyuazwan.onion.domain.model.UserCredential;
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
public class PasswordManagerTest {
  PasswordManager passwordManager;

  @Mock
  UserService userService;

  @Mock
  UserCredentialService userCredentialService;

  @Before
  public void before() throws Exception {
    this.passwordManager = new PasswordManager(userService, userCredentialService);
  }

  @Test
  public void ChangePassword() {
    String username = "a";
    String currentPassword = "a";
    String newPassword = "a";

    UserCredential userCredential = new UserCredential(1, currentPassword);
    Mockito.when(userService.getPassword(username)).thenReturn(userCredential);

    Boolean result = passwordManager.changePassword(username, currentPassword, newPassword);

    Mockito.verify(userService, times(1)).getPassword(username);
    Assert.assertEquals(true, result);
  }
}
