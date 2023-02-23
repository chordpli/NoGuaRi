package com.chordpli.noguari.repository;

import com.chordpli.noguari.domain.entity.Station;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Integer> {

  List<Station> findAllBySido_SidoNameOrderByStationNameAsc(String sidoName);
}
