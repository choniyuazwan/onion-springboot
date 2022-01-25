package id.choniyuazwan.onion.service;

import net.bytebuddy.utility.RandomString;

public final class CredentialGeneration {

  public static String password(String item) {
    return item != null && !item.trim().isEmpty() ? item : RandomString.make(6);
  }
}
