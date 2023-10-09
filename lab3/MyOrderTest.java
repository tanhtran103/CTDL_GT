package lab3;


public class MyOrderTest {
	public static void main(String[] args) {
		OrderItem[] items = new OrderItem[3];
		Product p1 = new Product("01", "Coca", 8000, "Cold");
		Product p2 = new Product("02", "Pepsi", 10000, "Cold");
		Product p3 = new Product("03", "Fanta", 9000, "Cold");

		items[0] = new OrderItem(p3, 10);
		items[1] = new OrderItem(p2, 8);
		items[2] = new OrderItem(p1, 6);
		
	}
}
