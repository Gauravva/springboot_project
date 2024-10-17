package com.jsp.car.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jsp.car.pojo.Car;


public interface CarRepo extends JpaRepository<Car,Integer>{

	@Query("From Car where brand like %:pattern%")
	List<Car> searchBrand(@Param("pattern") String keyword);

	@Query("From Car where name like %:pattern%")
	List<Car> searchName(@Param("pattern") String keyword);
	

	List<Car> findByName(String name);

	@Query("from Car where name = :name")
    Car findByName1(@Param("name") String name);
	
	@Query("from Car where brand = :brand")
    Car findByBrand1(@Param("brand") String brand);
	
	List<Car> findByBrand(String brand);

}
