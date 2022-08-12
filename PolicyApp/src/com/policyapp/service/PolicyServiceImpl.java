package com.policyapp.service;

import java.util.List;
import java.util.stream.Collectors;

import com.policyapp.dao.IPolicyDAO;
import com.policyapp.dao.PolicyDAOImpl;
import com.policyapp.exceptions.IdNotFoundException;
import com.policyapp.exceptions.PolicyNotFoundException;
import com.policyapp.model.Policy;

public class PolicyServiceImpl implements IPolicyService {

	IPolicyDAO policyDAO = new PolicyDAOImpl();

	@Override
	public List<Policy> getAll() {

		List<Policy> policies = policyDAO.findAll();
		policies.stream().sorted((Policy p1, Policy p2) -> p1.getPolicyName().compareToIgnoreCase(p2.getPolicyName()))
				.collect(Collectors.toList());

		return policies;
	}

	@Override
	public List<Policy> getByType(String type) throws PolicyNotFoundException {

		List<Policy> policies = policyDAO.findByType(type);

		List<Policy> policyType = policies.stream()
				
				.collect(Collectors.toList());

		if (policies.isEmpty()) {

			throw new PolicyNotFoundException("sorry policy not found");

		}
		return policyType;

	}

	@Override
	public List<Policy> getByCategory(String category) throws PolicyNotFoundException {

		List<Policy> policies = policyDAO.findByCategory(category);
		List<Policy> policyType = policies.stream()
				.sorted((Policy p1, Policy p2) -> p1.getCategory().compareToIgnoreCase(p2.getCategory()))
				.collect(Collectors.toList());

		if (policies.isEmpty()) {

			throw new PolicyNotFoundException("sorry policy not found");

		}
		return policyType;
		
	}

	@Override
	public List<Policy> getByHighSumAssured(double sumAssured) throws PolicyNotFoundException {
		List<Policy> policies = policyDAO.findByHighSumAssured(sumAssured);
		//List<Policy> policyType = policies.stream()
			//	.collect(Collectors.toList());

		if (policies.isEmpty()) {

			throw new PolicyNotFoundException("sorry policy not found");

		}
		return policies;
		
	}

	@Override
	public List<Policy> getByCoverage(String coverage) throws PolicyNotFoundException {
		List<Policy> policies = policyDAO.findByCoverage(coverage);
//		List<Policy> policyType = policies.stream()
//				.collect(Collectors.toList());

		if (policies.isEmpty()) {

			throw new PolicyNotFoundException("sorry policy not found");

		}
		return policies;
	}

	@Override
	public List<Policy> getByLessPremium(double premium) throws PolicyNotFoundException {
		
		List<Policy> policies = policyDAO.findByLessPremium(premium);
//		List<Policy> policyType = policies.stream()
//				.collect(Collectors.toList());

		if (policies.isEmpty()) {
			throw new PolicyNotFoundException("sorry policy not found");
		}
		return policies;
	}

	@Override
	public Policy getById(int policyId) throws IdNotFoundException {
		Policy policy = policyDAO.findById(policyId);
		if(policy==null) {
			throw new IdNotFoundException("sorry policy Id is not found");
		}
		return policy;
	}

}
