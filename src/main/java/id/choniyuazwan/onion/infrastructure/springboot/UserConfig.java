package id.choniyuazwan.onion.infrastructure.springboot;

import id.choniyuazwan.onion.domain.service.UserRepository;
import id.choniyuazwan.onion.domain.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
  @Bean
  public UserService userService(UserRepository repository) {
    return new UserService(repository);
  }
}
