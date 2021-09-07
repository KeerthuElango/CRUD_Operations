package com.demo.CRUD.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.CRUD.model.Shoes;
import com.demo.CRUD.service.ShoesService;

@RestController
@RequestMapping("/shoes")
public class ShoesController {

	@Autowired
	ShoesService shoesService;
	
	/* To add a shoe to the database
	 * Request to hit: http://localhost:8080/shoes/add
	 * {"brand":"abcd",
	    "name":"go3",
	    "type":"walking",
	    "size":12,
	    "price":50,
	    "units":1}
	 */
	@PostMapping("/add")
	public String createShoe(@RequestBody Shoes shoe )
	{
		shoesService.saveShoe(shoe);
		return "created";
	}
	
	/* To view the entire data
	 * Request to hit: http://localhost:8080/shoes/view
	 */
	@GetMapping(value="/view")
	public List<Shoes> viewShoes()
	{
		return shoesService.showAllShoes();
	}
	
	/* To filter data based on brand
	 * Request to hit: http://localhost:8080/shoes/viewBrand
	 * Parameters: brand 
	 */
	@GetMapping(value="/viewBrand")
	public List<Shoes> viewShoesByBrand(@RequestParam String brand)
	{
		return shoesService.showShoesByCategory(brand, 1);
	}
	
	/* To filter data based on name
	 * Request to hit: http://localhost:8080/shoes/viewName
	 * Parameters: name
	 */
	@GetMapping(value="/viewName")
	public List<Shoes> viewShoesByName(@RequestParam String name)
	{
		return shoesService.showShoesByCategory(name, 2);
	}
	
	/* To filter data based on type
	 * Request to hit: http://localhost:8080/shoes/viewType
	 * Parameters: type 
	 */
	@GetMapping(value="/viewType")
	public List<Shoes> viewShoesByType(@RequestParam String type)
	{
		return shoesService.showShoesByCategory(type, 3);
	}
	
	/* To filter data based on size
	 * Request to hit: http://localhost:8080/shoes/viewSize
	 * Parameters: size 
	 */
	@GetMapping(value="/viewSize")
	public List<Shoes> viewShoesBySize(@RequestParam String size)
	{
		return shoesService.showShoesByCategory(size, 4);
	}
	
	/* To delete the id on the table
	 * Request to hit: http://localhost:8080/shoes/delete
	 * Parameters: id 
	 */
	@GetMapping("/delete")
	public String deleteShoe(@RequestParam("id") int id)
	{
		return shoesService.deleteMyShoe(id);
	}
	
	/* To update price of a particular id
	 * Request to hit: http://localhost:8080/shoes/updatePrice
	 * Parameters: id, price 
	 */
	@RequestMapping("/updatePrice")
	public String updateShoePrice(@RequestParam int id, float price)
	{
		return shoesService.updateMyShoe(id, price, 0, 1);
	}
	
	/* To update units of a particular id
	 * Request to hit: http://localhost:8080/shoes/updateUnits
	 * Parameters: id, units 
	 */
	@RequestMapping("/updateUnits")
	public String updateShoeUnits(@RequestParam int id, int units)
	{
		return shoesService.updateMyShoe(id, 0,  units, 2);
	}
	
	/* To purchase a particular id
	 * Request to hit: http://localhost:8080/shoes/purchase
	 * Parameters: id
	 */
	@GetMapping("/purchase")
	public String purchaseShoe(@RequestParam int id)
	{
		return shoesService.purchaseMyShoe(id);
	}
	
}
