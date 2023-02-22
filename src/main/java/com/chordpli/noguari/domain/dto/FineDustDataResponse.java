package com.chordpli.noguari.domain.dto;

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
  private Object pm10Value;
  private Object pm25Value;
  private Object pm10Grade1h;
  private Object pm25Grade1h;
}
