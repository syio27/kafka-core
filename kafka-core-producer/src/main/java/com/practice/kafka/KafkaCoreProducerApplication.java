package com.practice.kafka;

import com.practice.kafka.entity.Employee;
import com.practice.kafka.entity.PurchaseRequest;
import com.practice.kafka.producer.EmployeeJsonProducer;
import com.practice.kafka.producer.HelloKafkaProducer;
import com.practice.kafka.producer.KafkaKeyProducer;
import com.practice.kafka.producer.PurchaseRequestProducer;
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
	private PurchaseRequestProducer producer;
	public static void main(String[] args) {
		SpringApplication.run(KafkaCoreProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var pr1 = new PurchaseRequest(5551, "PR-First", 991, "USD");
		var pr2 = new PurchaseRequest(5552, "PR-Second", 992, "USD");
		var pr3 = new PurchaseRequest(5553, "PR-Third", 993, "USD");

		producer.send(pr1);
		producer.send(pr2);
		producer.send(pr3);

		producer.send(pr1);
	}
}
