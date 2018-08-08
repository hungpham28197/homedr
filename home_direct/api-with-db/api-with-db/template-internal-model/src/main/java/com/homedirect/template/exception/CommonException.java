package com.homedirect.template.exception;

public class CommonException  extends Exception {

  private static final long serialVersionUID = 1L;

  protected int code;

  private Object data;

  public CommonException(int code) {
    this.code = code;
  }

  public CommonException(int code, String message) {
    super(message);
    this.code = code;
  }

  public CommonException(int code, Object data, String message) {
    super(data + ": " + message);
    this.code = code;
    this.data = data;
  }

  public int getCode() { return code; }
  public void setCode(int code) { this.code = code; }

  public Object getData() { return data; }
  public void setData(Object data) { this.data = data; }

  public String toString(){
    return getClass().getSimpleName() +" Error-Code:" + code + ", Data:" + data + ", Message:" + getMessage();
  }
}