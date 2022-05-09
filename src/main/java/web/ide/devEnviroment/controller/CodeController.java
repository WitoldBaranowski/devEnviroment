package web.ide.devEnviroment.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.ide.devEnviroment.model.CodeDTO;
import web.ide.devEnviroment.model.StdoutDTO;
import web.ide.devEnviroment.service.CodeService;

import java.io.IOException;
import java.net.URISyntaxException;


@RestController
@RequestMapping("/code")
public class CodeController {
    private final CodeService codeService;

    public CodeController(CodeService codeService) {
        this.codeService = codeService;
    }
    @PostMapping("/add")
    public ResponseEntity<CodeDTO> addCode(@RequestBody CodeDTO codeDTO) throws URISyntaxException, IOException, InterruptedException {
        return new ResponseEntity(new StdoutDTO(codeService.addCode(codeDTO)), HttpStatus.CREATED);
    }

}
