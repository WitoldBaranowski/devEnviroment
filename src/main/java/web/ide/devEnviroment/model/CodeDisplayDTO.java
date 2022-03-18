package web.ide.devEnviroment.model;

import java.util.Date;

public class CodeDisplayDTO {
    private String program;
    private String timestamp;

    public CodeDisplayDTO(String program, String timestamp) {
        this.program = program;
        this.timestamp = timestamp;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
