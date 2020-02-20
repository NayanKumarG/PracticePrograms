/*
 * @author : Nayan Kumar g
 * purpose : application start here
 * 
 */
package com.bridgelabz.springsdemo.springbootstarter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan("com.bridgelabz.springsdemo.controller")
@ComponentScan("com.bridgelabz.springsdemo.service")
public class SpringsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsDemoApplication.class, args);
		System.out.println("Welcome");
	}
}
