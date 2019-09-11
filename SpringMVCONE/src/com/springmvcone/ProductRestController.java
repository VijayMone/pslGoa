package com.springmvcone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.catalina.connector.Request;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestController {
	
	private List<Product> products = new ArrayList<>();
	public ProductRestController() {
		products.add(new Product("1","Pen",100));
		products.add(new Product("2","Marker",150));
		
		
	}
	
	
	//@RequestMapping(path = "/products",method = RequestMethod.GET)
	@GetMapping(path = "/products.do")
	public List<Product> getProducts(){
		return products;
	}
	
	@PostMapping("/products.do")
	public void add(@RequestBody Product p) {
		products.add(p);
	}
	
	@DeleteMapping("/products.do/{code}")
	public void delete(@PathVariable("code") String code) {
		Iterator<Product> i1 = products.iterator(); 
		int counter = -1;
		boolean found = false;
		
			
			while(i1.hasNext()) {
				
				counter++;
				if(code .equals(i1.next().getCode())) {
						found = true;
				}
				
			
			
			if(found == true) {
				products.remove(counter);
			}
			
			System.out.println(products);
			
		}
		
	}
	
	
	
	
	
	
	@PutMapping("/products.do/{code}")
	public void update(@RequestBody Product p,@PathVariable("code") String code) {
		Iterator<Product> i1 = products.iterator(); 
		System.out.println(code);
		int counter = -1;
		boolean found = false;
		 
			
			while(i1.hasNext()) {
				counter++;
				if(code  .equals(i1.next().getCode())) {
						found = true;
						break;
				}
				
			
			
			if(found == true) {
				products.remove(counter);
			}
			
			System.out.println(products);
			
			products.add(p);
			
		}
		
		
	}

}
