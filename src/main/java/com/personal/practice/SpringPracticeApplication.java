package com.personal.practice;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

// This annotation adds the following annotations
// - @Configuration: tags this class as a source of bean definitions for the application context object
// - @EnableAutoConfiguration: tells spring boot to start adding beans based on classpath settings
// - @ComponentScan: tells spring to look for other components/configurations/services in this com.personal.package 
//     - this helps spring find the controllers
@SpringBootApplication
public class SpringPracticeApplication {

	public static void main(String[] args) {
		// There is no XML, this web application is 100% pure java
		// and therefore with spring you don't need to deal with
		// any configuration or plumbing. 
		SpringApplication.run(SpringPracticeApplication.class, args);
	}

	// When annotation is encountered it will execute that method and register
	// the return value as a bean within a bean factory
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext appCtx) {
		return args -> {
			System.out.println("Let's look at these beans provided in spring boot man: ");
			System.out.println("-------------------------------------------------------");
			
			// Application context in spring is an object that loads the configuration 
			// then allows spring to manage the beans and their benefits: in this case
			// we are accessing the beans created/managed in this spring application
			// both automatically and ones we add manually, then printing them out
			String[] springBootBeanNames = appCtx.getBeanDefinitionNames();
			Arrays.sort(springBootBeanNames);
			for (String springBootBeanName : springBootBeanNames) {
				System.out.println(springBootBeanName);
				System.out.println("---------");
			}
		};
	}
}
