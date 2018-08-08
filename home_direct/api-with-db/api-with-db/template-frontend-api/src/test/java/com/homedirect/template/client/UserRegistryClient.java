/***************************************************************************
 * Copyright 2016 by HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.homedirect.template.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.homedirect.template.request.UserRegistryRequest;

/**
 *  Author : Nhu Dinh Thuan
 *          Email:thuan.nhu@homedirect.com.vn
 * Nov 15, 2017
 */
public class UserRegistryClient {
  
  public static void main(String[] args) {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders httpHeaders = new HttpHeaders();
    
    String url = "http://localhost:8080/user/registry";
    
    UserRegistryRequest request = new UserRegistryRequest();
    HttpEntity<UserRegistryRequest> entityWithBody = new HttpEntity<>(request, httpHeaders);
    ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entityWithBody, String.class);
    System.out.println(response.getBody());
    
    request.setUsername("test01");
    request.setPassword("123456");
    request.setRePassword("123456");
    request.setEmail("vana@gmail.com");
    request.setFullname("Nguyen Van A");
    response = restTemplate.exchange(url, HttpMethod.POST, entityWithBody, String.class);
    System.out.println(response.getBody());
    
    
  }
}
