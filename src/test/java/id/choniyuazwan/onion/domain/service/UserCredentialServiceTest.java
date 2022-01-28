package id.choniyuazwan.onion.domain.service;

import id.choniyuazwan.onion.domain.model.UserCredential;
import id.choniyuazwan.onion.domain.service.repository.UserCredentialRepository;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

public class UserCredentialServiceTest {
  @InjectMocks
  UserCredentialService userCredentialService;

  @Mock
  UserCredentialRepository userCredentialRepository;

  @Test
  public void add() {
    UserCredential userCredential = new UserCredential(1, "a");

    Mockito.doNothing().when(userCredentialRepository).add(userCredential);

    userCredentialService.add(userCredential);
//    Assert.assertEquals(true, result);
  }
}
