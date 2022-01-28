package id.choniyuazwan.onion.service;

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

@RunWith(MockitoJUnitRunner.class)
public class PasswordManagerTest {
  @InjectMocks
  PasswordManager passwordManager;

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
  public void ChangePassword() {
    String username = "a";
    String currentPassword = "a";
    String newPassword = "a";

    UserCredential userCredential = new UserCredential(1, currentPassword);

    Mockito.when(userRepository.getPassword(username)).thenReturn(userCredential);
    userCredential.setPassword(newPassword);
    Mockito.lenient().doNothing().when(userCredentialRepository).add(userCredential);

    Boolean result = passwordManager.changePassword(username, currentPassword, newPassword);
    Assert.assertEquals(true, result);
  }
}
