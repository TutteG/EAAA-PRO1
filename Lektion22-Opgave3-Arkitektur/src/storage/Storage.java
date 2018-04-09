package storage;

import java.util.ArrayList;

import application.model.Company;
import application.model.Customer;
import application.model.Employee;

public class Storage {
	private static ArrayList<Company> companies = new ArrayList<>();
	private static ArrayList<Employee> employees = new ArrayList<>();
	private static ArrayList<Customer> customers = new ArrayList<>();
	// -------------------------------------------------------------------------

	public static ArrayList<Company> getCompanies() {
		return new ArrayList<Company>(companies);
	}

	public static void addCompany(Company company) {
		companies.add(company);
	}

	public static void removeCompany(Company company) {
		companies.remove(company);
	}

	// -------------------------------------------------------------------------

	public static ArrayList<Employee> getEmployees() {
		return new ArrayList<Employee>(employees);
	}

	public static void addEmployee(Employee employee) {
		employees.add(employee);
	}

	public static void removeEmployee(Employee employee) {
		employees.remove(employee);
	}

	// -------------------------------------------------------------------

	public static ArrayList<Customer> getCustomers() {
		return new ArrayList<>(customers);
	}

	public static void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customers.add(customer);
	}

	public static void removeCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customers.remove(customer);
	}
}
