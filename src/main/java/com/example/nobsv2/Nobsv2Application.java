package com.example.nobsv2;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Nobsv2Application {

	public static void main(String[] args) {
		SpringApplication.run(Nobsv2Application.class, args);
	}

}
