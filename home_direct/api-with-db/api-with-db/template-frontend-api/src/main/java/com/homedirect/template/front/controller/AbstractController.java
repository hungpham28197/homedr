package com.homedirect.template.front.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.homedirect.template.exception.CommonException;
import com.homedirect.template.response.ResponseCode;
import com.homedirect.template.response.TemplateResponse;

/**
 * Author: duy.bui
 *    Email: duy.bui@homedirect.com.vn
 * Dec 28, 2016
 */
public abstract class AbstractController<S> {

  protected final Logger LOGGER;

  @Autowired
  protected S gateway;

  public AbstractController() {
    LOGGER = LoggerFactory.getLogger(getClass());
  }

  protected <T> TemplateResponse<T> toResult(T t) {
    TemplateResponse<T> response = new TemplateResponse<T>();
    response.setCode(ResponseCode.SUCCESS);
    response.setDescription(ResponseCode.SUCCESS_DESCRIPTION);
    response.setData(t);
    return response;
  }

  protected <T> TemplateResponse<T> toResult(int errorCode, String message, T t) {
    TemplateResponse<T> response = new TemplateResponse<T>();
    response.setCode(errorCode);
    response.setDescription(message);
    response.setData(t);
    return response;
  }

  protected <T> TemplateResponse<T> toResult(Exception exp) {
    if (exp instanceof CommonException) {
      LOGGER.error(exp.getMessage());
      CommonException commonException = (CommonException) exp;
      return create(commonException);
    }

    Throwable throwable = exp.getCause();
    LOGGER.info("\n throwable: {} ", throwable);
    if(throwable != null) {
      if(throwable instanceof CommonException || (throwable = throwable.getCause()) instanceof CommonException ) {
        LOGGER.error(exp.getMessage());
        CommonException ux = (CommonException) throwable;
        return create(ux);
      }
    }

    LOGGER.error(exp.getMessage(), exp);
    return create(new CommonException(ResponseCode.UNKNOWN_ERROR_CODE, ResponseCode.UNKNOWN_ERROR_DESCRIPTION));
  }

  @SuppressWarnings("unchecked")
  private <T> TemplateResponse<T> create(CommonException ex) {
    TemplateResponse<T> response = new TemplateResponse<T>();
    response.setCode(ex.getCode());
    response.setDescription(ex.getMessage());

    response.setData((T) ex.getData());

    return response;
  }

}