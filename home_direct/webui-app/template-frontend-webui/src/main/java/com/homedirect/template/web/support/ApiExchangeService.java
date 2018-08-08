package com.homedirect.template.web.support;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.homedirect.template.response.ResponseCode;
import com.homedirect.template.response.TemplateResponse;

/**
 *  Author : Nhu Dinh Thuan
 *          Email:thuan.nhu@homedirect.com.vn
 * Jul 25, 2017
 */
@Component
public class ApiExchangeService {

  protected Environment env;

  @Autowired
  protected RestTemplate restTemplate;

  private final static Logger logger = LoggerFactory.getLogger(ApiExchangeService.class);
  
  private String address;

  private ObjectMapper MAPPER = new ObjectMapper();

  @Autowired
  public ApiExchangeService(Environment env, HttpClient httpClient) {
    this.env = env;
    this.address = env.getProperty("frontend.api.url");
    logger.info("\n Call Front End Url === "  +  this.address + "\n");
    restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient));
  }
  

  public RestTemplate getTemplate() { return restTemplate; }

  public String createURL(String...paths) {
    StringBuilder builder = new StringBuilder(address);
    for (String path : paths) {
      builder.append('/').append(path);
    }
    return builder.toString();
  }

  public UriComponentsBuilder buildUrl(String...paths) {
    String url = createURL(paths);
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
    return builder;
  }
  
  protected String createURL(String ctx, String action) {
    return address + "/" + ctx + "/" + action ;
  }

  public <V> ResponseEntity<TemplateResponse<V>> post(HttpServletRequest httpRequest, String url, Object request) {
    return post(httpRequest, url, request, new TypeReference<TemplateResponse<V>>(){});
  }

  public <V> ResponseEntity<TemplateResponse<V>> post(HttpServletRequest httpRequest, String url, Object request, TypeReference<?> reference) {
    try {
      HttpEntity<Object> requestEntity = createEntity(httpRequest, request);

      ResponseEntity<String> entity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
      TemplateResponse<V> response =  MAPPER.readValue(entity.getBody(), reference);

      return new ResponseEntity<TemplateResponse<V>>(response, HttpStatus.OK);
    } catch (HttpClientErrorException e) {
      logger.error(e.getMessage(), e);
      return new ResponseEntity<TemplateResponse<V>>(e.getStatusCode());
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
      return new ResponseEntity<TemplateResponse<V>>(HttpStatus.UNPROCESSABLE_ENTITY);
    } catch (Exception e) {
      logger.error(e.getMessage());
      if(Integer.valueOf(e.getMessage().trim()) == HttpServletResponse.SC_SERVICE_UNAVAILABLE){
        return new ResponseEntity<TemplateResponse<V>>(HttpStatus.FORBIDDEN);
      }
      return new ResponseEntity<TemplateResponse<V>>(HttpStatus.BAD_REQUEST);
    }
  }

  public <V> Optional<V> getForObject(HttpServletRequest httpRequest, String url, TypeReference<TemplateResponse<V>> reference) {
    try {
      TemplateResponse<V> response = this.<V>get(httpRequest, url, reference);
      if(isUnSuccessResponse(response))  return Optional.empty();
      return Optional.of(response.getData());
    } catch (RestClientException e) {
      logger.error(e.getMessage(), e);
      return Optional.empty();
    } 
  }

  public <V> Optional<V> getForObject(HttpServletRequest httpRequest, URI uri, TypeReference<TemplateResponse<V>> reference) {
    try {
      TemplateResponse<V> response = get(httpRequest, uri.toURL().toString(), reference);
      if(isUnSuccessResponse(response)) return Optional.empty();
      return Optional.of(response.getData());
    } catch (RestClientException|MalformedURLException e) {
      logger.error(e.getMessage(), e);
      return Optional.empty();
    } 
  }

  public <T> TemplateResponse<T> get(HttpServletRequest httpRequest, URI uri, TypeReference<?> reference) throws RestClientException {
    try {
      return get(httpRequest, uri.toURL().toString(), reference);
    } catch (MalformedURLException e) {
      logger.error(e.getMessage(), e);
      return null;
    } 
  }

  public <T> TemplateResponse<T> get(HttpServletRequest httpRequest, String url, TypeReference<?> reference) throws RestClientException {
    HttpEntity<?> entity = createEntity(httpRequest);
    //    logger.info("GET from URL ---> "+ url + " : " + headers.getFirst("User-Agent"));
    ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    try {
      return MAPPER.readValue(response.getBody(), reference);
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
      return null;
    }
  }

  public boolean isUnSuccessResponse(TemplateResponse<?> response) {
    return Integer.valueOf(response.getCode()) != ResponseCode.SUCCESS || response.getData() == null;
  }
  
  private HttpHeaders transfer(HttpServletRequest httpRequest) {
    HttpHeaders headers = new HttpHeaders();
    headers.set("User-Agent", httpRequest.getHeader("User-Agent"));
    headers.set("X-Forwarded-For", httpRequest.getRemoteAddr());
    return headers;
  }
  
  private HttpEntity<Object> createEntity(HttpServletRequest httpRequest) {
    return new HttpEntity<Object>(transfer(httpRequest));
  }
  
  private HttpEntity<Object> createEntity(HttpServletRequest httpRequest, Object data) {
    HttpHeaders headers = transfer(httpRequest);
    return new HttpEntity<Object>(data, headers);
  }

}
