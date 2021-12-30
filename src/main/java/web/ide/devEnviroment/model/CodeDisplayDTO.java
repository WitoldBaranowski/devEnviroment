package web.ide.devEnviroment.model;

import java.util.Date;

public class CodeDisplayDTO {
    private String program;
    private Date timestamp;

    public CodeDisplayDTO(String program, Date timestamp) {
        this.program = program;
        this.timestamp = timestamp;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
