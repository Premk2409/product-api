package com.cart.ecom_proj;

import com.cart.ecom_proj.model.Product;
import com.cart.ecom_proj.repo.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class EcomProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomProjApplication.class, args);
	}


	@Bean
	public CommandLineRunner loadData(ProductRepo repo) {
		return args -> {
			List<Product> products = List.of(
					new Product( "Tata Nexon", "A compact SUV with excellent safety features and performance.",
							"Tata Motors", new BigDecimal(750000.00), "Cars", new Date(2024, 1, 15), true, 50),
					new Product( "Maruti Suzuki Swift", "A popular hatchback known for its fuel efficiency and reliability.",
							"Maruti Suzuki", new BigDecimal(550000.00), "Cars", new Date(2024, 2, 1), true, 100),
					new Product( "Hyundai Creta", "A stylish SUV with advanced features and comfortable interior.",
							"Hyundai", new BigDecimal(950000.00), "Cars", new Date(2024, 3, 1), true, 75),
					new Product( "Mahindra Thar", "A rugged off-road SUV with a powerful engine and modern amenities.",
							"Mahindra", new BigDecimal(1200000.00), "Cars", new Date(2024, 4, 1), true, 30),
					new Product( "Honda City", "A premium sedan with a sleek design and advanced safety features.",
							"Honda", new BigDecimal(1100000.00), "Cars", new Date(2024, 5, 1), true, 60)
			);
			repo.saveAll(products);
		};
	}
}
