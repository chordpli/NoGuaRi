package com.chordpli.noguari.domain.dto;

import com.chordpli.noguari.domain.dto.airpollution.AirPollutionItems;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class FineDustDataResponse {

  private Object sido;
  private Object stationName;
  private Integer pm10Value;
  private Integer pm25Value;
  private String pm10Grade1h;
  private String pm25Grade1h;

  public static FineDustDataResponse fromEntity(AirPollutionItems airPollutionItem) {
    int pm10Value = Integer.parseInt(airPollutionItem.getPm10Value().toString());
    int pm25Value = Integer.parseInt(airPollutionItem.getPm25Value().toString());
    String pm10Grade = "";
    String pm25Grade = "";
    pm10Grade = getPm10Grade(pm10Value);
    pm25Grade = getPm25Grade(pm25Value);

    return FineDustDataResponse.builder()
        .sido(airPollutionItem.getSidoName())
        .stationName(airPollutionItem.getStationName())
        .pm10Value(pm10Value)
        .pm10Grade1h(pm10Grade)
        .pm25Value(pm25Value)
        .pm25Grade1h(pm25Grade)
        .build();
  }

  private static String getPm25Grade(int pm25Value) {
    String pm25Grade;
    if (0 <= pm25Value && pm25Value <= 15) {
      pm25Grade = "좋음";
    } else if (pm25Value <= 35) {
      pm25Grade = "보통";
    } else if (pm25Value <= 75) {
      pm25Grade = "나쁨";
    } else if (75 < pm25Value) {
      pm25Grade = "매우나쁨";
    } else {
      pm25Grade = "정보없음";
    }
    return pm25Grade;
  }

  private static String getPm10Grade(int pm10Value) {
    String pm10Grade;
    if (0 <= pm10Value && pm10Value <= 30) {
      pm10Grade = "좋음";
    } else if (pm10Value <= 80) {
      pm10Grade = "보통";
    } else if (pm10Value <= 150) {
      pm10Grade = "나쁨";
    } else if (pm10Value > 150) {
      pm10Grade = "매우나쁨";
    } else {
      pm10Grade = "정보없음";
    }
    return pm10Grade;
  }
}
