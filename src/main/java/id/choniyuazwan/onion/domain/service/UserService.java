package id.choniyuazwan.onion.domain.service;

import id.choniyuazwan.onion.domain.model.User;

public class UserService {
  private final UserRepository repository;

  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  public void add(User user) {
    repository.add(user);
  }
}
