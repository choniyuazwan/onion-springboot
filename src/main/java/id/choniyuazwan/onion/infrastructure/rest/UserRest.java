package id.choniyuazwan.onion.infrastructure.rest;

import id.choniyuazwan.onion.infrastructure.rest.DTO.UserDTO;
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
    if (userManager.createUser(userDTO.getUsername(), userDTO.getFullname(), userDTO.getPassword())) return "ok"; else return "failed";
  }
}
