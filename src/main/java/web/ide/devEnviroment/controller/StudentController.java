package web.ide.devEnviroment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.ide.devEnviroment.model.Student;
import web.ide.devEnviroment.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/a")
    public String login(){
        return "authenticated succesfully";
    }

    @GetMapping("/find/{username}")
    public ResponseEntity<Student> getStudent(@PathVariable("username") String username){
        Student student = studentService.findStudentByUsername(username);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student student1 = studentService.addStudent(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

}
