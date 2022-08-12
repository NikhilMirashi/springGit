package com.policyapp.client;

import java.util.List;
import java.util.Scanner;

import com.policyapp.dao.IPolicyDAO;
import com.policyapp.dao.PolicyDAOImpl;
import com.policyapp.exceptions.IdNotFoundException;
import com.policyapp.exceptions.PolicyNotFoundException;
import com.policyapp.model.Policy;
import com.policyapp.service.IPolicyService;
import com.policyapp.service.PolicyServiceImpl;

public class User {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		IPolicyService policyServices = new PolicyServiceImpl();
		//Policy policy1=new Policy("jeevan sathi", 1005, 2000, "term", 10, "marriage", "health", 500000,"tcs");
		//Policy policy6=new Policy("jeevan sathi", 1006, 2500, "ulip", 10, "marriage", "health", 800000,"infosys");
		Policy policy7=new Policy("jeevan shakthi", 1007, 2600, "term", 10, "marriage", "general", 600000,"tcs");
		System.out.println("enter the policy to be added: ");
		int choice=sc.nextInt();
		if(choice==1) {
			policyServices.addPolicy(policy7);
		}
		System.out.println();
		System.out.println("update opertaion");
		System.out.print("enter the coverage you want to set: ");
		String coverage=sc.next();
		System.out.print("enter the id you want to change the coverage: ");
		int policyId=sc.nextInt();
		policyServices.updatePolicy(policyId, coverage);
		
		System.out.println();
		System.out.println("select all from policy operation");
		IPolicyDAO policyDAOImpl = new PolicyDAOImpl();
		policyServices.getAll().forEach(System.out::println);
		
		
		System.out.println();
		System.out.println("delete from policy operation");
		System.out.print("enter the id you want to delete the policy: ");
		int dpolicyId=sc.nextInt();
		policyServices.deletePolicy(dpolicyId);
		
		List<Policy> policyList;
		try {
			System.out.println();
			System.out.println("find by type");
			policyServices.getByType("term").forEach(System.out::println);
			
			System.out.println();
			System.out.println("find by getByCategory");
			policyServices.getByCategory("life").forEach(System.out::println);
			
			System.out.println();
			System.out.println("find by getBySumAssured");
			policyServices.getByHighSumAssured(200).forEach(System.out::println);
			
			System.out.println();
			System.out.println("find by getById");
			Policy policy=policyServices.getById(1);
			System.out.println(policy);
			
			System.out.println();
			System.out.println("find by getByLessPremium");
			policyServices.getByLessPremium(2000).forEach(System.out::println);
			
			System.out.println();
			System.out.println("find by getByCoverage");
			policyServices.getByCoverage("marriage").forEach(System.out::println);
			
			System.out.println();
			System.out.println("find by getByBrand");
			System.out.println(policyServices.getByBrand("tata"));
			
			
		} catch (PolicyNotFoundException e) {
			e.printStackTrace();
		} catch (IdNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
