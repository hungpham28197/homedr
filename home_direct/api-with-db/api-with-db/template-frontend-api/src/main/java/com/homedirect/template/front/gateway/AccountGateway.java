/***************************************************************************
 * Copyright 2016 by HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.homedirect.template.front.gateway;

import com.homedirect.template.exception.CommonException;
import com.homedirect.template.request.UserLoginRequest;
import com.homedirect.template.request.UserRegistryRequest;

/**
 *  Author : Nhu Dinh Thuan
 *          Email:thuan.nhu@homedirect.com.vn
 * Nov 15, 2017
 */
public interface AccountGateway {

  public String registry(UserRegistryRequest request) throws CommonException;
  public String login(UserLoginRequest request) throws CommonException;
}
