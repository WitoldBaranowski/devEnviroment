package web.ide.devEnviroment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.ide.devEnviroment.model.Code;
import web.ide.devEnviroment.model.CodeDTO;
import web.ide.devEnviroment.service.CodeService;



@RestController
@RequestMapping("/code")
public class CodeController {
    private final CodeService codeService;

    public CodeController(CodeService codeService) {
        this.codeService = codeService;
    }
    @PostMapping("/add")
    public ResponseEntity<CodeDTO> addCode(@RequestBody CodeDTO codeDTO){
        System.out.println("test");
        codeService.addCode(codeDTO);
        return new ResponseEntity(codeDTO, HttpStatus.CREATED);
    }

}
