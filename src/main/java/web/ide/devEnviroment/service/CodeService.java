package web.ide.devEnviroment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.ide.devEnviroment.api.ApiService;
import web.ide.devEnviroment.model.db.Code;
import web.ide.devEnviroment.model.CodeDTO;
import web.ide.devEnviroment.model.db.Supervisor;
import web.ide.devEnviroment.repository.CodeRepo;
import web.ide.devEnviroment.repository.StudentRepo;
import web.ide.devEnviroment.repository.SupervisorRepo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.zip.GZIPOutputStream;


@Service
public class CodeService {
    private final CodeRepo codeRepo;
    @Autowired
    StudentRepo studentRepo;

    @Autowired
    SupervisorRepo supervisorRepo;

    private final ApiService apiService;

    @Autowired
    public CodeService(CodeRepo codeRepo, ApiService apiService) {
        this.codeRepo = codeRepo;
        this.apiService = apiService;
    }

    public String addCode(CodeDTO codeDTO) throws URISyntaxException, IOException, InterruptedException {
        Code code = new Code();
        code.setStudent(codeDTO.getStudent());
        code.setProgram(Compression.compressAndReturnB64(codeDTO.getProgram()));
        code.setTimestamp(new java.util.Date());
        codeRepo.save(code);
        Supervisor supervisor = studentRepo.findStudentById(codeDTO.getStudent().getId()).get().getSupervisor();
        if(supervisor.getLocal()){
            return apiService.createRequestForApiLocal(codeDTO);
        }
        else {
            return apiService.createRequestForApiRemote(codeDTO);
        }

    }
}
