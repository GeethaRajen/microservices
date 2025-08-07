package com.geetha.election.domain.repository;

import com.geetha.election.domain.entity.Election;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectionRepository extends JpaRepository<Election,Long> {
}
