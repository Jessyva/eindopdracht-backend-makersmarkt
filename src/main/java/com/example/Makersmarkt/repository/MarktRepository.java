package com.example.Makersmarkt.repository;

import com.example.Makersmarkt.model.Markt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarktRepository extends JpaRepository<Markt, Long> {
}
