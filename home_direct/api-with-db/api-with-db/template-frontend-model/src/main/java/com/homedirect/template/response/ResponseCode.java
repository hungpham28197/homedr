/***************************************************************************
 * Copyright 2016 by HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.homedirect.template.response;

/**
 *  Author : Nhu Dinh Thuan
 *          Email:thuan.nhu@homedirect.com.vn
 * Nov 15, 2017
 */
public class ResponseCode {

  public static final int UNKNOWN_ERROR_CODE = -1;

  public static final String UNKNOWN_ERROR_DESCRIPTION = "Unknown Error!";

  public static final int SUCCESS = 01;

  public static final String SUCCESS_DESCRIPTION = "Successful!";
  
  public static final int EMPTY_DATA_ERROR = 02;

  public static final String EMPTY_DATA_ERROR_DESCRIPTION = "Data is empty!";
  
  public static final int USER_REGISTRY_NOT_MATCHED_PASSWORD_ERROR = 12;

  public static final String USER_REGISTRY_NOT_MATCHED_PASSWORD_ERROR_DESCRIPTION = "Password Not Match!";
}
