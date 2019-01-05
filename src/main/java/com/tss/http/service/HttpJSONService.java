package com.tss.http.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpJSONService {
  
  @Value("${http.json.url}") 
  String jsonResponseUrl;
  @Value("${http.json.contenttype}") 
  String contentType;
  
  public String getJSONResponse() { 
    try {
      ResponseEntity<String> responseEntity =
          new RestTemplate().exchange(jsonResponseUrl,
              HttpMethod.GET, new HttpEntity<>(getHttpHeaders()), String.class);
      return responseEntity.getBody();
    } catch (Exception e) {
      return null;
    }
  }
  
  private HttpHeaders getHttpHeaders() {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", contentType);
    return headers;
  }
}