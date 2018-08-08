/***************************************************************************
 * Copyright 2017 by NDK - All rights reserved.                *    
 **************************************************************************/
package com.homedirect.template.web.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.homedirect.template.web.support.ApiExchangeService;

public class AbstractController {
  
  
//  private final static Logger logger = LoggerFactory.getLogger(AbstractController.class);

  @Autowired
  protected ApiExchangeService apiExchangeService;

  public AbstractController() {
  }

}
