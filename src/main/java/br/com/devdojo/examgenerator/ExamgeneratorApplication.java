package br.com.devdojo.examgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;
import org.springframework.web.bind.annotation.CrossOrigin;

//@CrossOrigin(origins ="http://localhost:4200")
@SpringBootApplication

public class ExamgeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamgeneratorApplication.class, args);
    }


    @Bean
    public SecurityEvaluationContextExtension securityEvaluationContextExtension(){
        return new SecurityEvaluationContextExtension();
    }

}
