package com.jsp.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.car.pojo.Car;
import com.jsp.car.response.CarResponse;
import com.jsp.car.service.CarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("carapi")
public class CarController {

	@Autowired
	CarService carService;
	
	@PostMapping("save")
	public ResponseEntity<CarResponse> save(@Valid @RequestBody Car car){
		return new ResponseEntity<CarResponse>(new CarResponse("Your car added Successfully", null,carService.save(car), null),HttpStatus.OK);
	}
	
	@GetMapping("findbyId/{id}")
	public ResponseEntity<CarResponse> findById(@PathVariable int id){
		return new ResponseEntity<CarResponse>(new CarResponse("Your car found Successfully", null,carService.findbyId(id), null),HttpStatus.OK);	
	}
	
	@GetMapping("findall")
	public ResponseEntity<CarResponse> findAll(){
		return new ResponseEntity<CarResponse>(new CarResponse("Your Car's Found Successfully", null, null, carService.findAll()),HttpStatus.OK);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<CarResponse> updateCar(@Valid @RequestBody Car car,@PathVariable int id){
		return new ResponseEntity<CarResponse>(new CarResponse("Your car updated Successfully", null,carService.update(car,id), null),HttpStatus.OK);
	}
	
	@GetMapping("searchbrand/{keyword}")
	public ResponseEntity<CarResponse> searchBrand(@PathVariable String keyword){
		return new ResponseEntity<CarResponse>(new CarResponse("Your Car Found Successfully", null, null, carService.searchBrand(keyword)),HttpStatus.OK);
	}
	
	@GetMapping("searchname/{keyword}")
	public ResponseEntity<CarResponse> searchName(@PathVariable String keyword){
		return new ResponseEntity<CarResponse>(new CarResponse("Your Car Found Successfully", null, null, carService.searchName(keyword)),HttpStatus.OK);
	}
	
	@DeleteMapping("deletebyid/{id}")
	public ResponseEntity<CarResponse> deleteById(@PathVariable int id){
		return new ResponseEntity<CarResponse>(new CarResponse("Your car Deleted Successfully", null,carService.deleteById(id), null),HttpStatus.OK);
	}
	
	@DeleteMapping("deletebyname/{name}")
	public ResponseEntity<CarResponse> deleteByName(@PathVariable String name){
		return new ResponseEntity<CarResponse>(new CarResponse("Your car Deleted Successfully", null,carService.deleteByName(name),null),HttpStatus.OK);
	}
	
	@DeleteMapping("deletebybrand/{brand}")
	public ResponseEntity<CarResponse> deleteBybrand(@PathVariable String brand){
		return new ResponseEntity<CarResponse>(new CarResponse("Your car Deleted Successfully", null,carService.deleteByBrand(brand),null),HttpStatus.OK);
	}
	
	@DeleteMapping("deleteall")
	public ResponseEntity<CarResponse> deleteAll(){
		return new ResponseEntity<CarResponse>(new CarResponse("Your cars Deleted Successfully", null,null, carService.deleteAll()),HttpStatus.OK);
	}
	
}
