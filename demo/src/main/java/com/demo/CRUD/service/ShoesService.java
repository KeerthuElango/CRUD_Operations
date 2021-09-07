package com.demo.CRUD.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.demo.CRUD.model.Shoes;
import com.demo.CRUD.repository.ShoesRepository;

@Service
@Transactional
public class ShoesService {
	
	private ShoesRepository shoesRepository;

	public ShoesService(ShoesRepository shoesRepository) {
		super();
		this.shoesRepository = shoesRepository;
	}
	
	//To add a shoe
	public void saveShoe(Shoes shoe ) {
		shoesRepository.save(shoe);
	}
	
	//To view the entire data
	public List<Shoes> showAllShoes(){
		List<Shoes> shoes = new ArrayList<Shoes>();
		for(Shoes shoe : shoesRepository.findAll()) {
			shoes.add(shoe);
		}
		
		return shoes;
	}
	
	//To filter by brand, name, type, size
	public List<Shoes> showShoesByCategory(String category, int temp){
		List<Shoes> shoes = new ArrayList<Shoes>();
		
		//Filter by brand
		if(temp==1)
		{
			for(Shoes shoe : shoesRepository.findAll()) {
				if(shoe.getBrand().equals(category))
					shoes.add(shoe);
			}
		}
		
		//Filter by name
		else if(temp==2)
		{
			for(Shoes shoe : shoesRepository.findAll()) {
				if(shoe.getName().equals(category))
					shoes.add(shoe);
			}
		}
		
		//Filter by type
		else if(temp==3)
		{
			for(Shoes shoe : shoesRepository.findAll()) {
				if(shoe.getType().equals(category))
					shoes.add(shoe);
			}
		}
		
		//Filter by size
		else if(temp==4)
		{
			int s = Integer.parseInt(category);
			for(Shoes shoe : shoesRepository.findAll()) {
				if(shoe.getSize()==s)
					shoes.add(shoe);
			}
		}
		
		return shoes;
	}
	
	//Delete the shoe id
	public String deleteMyShoe(int id) {
		Shoes shoe = null;
		
		try{shoe = shoesRepository.findById(id).get();	}
		catch(Exception e){return "no id present, Can't be deleted!";}
		
		shoesRepository.deleteById(id);
		return "Deleted id:"+id;
	}
	
	//Update the price and units of shoe
	public String updateMyShoe(int id, float price, int units, int temp) {
		Shoes shoe = null;
		
		try{shoe = shoesRepository.findById(id).get();	}
		catch(Exception e){return "no id present, Can't be updated!";}
		
		//Update the price
		if(temp==1)
			shoe.setPrice(price);
		//Update the units by adding the existing units with the present units
		else if(temp==2)
		{
			int u = shoe.getUnits();
			u+=units;
			shoe.setUnits(u);
		}
		
		shoesRepository.save(shoe);
		return "Updated id:"+id;
	}
	
	//Purchase shoe(decreases the units by one on each purchase)
	public String purchaseMyShoe(int id){
		Shoes shoe = null;
		
		try{shoe = shoesRepository.findById(id).get();	}
		catch(Exception e){return "id is not present, Can't be purchased!";}
		
		int units = shoe.getUnits();
		if(units==0)
			return "No units available!";
		
		shoe.setUnits(units-1);
		shoesRepository.save(shoe);
		
		return "Purchased id:"+id;
	}
	
}
