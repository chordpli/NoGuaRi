package com.chordpli.noguari.client;

import feign.Logger;
import feign.Logger.Level;
import feign.codec.Decoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

  @Bean
  Logger.Level feignLoggerLevel(){
    return Level.FULL;
  }

  @Bean
  Decoder feignDecoder(){
    return new ApiDecoder();
  }

}
