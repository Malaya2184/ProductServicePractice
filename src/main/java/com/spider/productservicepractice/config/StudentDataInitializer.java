package com.spider.productservicepractice.config;

import com.spider.productservicepractice.models.Students;
import com.spider.productservicepractice.repository.StudentsRepository;
import com.spider.productservicepractice.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class StudentDataInitializer {
    @Autowired
    private StudentsService studentsService;
    @Bean
    public CommandLineRunner initStudenttable(){
        return args -> {
            List<Students> students = Arrays.asList(
                    new Students(1L,"Surname1", "Student1","2000-01-01"),
                    new Students(2L,"Surname2", "Student2","2000-01-01"),
                    new Students(3L,"Surname12", "Student12","2000-01-012"),
                    new Students(4L,"Surname13", "Student13","2000-01-01")

            );
            studentsService.saveAllstudents(students);
            System.out.println("data saved");
        };
    }
}
