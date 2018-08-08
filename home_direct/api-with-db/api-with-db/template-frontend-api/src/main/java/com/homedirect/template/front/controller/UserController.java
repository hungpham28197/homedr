
package com.homedirect.template.front.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.homedirect.template.exception.CommonException;
import com.homedirect.template.front.gateway.AccountGateway;
import com.homedirect.template.request.UserLoginRequest;
import com.homedirect.template.request.UserRegistryRequest;
import com.homedirect.template.response.TemplateResponse;

/**
 *  Author : duy.bui
 * Oct 27, 2017
 */
@RestController()
public class UserController extends AbstractController<AccountGateway> {

  @PostMapping("/user/registry")
  public @ResponseBody TemplateResponse<String> registry(@RequestBody UserRegistryRequest request) {
    try {
      return toResult(gateway.registry(request));
    } catch (CommonException exp) {
      return toResult(exp);
    }
  }
  
  @PostMapping("/user/login")
  public @ResponseBody TemplateResponse<String> login(@RequestBody UserLoginRequest request) {
    try {
      return toResult(gateway.login(request));
    } catch (CommonException exp) {
      return toResult(exp);
    }
  }
  
}
