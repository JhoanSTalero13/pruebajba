package com.ejemplo.despliegue.jba.jbaprueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude ={SecurityAutoConfiguration.class})
public class JbapruebaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JbapruebaApplication.class, args);
	}

}
