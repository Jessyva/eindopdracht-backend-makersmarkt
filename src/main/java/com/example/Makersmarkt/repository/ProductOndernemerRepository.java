package com.example.Makersmarkt.repository;

import com.example.Makersmarkt.model.ProductOndernemer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOndernemerRepository extends JpaRepository<ProductOndernemer, Long> {
}
