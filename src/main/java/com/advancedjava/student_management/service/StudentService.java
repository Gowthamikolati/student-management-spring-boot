package com.advancedjava.student_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.advancedjava.student_management.entity.Student;
import com.advancedjava.student_management.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Create Student
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // Get All Students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get Student by ID
    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }

    // Update Student
    public Student updateStudent(int id, Student student) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existingStudent.setName(student.getName());
        existingStudent.setBranch(student.getBranch());
        existingStudent.setYear(student.getYear());
        existingStudent.setMobile(student.getMobile());

        return studentRepository.save(existingStudent);
    }

    // Delete Student
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}