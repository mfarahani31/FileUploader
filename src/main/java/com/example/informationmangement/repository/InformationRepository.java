package com.example.informationmangement.repository;

import com.example.informationmangement.model.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationRepository extends JpaRepository<Information,Long> {
}
