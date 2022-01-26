package id.choniyuazwan.onion.infrastructure.rest;

import id.choniyuazwan.onion.domain.model.User;
import id.choniyuazwan.onion.domain.model.UserCredential;
import id.choniyuazwan.onion.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRest {

  @Autowired
  private UserManager userManager;

  @PostMapping(value = "/users")
  public String add(@RequestBody UserDTO userDTO) {
    User user = new User();
    UserCredential userCredential = new UserCredential();

    user.setUsername(userDTO.getUsername());
    user.setFullname(userDTO.getFullname());
    userCredential.setPassword(userDTO.getPassword());
    user.setPassword(userCredential);

    userManager.createUser(user);

    return "ok";
  }
}
