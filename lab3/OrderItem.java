package lab3;

public class OrderItem {
	private Product p;
	private int quality;
	public OrderItem(Product p, int quality) {
		super();
		this.p = p;
		this.quality = quality;
	}
	public double getProductPrice() {
		return this.p.getPrice();
	}
	@Override
	public String toString() {
		return "OrderItem [p=" + p + ", quality=" + quality + "]";
	}
}

