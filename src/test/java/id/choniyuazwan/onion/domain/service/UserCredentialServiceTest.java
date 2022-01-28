package id.choniyuazwan.onion.domain.service;

import id.choniyuazwan.onion.domain.model.UserCredential;
import id.choniyuazwan.onion.domain.service.repository.UserCredentialRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class UserCredentialServiceTest {
  UserCredentialService userCredentialService;

  @Mock
  UserCredentialRepository userCredentialRepository;

  @Before
  public void before() throws Exception {
    userCredentialService = new UserCredentialService(userCredentialRepository);
  }

  @Test
  public void add() {
    UserCredential userCredential = new UserCredential(1, "a");

    userCredentialService.add(userCredential);
    Mockito.verify(userCredentialRepository, times(1)).add(userCredential);
  }
}
