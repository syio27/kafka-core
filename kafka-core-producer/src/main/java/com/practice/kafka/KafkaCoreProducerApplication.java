package com.practice.kafka;

import com.practice.kafka.producer.HelloKafkaProducer;
import com.practice.kafka.producer.KafkaKeyProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableScheduling
public class KafkaCoreProducerApplication implements CommandLineRunner {

	@Autowired
	private KafkaKeyProducer kafkaKeyProducer;

	public static void main(String[] args) {
		SpringApplication.run(KafkaCoreProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for(int i=0; i<100000; i++){
			var key = "key-" + (i%4);
			var value = "value " + i + " with key " + key;
			kafkaKeyProducer.send(key, value);
			TimeUnit.SECONDS.sleep(1);
		}
	}
}
