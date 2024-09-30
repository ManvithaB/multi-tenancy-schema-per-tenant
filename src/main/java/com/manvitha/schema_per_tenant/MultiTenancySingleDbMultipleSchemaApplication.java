package com.manvitha.schema_per_tenant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MultiTenancySingleDbMultipleSchemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiTenancySingleDbMultipleSchemaApplication.class, args);
	}

}
