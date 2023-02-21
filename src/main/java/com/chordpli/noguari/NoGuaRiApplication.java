package com.chordpli.noguari;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class NoGuaRiApplication {

  public static void main(String[] args) {
    SpringApplication.run(NoGuaRiApplication.class, args);
  }

}
