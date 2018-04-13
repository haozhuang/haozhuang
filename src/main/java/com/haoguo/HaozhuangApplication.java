package com.haoguo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement//开启对事务的支持
public class HaozhuangApplication {

	public static void main(String[] args) {
		SpringApplication.run(HaozhuangApplication.class, args);
	}
}
