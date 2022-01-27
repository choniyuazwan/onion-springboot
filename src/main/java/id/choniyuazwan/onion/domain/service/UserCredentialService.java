package id.choniyuazwan.onion.domain.service;

import id.choniyuazwan.onion.domain.model.UserCredential;
import id.choniyuazwan.onion.domain.service.repository.UserCredentialRepository;

public class UserCredentialService {
  private final UserCredentialRepository repository;

  public UserCredentialService(UserCredentialRepository repository) {
    this.repository = repository;
  }

  public void add(UserCredential userCredential) {
    repository.add(userCredential);
  }
}
