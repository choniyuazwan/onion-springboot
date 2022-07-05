package id.choniyuazwan.onion.domain.service;

import id.choniyuazwan.onion.domain.model.User;
import id.choniyuazwan.onion.domain.model.UserCredential;
import id.choniyuazwan.onion.domain.service.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public class UserService {
  private final UserRepository repository;

  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  public Boolean add(User user) {
    return repository.add(user);
  }

  public UserCredential getPassword(String username) {
    return repository.getPassword(username);
  }
}
