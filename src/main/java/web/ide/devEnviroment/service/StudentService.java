package web.ide.devEnviroment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.ide.devEnviroment.exeption.StudentNotFoundExeption;
import web.ide.devEnviroment.model.Student;
import web.ide.devEnviroment.repository.StudentRepo;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student addStudent(Student student){
        student.setUsername("Krzysiu");

        return studentRepo.save(student);
    }

    public List<Student> findAllStudents(){
        return studentRepo.findAll();
    }

    public Student updateStudent(Student student){
        return studentRepo.save(student);
    }

    public Student findStudentById(Long id){
        return studentRepo.findStudentById(id).orElseThrow(() -> new StudentNotFoundExeption("Student by id not found"));
    }

    public Student findStudentByUsername(String username){
        return studentRepo.findStudentByUsername(username).orElseThrow(() -> new StudentNotFoundExeption("Student with that username does not exist"));
    }


    public void deleteStudent(Long id){
        studentRepo.deleteStudentById(id);
    }

}
