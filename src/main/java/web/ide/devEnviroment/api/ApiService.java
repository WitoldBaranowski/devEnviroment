package web.ide.devEnviroment.api;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import web.ide.devEnviroment.model.CodeDTO;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;

@Service
public class ApiService {

    public String createRequestForApi(CodeDTO codeDTO) throws URISyntaxException {
        JSONObject req = new JSONObject();
        JSONObject file = new JSONObject();
        file.put("name", "Code.py");
        file.put("content", codeDTO.getProgram());
        JSONArray arr = new JSONArray();
        arr.put(file);
        req.put("language", "python");
        req.put("stdin", codeDTO);
        req.put("files", arr);
/*        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://onecompiler.com/api/v1/run?access_token=tdCL9qZbYqVZuxmACqmsW425kNMMPBDyP53kgzC385PuzjnwY4QYRXnNhDrCPmx29pgSNhA2PENMMPBDyP53kgxePaYrR6pKce25kENMMPBDyP5Fu"))
                .headers("Content-Type", "application/json;charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString("Sample request body"))
                .build();*/
        return req.toString();
    }
}
