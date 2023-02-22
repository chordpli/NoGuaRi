package com.chordpli.noguari.client;

import com.chordpli.noguari.domain.dto.FinalResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "air", url = "${application.api.baseUrl}")
public interface AirPollutionClient {
  @RequestMapping(method = RequestMethod.GET,
      value = "/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty")
  FinalResponse getPollution(
      @RequestParam(value = "ServiceKey") String serviceKey,
      @RequestParam(value = "returnType") String returnType,
      @RequestParam(value = "numOfRows") String numOfRows,
      @RequestParam(value = "pageNo") String pageNo,
      @RequestParam(value = "sidoName") String sidoName,
      @RequestParam(value = "ver") String ver);
}
