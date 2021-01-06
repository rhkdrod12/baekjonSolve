package lib;

public class Product {
	
	private String name;	
	private int price;
	private int productNumber;		
	
	{
		price = 0;
		productNumber = 0;
	}
	
	Product(String name){
		this.name = name;
	}
	Product(String name, int price){
		this.name = name;
		this.price = price;
	}
	Product(String name, int price, int productNumber){
		this.name = name;
		this.price = price;
		this.productNumber = productNumber;
	}
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}	
	
}
