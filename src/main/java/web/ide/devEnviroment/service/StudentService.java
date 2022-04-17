package web.ide.devEnviroment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.ide.devEnviroment.exeption.StudentNotFoundExeption;
import web.ide.devEnviroment.model.*;
import web.ide.devEnviroment.repository.StudentRepo;
import web.ide.devEnviroment.repository.SupervisorRepo;
import web.ide.devEnviroment.repository.UserRepo;
import web.ide.devEnviroment.security.Encryptor;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentRepo studentRepo;
    private final UserRepo userRepo;
    private final SupervisorRepo supervisorRepo;
    Encryptor encryptor = new Encryptor();

    @Autowired
    public StudentService(StudentRepo studentRepo, UserRepo userRepo, SupervisorRepo supervisorRepo) {
        this.studentRepo = studentRepo;
        this.userRepo = userRepo;
        this.supervisorRepo = supervisorRepo;
    }

    public Student addStudent(UserDTO userDTO){

        String hashPass = encryptor.enctrypt(userDTO.getPassword());

        Supervisor supervisor =  supervisorRepo.findSupervisorById(userDTO.getSupervisorId());
        Student student1 = new Student(userDTO.getUsername(), userDTO.getEmail(), supervisor);
        studentRepo.save(student1);

        User user = new User(student1.getUsername(),hashPass,student1.getId());
        userRepo.save(user);

        return student1;
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

    public StudentDTO findStudentByUsername(String username){
        Student student = studentRepo.findStudentByUsername(username).orElseThrow(() -> new StudentNotFoundExeption("Student with that username does not exist"));
        StudentDTO studentDTO = new StudentDTO(student.getId(),student.getUsername(),student.getEmail());
        return studentDTO;
    }


    public void deleteStudent(Long id){
        studentRepo.deleteStudentById(id);
    }

}
