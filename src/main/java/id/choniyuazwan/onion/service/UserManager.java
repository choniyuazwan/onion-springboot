package id.choniyuazwan.onion.service;

import id.choniyuazwan.onion.domain.model.User;
import id.choniyuazwan.onion.domain.model.UserCredential;
import id.choniyuazwan.onion.domain.service.UserCredentialService;
import id.choniyuazwan.onion.domain.service.UserService;
import net.bytebuddy.utility.RandomString;

public class UserManager {

  private UserService userService;
  private UserCredentialService userCredentialService;

  public UserManager(UserService userService, UserCredentialService userCredentialService) {
    this.userService = userService;
    this.userCredentialService = userCredentialService;
  }

  public void createUser(User user) {
    String password = user.getPassword().getPassword();
    UserCredential userCredential = new UserCredential();

    password = password != null && !password.trim().isEmpty() ? password : RandomString.make(6);
    userCredential.setPassword(password);
    userCredentialService.add(userCredential);
    
    user.setPassword(userCredential);
    userService.add(user);
  }
}
