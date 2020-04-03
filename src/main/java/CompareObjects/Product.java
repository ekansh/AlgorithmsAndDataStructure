package CompareObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Product implements Comparable<Product>{

	private String PID;
	private Integer price;
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getPID() {
		return PID;
	}

	public void setPID(String pID) {
		PID = pID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PID == null) ? 0 : PID.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (PID == null) {
			if (other.PID != null)
				return false;
		} else if (!PID.equals(other.PID))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Product o) {//Ascending order
		if(this.price == o.price){
			return 0;
		} else{
			return this.price > o.price ? 1: -1;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Ascending order");
		List<Product> list = new ArrayList<>();
		Product p1 = new Product();
		p1.setPID("123");
		p1.setPrice(123);

		Product p2 = new Product();
		p2.setPID("1423");
		p2.setPrice(1423);
		
		Product p3 = new Product();
		p3.setPID("1233");
		p3.setPrice(1233);
		
		
		list.add(p3);
		list.add(p2);
		list.add(p1);
		
		
		for (Product product : list) {
			System.out.println(product.getPrice());
			
		}
		Collections.sort(list);
		System.out.println("Product.main()");
		for (Product product : list) {
			System.out.println(product.getPrice());
		}
		
		
	}
	

}
