package com.managementSystem;

import com.managementSystem.dao.StudentRepository;
import com.managementSystem.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
	private StudentRepository studentRepository;

	public StudentManagementSystemApplication(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public void run(String... args) throws Exception {
//		Student s1= new Student("Niyaz","Asghar","niyazasghar@example.com");
//		studentRepository.save(s1);
	}
}
