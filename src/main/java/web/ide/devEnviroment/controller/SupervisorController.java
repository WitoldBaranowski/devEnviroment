package web.ide.devEnviroment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.ide.devEnviroment.model.*;
import web.ide.devEnviroment.service.SupervisorService;

import java.util.List;

@RestController
@RequestMapping("/supervisor")
public class SupervisorController {
    private final SupervisorService supervisorService;
    public SupervisorController(SupervisorService supervisorService) {
        this.supervisorService = supervisorService;
    }

    @PostMapping("/getStudents")
    public ResponseEntity<List<StudentDTO>> getStudents(@RequestBody SupervisorDTO supervisor){
        List<StudentDTO> listOfStudents = supervisorService.returnStudents(supervisor);
        return new ResponseEntity(listOfStudents, HttpStatus.OK);
    }

    @PostMapping("/getCodes")
    public ResponseEntity<List<CodeDisplayDTO>> getCodes(@RequestBody StudentDTO studentDTO){
        List<CodeDisplayDTO> listOfCodes = supervisorService.returnCodes(studentDTO);
        return new ResponseEntity(listOfCodes, HttpStatus.OK);
    }

    @PostMapping("/isLocal")
    public ResponseEntity getCodes(@RequestBody SupervisorDTO supervisorDTO){
        System.out.println(supervisorDTO.getLocal());
        supervisorService.updateIsLocal(supervisorDTO);
        return new ResponseEntity(HttpStatus.OK);
    }
}
