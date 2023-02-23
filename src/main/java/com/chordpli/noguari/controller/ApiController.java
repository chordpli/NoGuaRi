package com.chordpli.noguari.controller;

import com.chordpli.noguari.domain.dto.airpollution.FinalResponse;
import com.chordpli.noguari.domain.dto.FineDustDataResponse;
import com.chordpli.noguari.domain.dto.StationResponse;
import com.chordpli.noguari.service.AirPollutionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class ApiController {

  private final AirPollutionService airPollutionService;

  /**
   * 메인 페이지입니다.
   *
   * @param model
   * @return
   */
  @GetMapping()
  public String index(Model model) {
    List<String> sido = airPollutionService.getSidoNames();
    model.addAttribute("sido", sido);
    return "index";
  }

  /**
   * 시, 도, 관측소 정보를 입력하여 해당 지역의 미세먼지 정보를 받아옵니다.
   *
   * @param sidoName
   * @param stationName
   * @return
   */
  @GetMapping("/v1/result/{sidoName}/{stationName}")
  @ResponseBody
  public FineDustDataResponse result(@PathVariable String sidoName,
      @PathVariable String stationName) {
    FinalResponse list = airPollutionService.getAirPollutionData(sidoName);
    return airPollutionService.getFineDustData(list, stationName);
  }

  /**
   * 시, 도의 이름이 주어졌을 때, DB에 저장되어 있는 관측소 정보를 받아옵니다.
   * @param sidoName
   * @return
   */
  @GetMapping("/v1/{sidoName}")
  @ResponseBody
  public List<StationResponse> getStationName(@PathVariable String sidoName) {
    return airPollutionService.getStationName(sidoName);
  }

  /**
   * 시, 도에 속해 있는 관측소 정보를 받아와서 DB에 저장하는 api입니다.
   * 
   * @param sidoName 시, 도 이름
   */
  @PostMapping("/v1/add/station/{sidoName}")
  public void saveStationName(@PathVariable String sidoName) {
    FinalResponse list = airPollutionService.getAirPollutionData(sidoName);
    airPollutionService.saveStationName(list);
  }
}