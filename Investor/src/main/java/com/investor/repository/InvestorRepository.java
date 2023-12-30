package com.investor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.investor.model.Investor;
import java.util.List;
import java.util.Optional;


@Repository
public interface InvestorRepository extends JpaRepository<Investor, Integer> {
	Optional<Investor> findByinvestorName(String name);

}
