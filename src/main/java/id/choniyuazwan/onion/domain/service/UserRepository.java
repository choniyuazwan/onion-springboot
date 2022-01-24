package id.choniyuazwan.onion.domain.service;

import id.choniyuazwan.onion.domain.model.User;
import org.springframework.stereotype.Repository;

public interface UserRepository {
  void add(User user);
}
