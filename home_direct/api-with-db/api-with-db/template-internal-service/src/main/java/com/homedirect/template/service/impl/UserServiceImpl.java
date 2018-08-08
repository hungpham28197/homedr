
package com.homedirect.template.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import com.homedirect.template.exception.CommonException;
import com.homedirect.template.model.User;
import com.homedirect.template.repository.UserRepository;
import com.homedirect.template.repository.exception.RepositoryException;
import com.homedirect.template.service.UserService;

/**
 *  Author : duy.bui
 * Oct 27, 2017
 */
@MessageEndpoint
public class UserServiceImpl  extends AbstractServiceImpl<User, String, UserRepository> implements UserService {
  
  private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
  @ServiceActivator(inputChannel = "user-registry-channel-4-service")
  public String registryUser(User user) {
    repo.save(user);
    return user.getUsername();
  }

  	@ServiceActivator(inputChannel = "user-login-channel-4-service")
	public String checkLogin(User user) throws CommonException {
  		
		Optional<User> optionalUser = get(user.getUsername());
				
		if(optionalUser.get().getPassword().equalsIgnoreCase(user.getPassword())) {
			return user.getUsername();
		}
		
		throw new RepositoryException(RepositoryException.WRONG_PASSWORD, RepositoryException.WRONG_PASSWORD_DESCRIPTION);	
	}
}
