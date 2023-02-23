package com.chordpli.noguari.domain.dto;

import com.chordpli.noguari.domain.entity.Station;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class StationResponse {

  private String stationName;

  public static StationResponse fromEntity(Station station) {
    return StationResponse.builder()
        .stationName(station.getStationName())
        .build();
  }
}