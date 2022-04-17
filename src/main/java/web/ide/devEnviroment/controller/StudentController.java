package web.ide.devEnviroment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.ide.devEnviroment.model.Student;
import web.ide.devEnviroment.model.StudentDTO;
import web.ide.devEnviroment.model.UserDTO;
import web.ide.devEnviroment.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/login")
    public String login(){
        return "authenticated succesfully";
    }

    @GetMapping("/find/{username}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable("username") String username){
        StudentDTO student = studentService.findStudentByUsername(username);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<UserDTO> addStudent(@RequestBody UserDTO student){
        Student student1 = studentService.addStudent(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

}
