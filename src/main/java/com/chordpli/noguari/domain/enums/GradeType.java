package com.chordpli.noguari.domain.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum GradeType {
  GOOD(1, "좋음"),
  NORMAL(2, "보통"),
  BAD(3, "나쁨"),
  VERY_BAD(4, "매우 나쁨");

  private Integer grade;
  private String gradeName;
}
