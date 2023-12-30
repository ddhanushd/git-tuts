package com.investor.service;

import java.util.List;
import java.util.Optional;

import com.investor.model.Investor;

public interface InvestorService {
	void addInvestor(Investor investor);
	List<Investor> getallInvestors();
	//Investor findInvestorById(int id);
	Optional<Investor> findInvestorById(int id);
	void deleteInvestor(int id);
	void updateInvestor(int id, Investor investor);

}
