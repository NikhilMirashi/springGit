package com.policyapp.service;

import java.util.Arrays;
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
	public void addPolicy(Policy policy) {
		policyDAO.addPolicy(policy);
	}

	@Override
	public void deletePolicy(int policyId) {
		policyDAO.deletePolicy(policyId);
	}

	@Override
	public void updatePolicy(int policyId, String coverage) {
		policyDAO.updatePolicy(policyId, coverage);
	}

	@Override
	public List<Policy> getAll() {
		List<Policy> policyList = policyDAO.findAll();
		if (policyList != null) {
			return policyList.stream().sorted((Policy p1, Policy p2) -> p1.getType().compareToIgnoreCase(p2.getType())).collect(Collectors.toList());
		}
		return null;
	}

	@Override
	public List<Policy> getByType(String type) throws PolicyNotFoundException {
		
		List<Policy> policyList = policyDAO.findByType(type);
		if (policyList == null) {
			new PolicyNotFoundException("sorry policy not found");
		}

		return policyList.stream().sorted((Policy p1, Policy p2) -> p1.getType().compareToIgnoreCase(p2.getType())).collect(Collectors.toList());
	}

	@Override
	public List<Policy> getByCategory(String category) throws PolicyNotFoundException {
		
		List<Policy> policyList = policyDAO.findByCategory(category);

		if (policyList == null) {
			new PolicyNotFoundException("sorry policy not found");
		}

		return policyList.stream().sorted((Policy p1, Policy p2) -> p1.getCategory().compareToIgnoreCase(p2.getCategory())).collect(Collectors.toList());
		
	}

	@Override
	public List<Policy> getByHighSumAssured(double sumAssured) throws PolicyNotFoundException {
		List<Policy> policies = policyDAO.findByHighSumAssured(sumAssured);
		if (policies.isEmpty()) {
			throw new PolicyNotFoundException("sorry policy not found");
		}
		return policies.stream().sorted((Policy p1, Policy p2) -> p1.getType().compareToIgnoreCase(p2.getType())).collect(Collectors.toList());

	}

	@Override
	public List<Policy> getByCoverage(String coverage) throws PolicyNotFoundException {
		List<Policy> policies = policyDAO.findByCoverage(coverage);
		if (policies.isEmpty()) {
			throw new PolicyNotFoundException("sorry policy not found");
		}
		return policies.stream().sorted((Policy p1, Policy p2) -> p1.getCoverage().compareToIgnoreCase(p2.getCoverage())).collect(Collectors.toList());
		
	}

	@Override
	public List<Policy> getByLessPremium(double premium) throws PolicyNotFoundException {

		List<Policy> policies = policyDAO.findByLessPremium(premium);

		if (policies.isEmpty()) {

			throw new PolicyNotFoundException("sorry policy not found");

		}
		return policies.stream().sorted((Policy p1, Policy p2) -> p1.getType().compareToIgnoreCase(p2.getType())).collect(Collectors.toList());
		
	}

	@Override
	public Policy getById(int policyId) throws IdNotFoundException {
		Policy policy = policyDAO.findById(policyId);
		if(policy==null) {
			throw new IdNotFoundException("sorry policy Id is not found");
		}
		return policy;
		
	}

	@Override
	public Policy getByBrand(String brand) throws PolicyNotFoundException {
		Policy policy = policyDAO.findByBrand(brand);
		if(policy==null) {
			throw new PolicyNotFoundException("policy not found");
		}
		return policy;
	}

}
