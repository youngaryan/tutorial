package com.example.demo;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public void run(String... args) throws Exception {
		Student s1 = new Student("Aryan", "Golbaghi", "aryanGolbaghi@gmail.com");
		studentRepository.save(s1);

		Student s2 = new Student("Arad", "Golbaghi", "aradgol@gmail.com");
		studentRepository.save(s2);
	}
}
