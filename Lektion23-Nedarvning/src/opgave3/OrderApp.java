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
		order1.createOrderLine(1, product1);
		order1.createOrderLine(1, product2);
		order1.createOrderLine(1, product3);
		order1.createOrderLine(1, product4);
		order1.createOrderLine(1, product5);

		customer1.addOrder(order1);
		// customer1.addOrder(order2);
		customer2.addOrder(order1);
		// customer2.addOrder(order2);
		// customer2.addOrder(order3);
		// customer2.addOrder(order4);
		System.out.println(order1.getOrderPrice());

		PercentDiscount percentDiscount = new PercentDiscount(order1.getOrderPrice(), 50);
		FixedDiscount discount = new FixedDiscount(order1.getOrderPrice(), 10);
		customer1.setDiscount(discount);
		customer2.setDiscount(percentDiscount);
		System.out.println(customer1.getDiscountedPrice(order1));
		System.out.println(customer2.getDiscountedPrice(order2));

	}
}
