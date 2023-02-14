package com.practice.kafka;

import com.practice.kafka.entity.Employee;
import com.practice.kafka.producer.EmployeeJsonProducer;
import com.practice.kafka.producer.HelloKafkaProducer;
import com.practice.kafka.producer.KafkaKeyProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableScheduling
public class KafkaCoreProducerApplication implements CommandLineRunner {
	@Autowired
	private EmployeeJsonProducer producer;

	public static void main(String[] args) {
		SpringApplication.run(KafkaCoreProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i=0; i < 5; i++) {
			var emp = new Employee("emp-" +i, "Employee-"+i, LocalDate.now());
			producer.send(emp);
		}
	}
}
