package id.choniyuazwan.onion.service;

import id.choniyuazwan.onion.domain.model.UserCredential;
import id.choniyuazwan.onion.domain.service.UserCredentialService;
import id.choniyuazwan.onion.domain.service.UserService;

public class PasswordManager {
  private UserService userService;
  private UserCredentialService userCredentialService;

  public PasswordManager(UserService userService, UserCredentialService userCredentialService) {
    this.userService = userService;
    this.userCredentialService = userCredentialService;
  }

  public Boolean changePassword(String username, String currentPassword, String newPassword) {
    UserCredential userCredential = userService.getPassword(username);

    if(userCredential != null && userCredential.getPassword().equals(currentPassword)) {
      userCredential.setPassword(newPassword);
      userCredentialService.add(userCredential);
      return true;
    }
    return false;
  }
}
