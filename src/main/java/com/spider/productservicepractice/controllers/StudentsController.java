package com.spider.productservicepractice.controllers;

import com.spider.productservicepractice.models.Students;
import com.spider.productservicepractice.repository.StudentsRepository;
import com.spider.productservicepractice.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {
    @Autowired
    private StudentsService studentsService;
    @GetMapping
    public List<Students> getAllStudents(){
        return studentsService.findAllStudents();
    }
}
