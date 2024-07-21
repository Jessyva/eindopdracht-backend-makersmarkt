package com.example.Makersmarkt.repository;

import com.example.Makersmarkt.model.MarktOndernemer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarktOndernemerRepository extends JpaRepository<MarktOndernemer, Long> {
}
