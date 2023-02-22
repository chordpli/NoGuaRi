package com.chordpli.noguari.controller;

import com.chordpli.noguari.domain.dto.FinalResponse;
import com.chordpli.noguari.domain.dto.FineDustDataResponse;
import com.chordpli.noguari.service.AirPollutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class ApiController {

  private final AirPollutionService airPollutionService;

  @GetMapping()
  public String index(){
    return null;
  }

  @GetMapping("/v1/{sidoName}/{stationName}")
  public ResponseEntity<FineDustDataResponse> fineDust(@PathVariable String sidoName,
      @PathVariable String stationName) {
    FinalResponse list = airPollutionService.getAirPollutionData(sidoName);
    FineDustDataResponse response = airPollutionService.getFineDustData(list, stationName);
    return ResponseEntity.ok().body(response);
  }

  @GetMapping("/v1/{sidoName}")
  public void getStationName(@PathVariable String sidoName) {
    FinalResponse list = airPollutionService.getAirPollutionData(sidoName);
    airPollutionService.saveStationName(list);
  }

}
