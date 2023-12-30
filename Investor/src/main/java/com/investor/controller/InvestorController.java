package com.investor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.investor.exception.InvestorNotFoundException;
import com.investor.model.Investor;
import com.investor.repository.InvestorRepository;
import com.investor.service.InvestorService;


@RestController
@RequestMapping(value="/v1")
public class InvestorController {
	
	@Autowired
	InvestorService investorservice;
	
	@Autowired
	InvestorRepository investoryRepo;
	
	@GetMapping("/loadinvestors")
	public String loadInvestors() {
		return "Investor Details!";
	}
	
	@PostMapping("/addinvestor")
	public void addInvestors(@RequestBody Investor investor) {
		investorservice.addInvestor(investor);
	}
	
	@GetMapping("/loadallinvestors")
	public List<Investor> getAllInvestors(){
		List<Investor>investor= investorservice.getallInvestors();
		return investor;
	}
	
//	@GetMapping("/investor/{id}")
//		public Investor getInvestorById(@PathVariable int id) {
//			Investor investor=investorservice.findInvestorById(id);
//			return investor;
//	}
	@GetMapping("/investor/{id}")
	public ResponseEntity<Investor> getInvestorById(@PathVariable int id){
		Optional<Investor> investor=investorservice.findInvestorById(id);
		if(investor.isPresent()) {
			return ResponseEntity.ok(investor.get());
		}
		throw new InvestorNotFoundException("Investor Not Found");
	}
	
//	@GetMapping("/investors/{name}")
//	public Investor getInvestorByName(@PathVariable String name) {
//		Investor investor=investoryRepo.findByinvestorName(name);
//		return investor;
//	}
	@GetMapping("/investors/{name}")
	public ResponseEntity<Investor> getInvestorByname(@PathVariable String name){
		Optional<Investor> investor=investoryRepo.findByinvestorName(name);
		if(investor.isPresent()) {
			return ResponseEntity.ok(investor.get());
		}
		throw new InvestorNotFoundException("Investor Not Found"); 
		
	}
	@DeleteMapping("/delete/{id}")
	public void deleteInvestors(@PathVariable int id) {
		investorservice.deleteInvestor(id);
	}
	
//	@PutMapping("update/{id}")
//		public Investor updateInvestor(@RequestBody Investor investor, @PathVariable int id) {
//			investorservice.updateInvestor(id, investor);
//			return investor;
//	}
	@PutMapping("update/{id}")
	public ResponseEntity<Investor> updateInvestor(@RequestBody Investor investor, @PathVariable int id){
		Optional<Investor> investor1=investoryRepo.findById(id);
		if(investor1.isPresent()) {
			investorservice.updateInvestor(id, investor);
			return ResponseEntity.ok(investor1.get());
		}
		throw new InvestorNotFoundException("Investor Not Found"); 
	}
	}

    


