package com.homedirect.template.front.validator;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.util.StringUtils;

import com.homedirect.template.exception.CommonException;
import com.homedirect.template.request.UserLoginRequest;
import com.homedirect.template.response.ResponseCode;

@MessageEndpoint
public class UserLoginInputValidator {
	@ServiceActivator(inputChannel = "user-login-channel-1-validate-input",outputChannel = "user-login-channel-2-transform")
	  public UserLoginRequest validate(UserLoginRequest request) throws CommonException {
	    if(StringUtils.isEmpty(request.getUsername())) {
	      throw new CommonException(ResponseCode.EMPTY_DATA_ERROR, "username", ResponseCode.EMPTY_DATA_ERROR_DESCRIPTION);
	    }
	    if(StringUtils.isEmpty(request.getPassword())) {
	      throw new CommonException(ResponseCode.EMPTY_DATA_ERROR, "password", ResponseCode.EMPTY_DATA_ERROR_DESCRIPTION);
	    }
	    return request;
	  }
}
