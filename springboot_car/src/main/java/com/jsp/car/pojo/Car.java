package com.jsp.car.pojo;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Name should not be Empty please Provide valid input")
	private String name;
	@NotBlank(message = "Brand should not be Empty please Provide valid input")
	private String brand;
	@Min(value = 100000 , message = "Price should not be less than 1 lac's")
	private Double price;
}
