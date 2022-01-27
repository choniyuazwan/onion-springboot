package id.choniyuazwan.onion.infrastructure.springboot;

import id.choniyuazwan.onion.domain.service.repository.UserCredentialRepository;
import id.choniyuazwan.onion.domain.service.UserCredentialService;
import id.choniyuazwan.onion.domain.service.repository.UserRepository;
import id.choniyuazwan.onion.domain.service.UserService;
import id.choniyuazwan.onion.service.PasswordManager;
import id.choniyuazwan.onion.service.UserManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
  @Bean
  public UserService userService(UserRepository repository) {
    return new UserService(repository);
  }

  @Bean
  public UserCredentialService userCredentialService(UserCredentialRepository repository) {
    return new UserCredentialService(repository);
  }

  @Bean
  public UserManager userManager(UserService userService, UserCredentialService userCredentialService) {
    return new UserManager(userService, userCredentialService);
  }

  @Bean
  public PasswordManager passwordManager(UserService userService, UserCredentialService userCredentialService) {
    return new PasswordManager(userService, userCredentialService);
  }
}
