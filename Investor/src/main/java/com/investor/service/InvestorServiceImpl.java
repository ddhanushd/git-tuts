package com.investor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.investor.model.Investor;
import com.investor.repository.InvestorRepository;

@Service
public class InvestorServiceImpl implements InvestorService {
	
	@Autowired
	InvestorRepository investorRepo;

	@Override
	public void addInvestor(Investor investor) {
		investorRepo.save(investor);
		
	}

	@Override
	public List<Investor> getallInvestors() {
		List<Investor> investor=investorRepo.findAll();
		return investor;
	}

//	@Override
//	public Investor findInvestorById(int id) {
//		Investor investor=investorRepo.findById(id).get();
//		return investor;
//	}
	@Override
	public Optional<Investor> findInvestorById(int id) {
		return investorRepo.findById(id);
	}

	@Override
	public void deleteInvestor(int id) {
		investorRepo.deleteById(id);
		
	}

	@Override
	public void updateInvestor(int id, Investor investor) {
		Investor investor1=investorRepo.findById(id).get();
		investor1.setInvestorName(investor.getInvestorName());
		investor1.setUsername(investor.getUsername());
		investor1.setPassword(investor.getPassword());
		investor1.setInvestorPhoneno(investor.getInvestorPhoneno());
		investor1.setInvestorEmail(investor.getInvestorEmail());
		investor1.setInvestorAddress(investor.getInvestorAddress());
		investorRepo.save(investor1);
	}

}
