/***************************************************************************
 * Copyright 2016 by HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.homedirect.template.front.validator;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.util.StringUtils;

import com.homedirect.template.exception.CommonException;
import com.homedirect.template.request.UserRegistryRequest;
import com.homedirect.template.response.ResponseCode;

/**
 *  Author : Nhu Dinh Thuan
 *          Email:thuan.nhu@homedirect.com.vn
 * Nov 15, 2017
 */
@MessageEndpoint
public class UserRegistryInputValidator {

  @ServiceActivator(inputChannel = "user-registry-channel-1-validate-input", outputChannel = "user-registry-channel-2-transform")
  public UserRegistryRequest validate(UserRegistryRequest request) throws CommonException {
    if(StringUtils.isEmpty(request.getUsername())) {
      throw new CommonException(ResponseCode.EMPTY_DATA_ERROR, "username", ResponseCode.EMPTY_DATA_ERROR_DESCRIPTION);
    }
    if(StringUtils.isEmpty(request.getPassword())) {
      throw new CommonException(ResponseCode.EMPTY_DATA_ERROR, "password", ResponseCode.EMPTY_DATA_ERROR_DESCRIPTION);
    }
    
    if(!request.getPassword().equalsIgnoreCase(request.getRePassword())) {
      throw new CommonException(ResponseCode.USER_REGISTRY_NOT_MATCHED_PASSWORD_ERROR,
                        "password", ResponseCode.USER_REGISTRY_NOT_MATCHED_PASSWORD_ERROR_DESCRIPTION);
    }
    return request;
  }
}
