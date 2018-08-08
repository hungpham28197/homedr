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

@MessageEndpoint
public class UserLoginStorageValidator {
	
	private static Logger logger = LoggerFactory.getLogger(UserLoginStorageValidator.class);
	
	@Autowired
	  private UserService userService;

	  @ServiceActivator(inputChannel = "user-login-channel-3-validate-storage", outputChannel = "user-login-channel-4-service")
	 public User validate(User user) throws CommonException {
	    Optional<User> optional = userService.get(user.getUsername());
	    if(!optional.isPresent()) {
	      throw new RepositoryException(RepositoryException.NOT_FOUND_ERROR, RepositoryException.NOT_FOUND_ERROR_DESCRIPTION); 
	    }
	    return user;
	  }
}
