package com.policyapp.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.policyapp.exceptions.IdNotFoundException;
import com.policyapp.exceptions.PolicyNotFoundException;
import com.policyapp.model.Policy;

public class PolicyDAOImpl implements IPolicyDAO {

	@Override
	public List<Policy> findAll() {
		return showAllPolicies();
	}

	@Override
	public List<Policy> findByType(String type) throws PolicyNotFoundException {
		return showAllPolicies().stream().filter((policyType)->policyType.getType().equalsIgnoreCase(type)).collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByCategory(String category) throws PolicyNotFoundException {
		return showAllPolicies().stream().filter((policyCategory)->policyCategory.getCategory().equalsIgnoreCase(category)).collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByHighSumAssured(double sumAssured) throws PolicyNotFoundException {
		return  showAllPolicies().stream().filter((s)->s.getSumAssured()>(sumAssured)).collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByCoverage(String coverage) throws PolicyNotFoundException {
		return showAllPolicies().stream().filter((policyCoverage)->policyCoverage.getCoverage().equalsIgnoreCase(coverage)).collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByLessPremium(double premium) throws PolicyNotFoundException {
		return showAllPolicies().stream().filter((s)->s.getPremium()<(premium)).collect(Collectors.toList());
	}

	@Override
	public Policy findById(int policyId) throws IdNotFoundException {
		Optional<Policy> policy= showAllPolicies().stream().filter((s)->s.getPolicyNumber()==(policyId)).findFirst();
		
		if(policy.isPresent()) {
			return policy.get();
		}
		return null;
	}
	
	private List<Policy> showAllPolicies(){
		
		return Arrays.asList(
				new Policy("jeevan sathi", 1001, 2000, "term", 10, "marriage", "general", 200000),
				new Policy("jeevan anand", 1002, 3000, "endowment", 10, "marriage", "life", 500000),
				new Policy("jeevan sathi", 1003, 1600, "pension", 10, "marriage", "general", 200000),
				new Policy("jeevan sathi", 1004, 2000, "endowment", 10, "marriage", "motor", 200000),
				new Policy("jeevan sathi", 1005, 2000, "term", 10, "marriage", "health", 500000),
				new Policy("jeevan sathi", 1006, 2500, "ulip", 10, "marriage", "health", 800000),
				new Policy("jeevan shakthi", 1007, 2600, "term", 10, "marriage", "general", 600000));
				
		
	}

}
