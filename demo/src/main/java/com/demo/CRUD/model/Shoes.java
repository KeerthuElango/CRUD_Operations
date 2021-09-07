package com.demo.CRUD.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Shoes")
public class Shoes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String brand;
	private String type;
	private String name;
	private int size;
	private float price;
	private int units;
	
	public Shoes()
	{
	}
	public Shoes(int id, String brand, String type, String name, int size, float price, int units) {
		super();
		this.id = id;
		this.brand = brand;
		this.type = type;
		this.name = name;
		this.size = size;
		this.price = price;
		this.units = units;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	@Override
	public String toString() {
		return "Shoes [id=" + id + ", brand=" + brand + ", type=" + type + ", name=" + name + ", size=" + size
				+ ", price=" + price + ", units=" + units + "]";
	}
		
}
