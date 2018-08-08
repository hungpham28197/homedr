/***************************************************************************
 * Copyright 2016 by HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.homedirect.template.service.validator;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import com.homedirect.template.exception.CommonException;
import com.homedirect.template.model.User;
import com.homedirect.template.repository.exception.RepositoryException;
import com.homedirect.template.service.UserService;

/**
 *  Author : Nhu Dinh Thuan
 *          Email:thuan.nhu@homedirect.com.vn
 * Nov 15, 2017
 */
@MessageEndpoint
public class UserStorageValidator {
  	
  @Autowired
  private UserService userService;

  @ServiceActivator(inputChannel = "user-registry-channel-3-validate-storage", outputChannel = "user-registry-channel-4-service")
 public User validate(User user) throws CommonException {
    Optional<User> optional = userService.get(user.getUsername());
    if(optional.isPresent()) {
      throw new RepositoryException(RepositoryException.DUPLICATED_ERROR, RepositoryException.DUPLICATED_ERROR_DESCRIPTION); 
    }
    return user;
  }
}
