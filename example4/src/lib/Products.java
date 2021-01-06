package lib;

import java.util.ArrayList;
import java.util.Iterator;

public class Products {
	
	private ArrayList<Product> product = new ArrayList<Product>();
	
	void create(String name, int price, int productNumber){
		Product temp = new Product(name, price, productNumber);
		
		product.add(temp);
		
		System.out.print("积己肯丰: ");
		System.out.printf("%s\t", temp.getName());			
		System.out.printf("%d\t", temp.getProductNumber());
		System.out.printf("%d盔\n", temp.getPrice());		
		
	}
	
	void delete(String name) {
		Iterator<Product> pIndex = product.iterator(); 		
		while(pIndex.hasNext()) {
			Product pd = pIndex.next();
			if(pd.getName().equals(name)) {
				pIndex.remove();
				break;
			}			
		}			
	}	
	void delete(int productNumber){
		Iterator<Product> pIndex = product.iterator(); 		
		while(pIndex.hasNext()) {
			Product pd = pIndex.next();
			if(pd.getProductNumber() == productNumber) {
				pIndex.remove();
				break;
			}			
		}
	}
	void delete(String name, int productNumber){
		
		Iterator<Product> pIndex = product.iterator(); 		
		while(pIndex.hasNext()) {
			Product pd = pIndex.next();
			if(pd.getName().equals(name) && pd.getProductNumber() == productNumber) {
				pIndex.remove();
				break;
			}			
		}
	}
	void delete(String name, int price, int productNumber){
		Iterator<Product> pIndex = product.iterator(); 		
		while(pIndex.hasNext()) {
			Product pd = pIndex.next();
			if(pd.getName().equals(name) && pd.getProductNumber() == productNumber && pd.getPrice() == price) {
				pIndex.remove();
				break;
			}			
		}
	}
	
	void display() {
		System.out.println("[力前格废 免仿]");
		System.out.printf("力前疙\t力前锅龋\t力前啊拜\n");
		
		Iterator<Product> pIndex = product.iterator(); 		
		while(pIndex.hasNext()) {
			Product pd = pIndex.next();
			System.out.printf("%s\t", pd.getName());			
			System.out.printf("%d\t", pd.getProductNumber());
			System.out.printf("%d盔\n", pd.getPrice());
		}
		
	}	
	
	
}

