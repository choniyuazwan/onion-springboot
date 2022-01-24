package id.choniyuazwan.onion.infrastructure.rest;

import id.choniyuazwan.onion.domain.model.User;
import id.choniyuazwan.onion.domain.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRest {

  private final UserService service;

  public UserRest(UserService service) {
    this.service = service;
  }

  @PostMapping(value = "/users")
  public String add(@RequestBody UserDTO userDTO) {
    final User user = new User();
    user.setUsername(userDTO.getUsername());
    user.setFullname(userDTO.getFullname());

    service.add(user);

//    return new ResponseEntity<>(user, HttpStatus.CREATED);

    return "ok";
  }
}
