/***************************************************************************
 * Copyright 2017 by HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.homedirect.template.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *  Author : duy.bui
 *          Email:duy.bui@homedirect.com.vn
 * Dec 28, 2016
 */

public abstract class AbstractServiceImpl<T, ID extends Serializable, R extends JpaRepository<T, ID>> {

  protected Logger LOGGER;

  @Autowired
  protected R repo;
  
  @Autowired
  protected Environment env;

  public AbstractServiceImpl() {
    LOGGER = LoggerFactory.getLogger(getClass());
  }

  public Optional<T> save(T t) throws IllegalArgumentException {
    LOGGER.info("\n\n ----> save record: {} \n\n", t.toString());
    t = repo.save(t);
    return Optional.of(t);
  }

  public Optional<T> get(ID id) {
    T t =  repo.findOne(id);
    return Optional.ofNullable(t);
  }

  public Optional<T> delete(ID id) {
    T t = repo.findOne(id);

    if(t != null) {
      repo.delete(id);
    }
    return Optional.ofNullable(t);
  }

}

