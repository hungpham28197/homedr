/***************************************************************************
 * Copyright 2016 by HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.homedirect.template.repository.exception;

import com.homedirect.template.exception.CommonException;

/**
 *  Author : Nhu Dinh Thuan
 *          Email:thuan.nhu@homedirect.com.vn
 * Nov 1, 2017
 */
public class RepositoryException extends CommonException {
  
  public static final int DUPLICATED_ERROR = 32;
  
  public static final int NOT_FOUND_ERROR = 30;
  
  public static final String NOT_FOUND_ERROR_DESCRIPTION = "Not Found Account!";

  public static final int WRONG_PASSWORD = 31;
  
  public static final String WRONG_PASSWORD_DESCRIPTION = "Wrong Password!";
  
  public static final String DUPLICATED_ERROR_DESCRIPTION = "Duplicated Data!";

  private static final long serialVersionUID = 8300417997332022872L;

  public RepositoryException(int code) {
    super(code);
  }

  public RepositoryException(int code, String message) {
    super(code, message);
  }

  public RepositoryException(int code, Object data, String message) {
    super(code, data, message);
  }

}
