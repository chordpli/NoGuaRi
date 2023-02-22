package com.chordpli.noguari.domain.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AirPollutionBody {

  private Integer totalCount;
  private List<AirPollutionItems> items;

}
