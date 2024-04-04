package com.spider.productservicepractice.services;

import com.spider.productservicepractice.models.Students;
import com.spider.productservicepractice.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {
    @Autowired
    private StudentsRepository studentsRepository;
    public void saveAllstudents(List<Students> students){
        studentsRepository.saveAll(students);
    }

    public List<Students> findAllStudents() {
        return studentsRepository.findAll();
    }
}
