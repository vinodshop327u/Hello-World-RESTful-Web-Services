package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController 
{
	@RequestMapping("/hello")
    public String hello() {
        return "Hello World RESTful with Spring Boot";
    } 
	
	//http://localhost:8080/hello1?name=vinod
	@RequestMapping("/hello1")
	public String hello(@RequestParam(name = "name", defaultValue = "World") String name) {
	    return "Hello " + name;
	}
	
	//http://localhost:8080/createresources
	@GetMapping("/createresources")
	public Product getProduct() 
	{
	    return new Product(1, "iPhone", 999.99f);
	}
     //http://localhost:8080/resources/1
    @GetMapping("/resources/{id}")
    public String createResource2()
    {
		return "assSaASdAS";
    }
    
    boolean found=false;
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        // find the product by id
         System.out.println("----------------------exception-----------------");
        if (found) {
            return new ResponseEntity<Product>(HttpStatus.OK);
        } else {       
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }
    
     //{"id":1,"name":"iPhone","price":999.99}
    //http://localhost:8080/addproduct    
    @PostMapping("/addproduct")
    public void addProduct(@RequestBody Product product) {
        System.out.println(product);
    }
    
         
    @PutMapping("/resources/{id}")
    public String createResource4()
    {
		return "";
    }
     
    @DeleteMapping("/resources/{id}")
    public String createResource5()
    {
		return "";
    }

}
