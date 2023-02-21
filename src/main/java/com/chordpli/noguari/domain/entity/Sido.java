package com.chordpli.noguari.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Sido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer sidoNo;
  private String sidoName;
}
