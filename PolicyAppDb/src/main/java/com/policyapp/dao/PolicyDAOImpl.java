package com.policyapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.policyapp.exceptions.IdNotFoundException;
import com.policyapp.exceptions.PolicyNotFoundException;
import com.policyapp.model.Policy;
import com.policyapp.util.DbConnection;

public class PolicyDAOImpl implements IPolicyDAO {

	Scanner sc = new Scanner(System.in);
	DbConnection dbconnection = new DbConnection();

	@Override
	public void addPolicy(Policy policy) {
		Connection connection = DbConnection.openConnection();
		String querry = "insert into policy(policy_name, premium, type,duration,coverage,category,sum_assured,brand)values(?,?,?,?,?,?,?,?)";
		try {

			PreparedStatement prepareStatement = connection.prepareStatement(querry);
			prepareStatement.setString(1, policy.getPolicyName());
			prepareStatement.setFloat(2, (float) policy.getPremium());
			prepareStatement.setString(3, policy.getType());
			prepareStatement.setInt(4, policy.getDuration());
			prepareStatement.setString(5, policy.getCoverage());
			prepareStatement.setString(6, policy.getCategory());
			prepareStatement.setFloat(7, (float) policy.getSumAssured());
			prepareStatement.setString(8, policy.getBrand());

			int result = prepareStatement.executeUpdate();
			System.out.println("policy is added");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbconnection.closeConnection();
		}
	}

	@Override
	public List<Policy> findAll() {
		List<Policy> policies = new ArrayList<Policy>();
		Connection connection = DbConnection.openConnection();
		String sql = "select * from policy";
		System.out.println("fetching data from database");
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				Policy policy = new Policy();
				String policyName = rs.getString("policy_name");
				policy.setPolicyName(policyName);
				int policyId = rs.getInt("policy_id");
				policy.setPolicyNumber(policyId);
				double premium = rs.getDouble("premium");
				policy.setPremium(premium);
				String type = rs.getString("type");
				policy.setType(type);
				int duration = rs.getInt("duration");
				policy.setPremium(duration);
				String coverage = rs.getString("coverage");
				policy.setCoverage(coverage);
				String category = rs.getString("category");
				policy.setCategory(category);
				double sumAssured = rs.getDouble("sum_assured");
				policy.setSumAssured(sumAssured);
				String brand = rs.getString("brand");
				policy.setBrand(brand);
				policies.add(policy);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbconnection.closeConnection();
		}
		return policies;
	}

	@Override
	public void deletePolicy(int policyId) {
		Connection connection = DbConnection.openConnection();
		String sql = "delete from policy where policy_id=" + policyId;
		PreparedStatement prepareStatement;
		try {
			prepareStatement = connection.prepareStatement(sql);

			int result = prepareStatement.executeUpdate();
			System.out.println("policy of " + policyId + " is deleted");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbconnection.closeConnection();
		}

	}

	@Override
	public void updatePolicy(int policyId, String coverage) {
		Connection connection = DbConnection.openConnection();
		String sql = "update policy set coverage=? where policy_id=?";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, coverage);
			prepareStatement.setInt(2, policyId);
			int result = prepareStatement.executeUpdate();
			System.out.println("policy of " + policyId + " updated");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Policy> findByType(String type) throws PolicyNotFoundException {
		List<Policy> policies = new ArrayList<Policy>();
		Connection connection = DbConnection.openConnection();
		String sql = "select * from policy";
		System.out.println("fetching data from database");
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				Policy policy = new Policy();
				String policyName = rs.getString("policy_name");
				policy.setPolicyName(policyName);
				int policyId = rs.getInt("policy_id");
				policy.setPolicyNumber(policyId);
				double premium = rs.getDouble("premium");
				policy.setPremium(premium);
				String policyType = rs.getString("type");
				policy.setType(policyType);
				int duration = rs.getInt("duration");
				policy.setPremium(duration);
				String coverage = rs.getString("coverage");
				policy.setCoverage(coverage);
				String category = rs.getString("category");
				policy.setCategory(category);
				double sumAssured = rs.getDouble("sum_assured");
				policy.setSumAssured(sumAssured);
				String brand = rs.getString("brand");
				policy.setBrand(brand);
				policies.add(policy);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbconnection.closeConnection();
		}
		
		return policies.stream().filter((policyType)->policyType.getType().equalsIgnoreCase(type)).collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByCategory(String category) throws PolicyNotFoundException {
		List<Policy> policies = new ArrayList<Policy>();
		Connection connection = DbConnection.openConnection();
		String sql = "select * from policy";
		System.out.println("fetching data from database");
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				Policy policy = new Policy();
				String policyName = rs.getString("policy_name");
				policy.setPolicyName(policyName);
				int policyId = rs.getInt("policy_id");
				policy.setPolicyNumber(policyId);
				double premium = rs.getDouble("premium");
				policy.setPremium(premium);
				String policyType = rs.getString("type");
				policy.setType(policyType);
				int duration = rs.getInt("duration");
				policy.setPremium(duration);
				String coverage = rs.getString("coverage");
				policy.setCoverage(coverage);
				String policyCategory = rs.getString("category");
				policy.setCategory(policyCategory);
				double sumAssured = rs.getDouble("sum_assured");
				policy.setSumAssured(sumAssured);
				String brand = rs.getString("brand");
				policy.setBrand(brand);
				policies.add(policy);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbconnection.closeConnection();
		}
		return policies.stream().filter((policyCategory)->policyCategory.getCategory().equalsIgnoreCase(category)).collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByHighSumAssured(double sumAssured) throws PolicyNotFoundException {
		List<Policy> policies = new ArrayList<Policy>();
		Connection connection = DbConnection.openConnection();
		String sql = "select * from policy";
		System.out.println("fetching data from database");
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				Policy policy = new Policy();
				String policyName = rs.getString("policy_name");
				policy.setPolicyName(policyName);
				int policyId = rs.getInt("policy_id");
				policy.setPolicyNumber(policyId);
				double premium = rs.getDouble("premium");
				policy.setPremium(premium);
				String policyType = rs.getString("type");
				policy.setType(policyType);
				int duration = rs.getInt("duration");
				policy.setPremium(duration);
				String coverage = rs.getString("coverage");
				policy.setCoverage(coverage);
				String policyCategory = rs.getString("category");
				policy.setCategory(policyCategory);
				double policySumAssured = rs.getDouble("sum_assured");
				policy.setSumAssured(policySumAssured);
				String brand = rs.getString("brand");
				policy.setBrand(brand);
				policies.add(policy);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbconnection.closeConnection();
		}
		return policies.stream().filter((s)->s.getSumAssured()>(sumAssured)).collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByCoverage(String coverage) throws PolicyNotFoundException {
		List<Policy> policies = new ArrayList<Policy>();
		Connection connection = DbConnection.openConnection();
		String sql = "select * from policy";
		System.out.println("fetching data from database");
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				Policy policy = new Policy();
				String policyName = rs.getString("policy_name");
				policy.setPolicyName(policyName);
				int policyId = rs.getInt("policy_id");
				policy.setPolicyNumber(policyId);
				double premium = rs.getDouble("premium");
				policy.setPremium(premium);
				String policyType = rs.getString("type");
				policy.setType(policyType);
				int duration = rs.getInt("duration");
				policy.setPremium(duration);
				String policyCoverage = rs.getString("coverage");
				policy.setCoverage(policyCoverage);
				String policyCategory = rs.getString("category");
				policy.setCategory(policyCategory);
				double policySumAssured = rs.getDouble("sum_assured");
				policy.setSumAssured(policySumAssured);
				String brand = rs.getString("brand");
				policy.setBrand(brand);
				policies.add(policy);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbconnection.closeConnection();
		}
		return policies.stream().filter((policyCoverage)->policyCoverage.getCoverage().equalsIgnoreCase(coverage)).collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByLessPremium(double premium) throws PolicyNotFoundException {
		List<Policy> policies = new ArrayList<Policy>();
		Connection connection = DbConnection.openConnection();
		String sql = "select * from policy";
		System.out.println("fetching data from database");
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				Policy policy = new Policy();
				String policyName = rs.getString("policy_name");
				policy.setPolicyName(policyName);
				int policyId = rs.getInt("policy_id");
				policy.setPolicyNumber(policyId);
				double policyPremium = rs.getDouble("premium");
				policy.setPremium(policyPremium);
				String policyType = rs.getString("type");
				policy.setType(policyType);
				int duration = rs.getInt("duration");
				policy.setPremium(duration);
				String policyCoverage = rs.getString("coverage");
				policy.setCoverage(policyCoverage);
				String policyCategory = rs.getString("category");
				policy.setCategory(policyCategory);
				double policySumAssured = rs.getDouble("sum_assured");
				policy.setSumAssured(policySumAssured);
				String brand = rs.getString("brand");
				policy.setBrand(brand);
				policies.add(policy);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbconnection.closeConnection();
		}
		return policies.stream().filter((s)->s.getPremium()<(premium)).collect(Collectors.toList());
	}

	@Override
	public Policy findById(int policyId) throws IdNotFoundException {
		List<Policy> policies = new ArrayList<Policy>();
		Connection connection = DbConnection.openConnection();
		String sql = "select * from policy";
		System.out.println("fetching data from database");
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				Policy policy = new Policy();
				String policyName = rs.getString("policy_name");
				policy.setPolicyName(policyName);
				int policyId1 = rs.getInt("policy_id");
				policy.setPolicyNumber(policyId1);
				double premium = rs.getDouble("premium");
				policy.setPremium(premium);
				String policyType = rs.getString("type");
				policy.setType(policyType);
				int duration = rs.getInt("duration");
				policy.setPremium(duration);
				String policyCoverage = rs.getString("coverage");
				policy.setCoverage(policyCoverage);
				String policyCategory = rs.getString("category");
				policy.setCategory(policyCategory);
				double policySumAssured = rs.getDouble("sum_assured");
				policy.setSumAssured(policySumAssured);
				String brand = rs.getString("brand");
				policy.setBrand(brand);
				policies.add(policy);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbconnection.closeConnection();
		}

		return policies.stream().filter((s)->s.getPolicyNumber()==(policyId)).findFirst().get();
	}

	@Override
	public Policy findByBrand(String brand) throws PolicyNotFoundException {
		List<Policy> policies = new ArrayList<Policy>();
		Connection connection = DbConnection.openConnection();
		String sql = "select * from policy";
		System.out.println("fetching data from database");
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				Policy policy = new Policy();
				String policyName = rs.getString("policy_name");
				policy.setPolicyName(policyName);
				int policyId = rs.getInt("policy_id");
				policy.setPolicyNumber(policyId);
				double premium = rs.getDouble("premium");
				policy.setPremium(premium);
				String type = rs.getString("type");
				policy.setType(type);
				int duration = rs.getInt("duration");
				policy.setPremium(duration);
				String coverage = rs.getString("coverage");
				policy.setCoverage(coverage);
				String category = rs.getString("category");
				policy.setCategory(category);
				double sumAssured = rs.getDouble("sum_assured");
				policy.setSumAssured(sumAssured);
				String policyBrand = rs.getString("brand");
				policy.setBrand(policyBrand);
				policies.add(policy);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbconnection.closeConnection();
		}
		return findAll().stream().filter((s)->s.getBrand().equalsIgnoreCase(brand)).findFirst().get();
	}

}
