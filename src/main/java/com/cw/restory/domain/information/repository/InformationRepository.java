package com.cw.restory.domain.information.repository;

import com.cw.restory.domain.information.entity.Information;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InformationRepository extends JpaRepository<Information, Long> {

}
