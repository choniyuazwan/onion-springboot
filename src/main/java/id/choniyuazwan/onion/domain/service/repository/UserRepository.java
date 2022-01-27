package id.choniyuazwan.onion.domain.service.repository;

import id.choniyuazwan.onion.domain.model.User;
import id.choniyuazwan.onion.domain.model.UserCredential;

public interface UserRepository {
  void add(User user);

  UserCredential getPassword(String username);
}
