package web.ide.devEnviroment.api;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import web.ide.devEnviroment.model.CodeDTO;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

@Service
public class ApiService {

    public String createRequestForApi(CodeDTO codeDTO) throws URISyntaxException, IOException, InterruptedException {
        JSONObject req = new JSONObject();
        JSONObject file = new JSONObject();
        file.put("name", "Code.py");
        file.put("content", codeDTO.getProgram());
        JSONArray arr = new JSONArray();
        arr.put(file);
        req.put("language", "python");
        req.put("stdin", codeDTO.getStdin());
        req.put("files", arr);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://onecompiler.com/api/v1/run?access_token=tdCL9qZbYqVZuxmACqmsW425kNMMPBDyP53kgzC385PuzjnwY4QYRXnNhDrCPmx29pgSNhA2PENMMPBDyP53kgxePaYrR6pKce25kENMMPBDyP5Fu"))
                .headers("Content-Type", "application/json;charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString(req.toString()))
                .build();
        HttpResponse<String> response = HttpClient.newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return mappingJson(response.body());
    }

    public String mappingJson (String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> result = mapper.readValue(json, Map.class);
        if(result.get("exception") != null){
            return result.get("exception");
        }
        else{
            return result.get("stdout");
        }
    }
}
