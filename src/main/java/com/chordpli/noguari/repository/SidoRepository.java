package com.chordpli.noguari.repository;

import com.chordpli.noguari.domain.entity.Sido;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SidoRepository extends JpaRepository<Sido, Integer> {

  Optional<Sido> findBySidoName(Object sidoName);
}
