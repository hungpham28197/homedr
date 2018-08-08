/***************************************************************************
 * Copyright 2016 by HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.homedirect.template.front.transform;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import com.homedirect.template.model.User;
import com.homedirect.template.request.UserRegistryRequest;
import com.homedirect.template.util.MD5Hash;

/**
 *  Author : Duy Kien Ngo
 *          Email:kien.ngoduy@homedirect.com.vn
 * Sep 28, 2017
 */

@MessageEndpoint
public class UserTransformer {

  @ServiceActivator(inputChannel = "user-registry-channel-2-transform", outputChannel = "user-registry-channel-3-validate-storage")
  public User fromRequest(UserRegistryRequest request) {
    User user = new User();
    
    user.setUsername(request.getUsername());
    user.setPassword(MD5Hash.digest(request.getPassword()).toString());
    
    user.setEmail(request.getEmail());
    user.setFullname(request.getFullname());
    user.setPhone(request.getPhone());
    
    user.setCreationDate(System.currentTimeMillis());
    user.setCreationDate(System.currentTimeMillis());
   
    user.setStatus(User.NONE);
    
    return user;
  }
  
}
