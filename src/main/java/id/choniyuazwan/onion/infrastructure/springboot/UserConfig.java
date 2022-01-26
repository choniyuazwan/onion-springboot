package id.choniyuazwan.onion.infrastructure.springboot;

import id.choniyuazwan.onion.domain.service.UserCredentialRepository;
import id.choniyuazwan.onion.domain.service.UserCredentialService;
import id.choniyuazwan.onion.domain.service.UserRepository;
import id.choniyuazwan.onion.domain.service.UserService;
import id.choniyuazwan.onion.service.UserManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
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
}
