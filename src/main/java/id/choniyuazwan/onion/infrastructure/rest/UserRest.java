package id.choniyuazwan.onion.infrastructure.rest;

import id.choniyuazwan.onion.domain.model.User;
import id.choniyuazwan.onion.domain.service.UserService;
import id.choniyuazwan.onion.service.CredentialGeneration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRest {

  @Autowired
  private UserService service;

  @PostMapping(value = "/users")
  public ResponseEntity<User> add(@RequestBody UserDTO userDTO) {
    final User user = new User();

    user.setUsername(userDTO.getUsername());
    user.setFullname(userDTO.getFullname());
    String password  = CredentialGeneration.password(userDTO.getPassword());
    user.setPassword(password);

    service.add(user);

    return ResponseEntity.ok(user);
  }
}
