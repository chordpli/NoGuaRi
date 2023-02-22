package com.chordpli.noguari.domain.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Station {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer stationNo;
  private String stationName;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "sido_no")
  private Sido sido;
}
