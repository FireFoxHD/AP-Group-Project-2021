package models;

import java.io.Serializable;

public class Item implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private double cost;
	private String category;
	private int numInStock;
	
	public Item() {
		this.id = "";
		this.name = "";
		this.cost = 0.0;
		this.category = "";
		this.numInStock = 0;
	}
	
	public Item(String id, String name, double cost, String category, int numInStock) {
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.category = category;
		this.numInStock = numInStock;
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getNumInStock() {
		return numInStock;
	}

	public void setNumInStock(int numInStock) {
		this.numInStock = numInStock;
	}

	@Override
	public String toString() {
		return "Equipment [equip_id=" + id + ", name=" + name + ", category=" + category + ", cost=" + cost
				+ ", status=" + numInStock + "]";
	}

	
}
