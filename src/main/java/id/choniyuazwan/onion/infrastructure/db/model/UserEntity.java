package id.choniyuazwan.onion.infrastructure.db.model;

import javax.persistence.*;

@Entity(name = "UserEntity")
@Table(name = "user")
public class UserEntity {
  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "username")
  private String username;
  @Column(name = "fullname")
  private String fullname;
  @Column(name = "password")
  private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}

