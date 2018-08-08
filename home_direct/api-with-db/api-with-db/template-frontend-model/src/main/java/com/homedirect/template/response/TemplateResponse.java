package com.homedirect.template.response;
import java.io.Serializable;

public class TemplateResponse<T> implements Serializable {

  private static final long serialVersionUID = 1L;

  private int code;

  private String description;

  private T data;

  public TemplateResponse() {
  }

  public TemplateResponse(int code, String description) {
    this.code = code;
    this.description = description;
  }

  public TemplateResponse(int code, String description, T data) {
    this.code = code;
    this.description = description;
    this.data = data;
  }
  
  public int getCode() {return code;}
  public void setCode(int code) {this.code = code;}

  public String getDescription() {return description;}
  public void setDescription(String description) {this.description = description;}

  public T getData() { return data; }
  public void setData(T data) { this.data = data; }
  
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(code).append('|').append(description);
    builder.append('\n').append(data);
    return builder.toString();
  }
}
