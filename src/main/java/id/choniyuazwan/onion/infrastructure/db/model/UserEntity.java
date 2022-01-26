package id.choniyuazwan.onion.infrastructure.db.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {
  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private String username;
  @Column
  private String fullname;

  @ManyToOne
  @JoinColumn(name = "password")
  private UserCredentialEntity password;

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

  public UserCredentialEntity getPassword() {
    return password;
  }

  public void setPassword(UserCredentialEntity password) {
    this.password = password;
  }
}

