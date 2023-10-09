package lab3;

public class Order {
	private OrderItem[] items;

	public Order(OrderItem[] items) {
		// TODO Auto-generated constructor stub
		this.items = items;
	}

	public double cost() {
		double totalCost = 0.0;
		for (int i = 0; i < this.items.length; i++) {
			totalCost += this.items[i].getProductPrice();
		}
		return totalCost;
	}
	// using binary search approach
	public boolean contains(Product p) {
		// TODO
		int low = 0;
		int high = this.items.length -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (this.items[mid].equals(p))
				return true;
			if (this.items[mid].getProductPrice() < p.getPrice()) 
				low = mid + 1;
			else
				high = mid - 1;

		}
		return false;
	}
	// get all products based on the given type using
	// linear search
	public Product[] filter(String type) {
		// TODO
		return null;
	}

}
