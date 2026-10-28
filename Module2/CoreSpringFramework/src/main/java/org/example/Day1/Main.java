package org.example.Day1;


import org.example.Day1.School.School;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);
		School stXaviers = app.getBean(School.class);
		stXaviers.setS1("Akash rauniyar");
		stXaviers.getName();
		System.out.println("end of main");


	}
}
