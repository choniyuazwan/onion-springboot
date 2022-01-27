package id.choniyuazwan.onion.infrastructure.rest;

import id.choniyuazwan.onion.infrastructure.rest.DTO.PasswordDTO;
import id.choniyuazwan.onion.service.PasswordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordRest {

  @Autowired
  private PasswordManager passwordManager;

  @PostMapping(value = "/passwords")
  public String change(@RequestBody PasswordDTO passwordDTO) {
    return passwordManager.changePassword(passwordDTO.getUsername(), passwordDTO.getCurrentPassword(), passwordDTO.getNewPassword()) ? "ok" : "currentPassword tidak ditemukan";
  }
}
