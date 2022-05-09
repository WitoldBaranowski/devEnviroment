package web.ide.devEnviroment.model;

import web.ide.devEnviroment.model.db.Student;

public class CodeDTO {
    private Student student;
    private String program;
    private String stdin;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getStdin() {
        return stdin;
    }

    public void setStdin(String stdin) {
        this.stdin = stdin;
    }
}
