package com.jsp.car.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.car.exception.CarNotAddedException;
import com.jsp.car.exception.CarNotFoundException;
import com.jsp.car.pojo.Car;
import com.jsp.car.repository.CarRepo;

import jakarta.validation.Valid;

@Service
public class CarService {

	@Autowired
	CarRepo carRepo;

	public Car save(Car car) {
		Car cardb = carRepo.save(car);
		if (cardb != null) {
			return cardb;
		}
		throw new CarNotAddedException("Please provide valid Data");
	}

	public Car findbyId(int id) {
		Optional<Car> car = carRepo.findById(id);
		if (car.isPresent()) {
			return car.get();
		}
		throw new CarNotFoundException("Car not Found on Id = " + id);
	}

	public Car update(@Valid Car car, int id) {
		Car cardb = carRepo.findById(id).orElse(null);
		if (cardb != null) {
			cardb.setId(id);
			cardb.setName(car.getName());
			cardb.setBrand(car.getBrand());
			cardb.setPrice(car.getPrice());
			return carRepo.save(cardb);
		}
		throw new CarNotFoundException("Car not found to update on Id = " + id);
	}

	public List<Car> searchBrand(String keyword) {
		List<Car> cars = carRepo.searchBrand(keyword);
		if (!cars.isEmpty()) {
			return cars;
		}
		throw new CarNotAddedException("Car not found by keyword " + keyword);
	}

	public List<Car> searchName(String keyword) {
		List<Car> cars = carRepo.searchName(keyword);
		if (!cars.isEmpty())
			return cars;
		throw new CarNotAddedException("Car not found by keyword " + keyword);
	}

	public List<Car> findAll() {
		List<Car> cars = carRepo.findAll();
		if (!cars.isEmpty())
			return cars;
		throw new CarNotFoundException("Cars not found");
	}

	public Car deleteById(int id) {
		Car car = carRepo.findById(id).orElse(null);
		if (car != null) {
			carRepo.delete(car);
			return car;
		}
		throw new CarNotFoundException("Car not delete on Id = " + id);
	}

	public List<Car> deleteAll() {
		List<Car> cars = carRepo.findAll();
		if (!cars.isEmpty()) {
			carRepo.deleteAll(cars);
			return cars;
		}
		throw new CarNotFoundException("Car not found to delete");
	}

	public Car deleteByName(String name) {
		Car car = carRepo.findByName1(name);
		if (car!=null) {
		      carRepo.delete(car);
		      return car;
		}
		throw new CarNotFoundException("Car not found by name " + name);
	}

	public Car deleteByBrand(String brand) {
		Car car = carRepo.findByBrand1(brand);
		if (car!=null) {
		   carRepo.delete(car);
		   return car;
		}
		throw new CarNotFoundException("Car not found by name " + brand);
	}
}
