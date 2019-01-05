package com.tss.http;
/**
 * @author huzaifa bhavnagri
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("spring-boot-http-client-request-response-json-parsing Application is started on endpoint http://localhost:8080/httpresponse/2 as default");
    }
}