package opgave3;

import java.time.LocalDate;

public class OrderApp {
	public static void main(String[] args) {
		Product product1 = new Product(1, "Transformer", 10);
		Product product2 = new Product(2, "Morten From", 10);
		Product product3 = new Product(3, "Benjamin Hauge", 10);
		Product product4 = new Product(4, "Doktor Hansen", 10);
		Product product5 = new Product(5, "Jan Børkop", 10);

		Customer customer1 = new Customer("Henrik", LocalDate.parse("1996-01-01"));
		Customer customer2 = new Customer("Martin", LocalDate.parse("1984-01-01"));

		Order order1 = new Order(1);
		Order order2 = new Order(2);
		Order order3 = new Order(3);
		Order order4 = new Order(4);
		Order order5 = new Order(5);
		Order order6 = new Order(6);
		Order order7 = new Order(7);
		Order order8 = new Order(8);
		Order order9 = new Order(9);
		Order order10 = new Order(10);
		Order order11 = new Order(11);

		customer1.addOrder(order1);
		customer1.addOrder(order2);
		customer1.addOrder(order3);
		customer1.addOrder(order4);
		customer1.addOrder(order5);
		customer1.addOrder(order6);
		customer2.addOrder(order7);
		customer2.addOrder(order8);
		customer2.addOrder(order9);
		customer2.addOrder(order10);
		customer2.addOrder(order11);

	}
}
