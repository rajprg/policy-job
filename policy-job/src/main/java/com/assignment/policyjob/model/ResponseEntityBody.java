package com.assignment.policyjob.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEntityBody {
  public ResponseEntityBody(HttpStatus status, String message, String path, int statusCode, Object data) {
    this.status = status;
    this.message = message;
    this.path = path;
    this.statusCode = statusCode;
    this.data = data;
  }
  private HttpStatus status;
  private String message;
  private String path;



  private int statusCode;
  private Object data;
  private String body;

}
