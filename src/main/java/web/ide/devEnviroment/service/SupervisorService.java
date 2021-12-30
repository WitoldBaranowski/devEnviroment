package web.ide.devEnviroment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.ide.devEnviroment.model.*;
import web.ide.devEnviroment.repository.CodeRepo;
import web.ide.devEnviroment.repository.StudentRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupervisorService {
    private final StudentRepo studentRepo;
    private final CodeRepo codeRepo;
    @Autowired
    public SupervisorService(StudentRepo studentRepo,CodeRepo codeRepo) {
        this.studentRepo = studentRepo;
        this.codeRepo = codeRepo;
    }

    public List<StudentDTO> returnStudents(SupervisorDTO supervisor){
        List<Student> students = studentRepo.getStudentsBySupervisor(supervisor.getId());
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student student: students
             ) {
            studentDTOS.add(new StudentDTO(student.getId(),student.getUsername(),student.getEmail()));
        }
        return studentDTOS;
    }

    public List<CodeDisplayDTO> returnCodes(StudentDTO studentDTO){
        List<Code> codes = codeRepo.getCodeByStudent(studentDTO.getId());
        List<CodeDisplayDTO> codeDisplayDTOS = new ArrayList<>();
        for (Code code: codes
        ) {
            codeDisplayDTOS.add(new CodeDisplayDTO(code.getProgram(),code.getTimestamp()));
        }
        return codeDisplayDTOS;
    }

}
