package com.zsc.qc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zsc.qc.dao")
@SpringBootApplication
public class QingchengApplication {

	public static void main(String[] args) {
		SpringApplication.run(QingchengApplication.class, args);
	}

}
