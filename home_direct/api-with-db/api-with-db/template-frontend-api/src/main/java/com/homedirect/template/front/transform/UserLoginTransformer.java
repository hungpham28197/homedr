package com.homedirect.template.front.transform;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import com.homedirect.template.model.User;
import com.homedirect.template.request.UserLoginRequest;
import com.homedirect.template.util.MD5Hash;

@MessageEndpoint
public class UserLoginTransformer {
	@ServiceActivator(inputChannel = "user-login-channel-2-transform", outputChannel = "user-login-channel-3-validate-storage")
	  public User fromRequest(UserLoginRequest request) {
	    User user = new User();
	    
	    user.setUsername(request.getUsername());
	    user.setPassword(MD5Hash.digest(request.getPassword()).toString());
	    
	    return user;
	  }
}
