/***************************************************************************
 * Copyright 2016 by HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.homedirect.template.request;

/**
 *  Author : Nhu Dinh Thuan
 *          Email:thuan.nhu@homedirect.com.vn
 * Nov 15, 2017
 */
public class UserRegistryRequest {
  
  private String username;
  
  private String phone;
  
  private String password;
  
  private String rePassword;
  
  private String fullname;
  
  private String email;

  public UserRegistryRequest() {
    
  }

  public String getUsername() {  return username; }
  public void setUsername(String username) { this.username = username; }

  public String getPhone() { return phone; }
  public void setPhone(String phone) { this.phone = phone; }

  public String getPassword() { return password; }
  public void setPassword(String password) { this.password = password; }
  
  public String getRePassword() { return rePassword; }
  public void setRePassword(String rePassword) { this.rePassword = rePassword; }
  
  public String getFullname() { return fullname; }
  public void setFullname(String fullname) { this.fullname = fullname; }

  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }

}
