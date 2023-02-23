package com.chordpli.noguari.service;

import com.chordpli.noguari.client.AirPollutionClient;
import com.chordpli.noguari.domain.dto.airpollution.AirPollutionItems;
import com.chordpli.noguari.domain.dto.airpollution.FinalResponse;
import com.chordpli.noguari.domain.dto.FineDustDataResponse;
import com.chordpli.noguari.domain.dto.StationResponse;
import com.chordpli.noguari.domain.entity.Sido;
import com.chordpli.noguari.domain.entity.Station;
import com.chordpli.noguari.repository.SidoRepository;
import com.chordpli.noguari.repository.StationRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AirPollutionService {

  @Value("${application.api.serviceKey}")
  private String serviceKey;
  @Value("${application.api.returnType}")
  private String returnType;
  @Value("${application.api.numOfRows}")
  private String numOfRows;
  @Value("${application.api.pageNo}")
  private String pageNo;
  @Value("${application.api.ver}")
  private String ver;

  private final AirPollutionClient airPollutionClient;
  private final SidoRepository sidoRepository;
  private final StationRepository stationRepository;

  public FinalResponse getAirPollutionData(String sidoName) {
    FinalResponse datas = airPollutionClient.getPollution(serviceKey, returnType, numOfRows,
        pageNo, sidoName, ver);
    return datas;
  }


  public FineDustDataResponse getFineDustData(FinalResponse list, String stationName) {
    List<AirPollutionItems> items = list.getResponse().getBody().getItems();
    AirPollutionItems airPollutionItem = items.stream()
        .filter(airPollutionItems -> airPollutionItems.getStationName().equals(stationName))
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);

    return FineDustDataResponse.fromEntity(airPollutionItem);
  }

  public void saveStationName(FinalResponse list) {
    List<AirPollutionItems> items = list.getResponse().getBody().getItems();
    Sido sido = sidoRepository.findBySidoName(items.get(0).getSidoName()).orElseThrow(
        () -> {
          throw new IllegalArgumentException();
        });

    List<Object> stationsName = items.stream()
        .map(AirPollutionItems::getStationName)
        .collect(Collectors.toList());

    for (Object stationName : stationsName) {
      Station station = Station.builder()
          .stationName((String) stationName)
          .sido(sido)
          .build();
      stationRepository.save(station);
    }
  }

  public List<String> getSidoNames() {
    List<Sido> sidos = sidoRepository.findAll();
    return sidos.stream()
        .map(Sido::getSidoName)
        .collect(Collectors.toList());
  }

  public List<StationResponse> getStationName(String sidoName) {
    List<Station> stations = stationRepository.findAllBySido_SidoName(sidoName);

    return stations.stream()
        .map(StationResponse::fromEntity)
        .collect(Collectors.toList());
  }
}
