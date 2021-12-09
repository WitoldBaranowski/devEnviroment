package web.ide.devEnviroment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.ide.devEnviroment.model.Code;
import web.ide.devEnviroment.model.CodeDTO;
import web.ide.devEnviroment.model.Student;
import web.ide.devEnviroment.repository.CodeRepo;
import web.ide.devEnviroment.repository.StudentRepo;


@Service
public class CodeService {
    private final CodeRepo codeRepo;
    @Autowired
    StudentRepo studentRepo;

    @Autowired
    public CodeService(CodeRepo codeRepo) {
        this.codeRepo = codeRepo;
    }

    public void addCode(CodeDTO codeDTO){
        Code code = new Code();
        code.setStudent(codeDTO.getStudent());
        code.setProgram(codeDTO.getProgram());
        code.setTimestamp(new java.util.Date());
        codeRepo.save(code);
    }
}
