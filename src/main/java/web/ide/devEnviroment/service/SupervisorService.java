package web.ide.devEnviroment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.ide.devEnviroment.exeption.SupervisorNotFoundException;
import web.ide.devEnviroment.model.*;
import web.ide.devEnviroment.model.db.Code;
import web.ide.devEnviroment.model.db.Student;
import web.ide.devEnviroment.model.db.Supervisor;
import web.ide.devEnviroment.repository.CodeRepo;
import web.ide.devEnviroment.repository.StudentRepo;
import web.ide.devEnviroment.repository.SupervisorRepo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SupervisorService {
    private final StudentRepo studentRepo;
    private final CodeRepo codeRepo;
    private final SupervisorRepo supervisorRepo;
    @Autowired
    public SupervisorService(StudentRepo studentRepo,CodeRepo codeRepo,SupervisorRepo supervisorRepo) {
        this.studentRepo = studentRepo;
        this.codeRepo = codeRepo;
        this.supervisorRepo = supervisorRepo;
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

    public List<CodeDisplayDTO> returnCodes(StudentDTO studentDTO) throws IOException {
        List<Code> codes = codeRepo.getCodeByStudent(studentDTO.getId());
        List<CodeDisplayDTO> codeDisplayDTOS = new ArrayList<>();
        for (Code code: codes
        ) {
            codeDisplayDTOS.add(new CodeDisplayDTO(Compression.decompressB64(code.getProgram()),simplifyDate(code.getTimestamp())));
        }
        return codeDisplayDTOS;
    }

    public SupervisorDTO findSupervisorByUsername (String username){
        Supervisor supervisor = null;
        try {
            supervisor = supervisorRepo.findSupervisorByUsername(username);
        } catch (Exception e) {
            throw new SupervisorNotFoundException("Supervisor with that username does not exist");
        }
        SupervisorDTO supervisorDTO = new SupervisorDTO(supervisor.getId(), supervisor.getUsername(), supervisor.getEmail(), supervisor.getLocal());
        return supervisorDTO;
    }

    public String simplifyDate(Date date){
        String pattern = "MM-dd HH:mm:s";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    public void updateIsLocal(SupervisorDTO supervisorDTO){
        Supervisor supervisor = supervisorRepo.findSupervisorById(supervisorDTO.getId());
        supervisor.setLocal(supervisorDTO.getLocal());
        supervisorRepo.save(supervisor);
    }
}
