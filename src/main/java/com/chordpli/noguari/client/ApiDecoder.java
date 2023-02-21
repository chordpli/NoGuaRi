package com.chordpli.noguari.client;

import com.google.gson.Gson;
import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import feign.gson.GsonDecoder;
import java.io.IOException;
import java.lang.reflect.Type;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApiDecoder implements Decoder {

  @Override
  public Object decode(Response response, Type type)
      throws IOException, DecodeException, FeignException {

    if (response.status() == 200) {
      log.info("==== 200 ====");

      log.info("==== Type ====");
      log.info(type.getTypeName().toString());

      log.info("==== header ====");
      log.info(response.headers().toString());
      log.info(response.reason().toString());
      log.info(response.reason().toString());
      log.info(response.reason().toString());
      log.info(response.reason().toString());
      log.info(response.reason().toString());
      log.info(response.reason().toString());
      log.info(response.reason().toString());
    } else {
      log.info("=========== 상태 확인" + String.valueOf(response.status()) + " =============");

    }

    return new GsonDecoder().decode(response, type);
  }
}
