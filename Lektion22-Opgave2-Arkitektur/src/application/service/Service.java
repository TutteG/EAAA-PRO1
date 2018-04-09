package application.service;

import java.util.ArrayList;

import application.model.Company;
import application.model.Customer;
import application.model.Employee;
import storage.Storage;

public class Service {
	public static Customer createCustomer(String name) {
		Customer customer = new Customer(name);
		Storage.addCustomer(customer);
		return customer;
	}

	public static void deleteCustomer(Customer customer) {
		for (Company company : getCompanies()) {
			deleteCustomerFromCompany(customer, company);
		}
		Storage.removeCustomer(customer);
	}

	public static void deleteCustomerFromCompany(Customer customer, Company company) {
		company.removeCustomer(customer);
	}

	public static void updateCustomer(Customer customer, String name) {
		customer.setName(name);
	}

	public static ArrayList<Customer> getCustomers() {
		return Storage.getCustomers();
	}

	/**
	 * Creates a new Company.<br />
	 * Requires: hours >= 0.
	 */
	public static Company createCompany(String name, int hours) {
		Company company = new Company(name, hours);
		Storage.addCompany(company);
		return company;
	}

	/**
	 * Deletes the company.<br />
	 * Requires: The company has no employees.
	 */
	public static void deleteCompany(Company company) {
		Storage.removeCompany(company);
	}

	/**
	 * Updates the company.<br />
	 * Requires: hours >= 0.
	 */
	public static void updateCompany(Company company, String name, int hours) {
		company.setName(name);
		company.setHours(hours);
	}

	/**
	 * Get all the companies
	 */
	public static ArrayList<Company> getCompanies() {
		return Storage.getCompanies();
	}

	// -------------------------------------------------------------------------

	/**
	 * Creates a new employee.<br />
	 * Requires: wage >= 0.
	 */
	public static Employee createEmployee(String name, int wage) {
		Employee employee = new Employee(name, wage);
		Storage.addEmployee(employee);
		return employee;
	}

	/**
	 * Creates a new employee.<br />
	 * Requires: wage >= 0, company!=null.
	 */
	public static Employee createEmployee(String name, int wage, int year, Company company) {
		Employee employee = new Employee(name, wage);
		employee.setYear(year);
		company.addEmployee(employee);
		employee.setCompany(company);
		Storage.addEmployee(employee);
		return employee;
	}

	/**
	 * Deletes the employee.
	 */
	public static void deleteEmployee(Employee employee) {
		Company company = employee.getCompany();
		if (company != null) {
			company.removeEmployee(employee);
			employee.clearCompany();
		}
		Storage.removeEmployee(employee);
	}

	/**
	 * Updates the employee.<br />
	 * Requires: wage >= 0.
	 */
	public static void updateEmployee(Employee employee, String name, int wage) {
		employee.setName(name);
		employee.setWage(wage);
	}

	/**
	 * Get all the employees.
	 */
	public static ArrayList<Employee> getEmployees() {
		return Storage.getEmployees();
	}

	// -------------------------------------------------------------------------

	/**
	 * Updates the employee's company.
	 */
	public static void updateCompanyOfEmployee(Employee employee, Company company, int year) {
		Company current = employee.getCompany();
		if (current != null) {
			current.removeEmployee(employee);
			employee.clearCompany();
		}
		employee.setYear(year);
		employee.setCompany(company);
		company.addEmployee(employee);
	}

	/**
	 * Clears the company of the employee.
	 */
	public static void clearCompanyOfEmployee(Employee employee) {
		Company company = employee.getCompany();
		if (company != null) {
			company.removeEmployee(employee);
			employee.clearCompany();
		}
	}

	// -------------------------------------------------------------------------

	/**
	 * Initializes the storage with some objects.
	 */
	public static void initStorage() {
		Company c1 = Service.createCompany("IBM", 37);
		Company c2 = Service.createCompany("AMD", 40);
		Company c3 = Service.createCompany("SLED", 45);
		Company c4 = Service.createCompany("Vector", 32);

		Customer kost1 = Service.createCustomer("Morten");
		Customer kost2 = Service.createCustomer("Peter");
		Customer kost3 = Service.createCustomer("Svenne");
		Customer kost4 = Service.createCustomer("Niller");
		Customer kost5 = Service.createCustomer("Nina");

		c3.addCustomer(kost1);
		c3.addCustomer(kost2);
		c3.addCustomer(kost5);
		c4.addCustomer(kost3);
		c4.addCustomer(kost4);
		c4.addCustomer(kost5);

		Service.createEmployee("Bob Dole", 210, 2007, c2);
		Service.createEmployee("Alice Schmidt", 250, 2007, c1);
		Service.createEmployee("George Down", 150, 2007, c2);
		Service.createEmployee("Rita Uphill", 300);
	}

}
