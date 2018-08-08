
package com.homedirect.template.service;

import java.util.Optional;

import com.homedirect.template.exception.CommonException;
import com.homedirect.template.model.User;

/**
 *  Author : duy.bui
 * Oct 27, 2017
 */
public interface UserService  {

  public String registryUser(User user);
 
  public Optional<User> get(String username);
  
  public String checkLogin(User user) throws CommonException;
}
