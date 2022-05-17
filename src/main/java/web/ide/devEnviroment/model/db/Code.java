package web.ide.devEnviroment.model.db;

import web.ide.devEnviroment.model.db.Student;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="code")
public class Code implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_student", referencedColumnName = "id", nullable = false)
    private Student student;

    @Column(columnDefinition="varchar(10000)")
    private String program;

    private Date timestamp;

    public Code(Student student, String program, Date timestamp) {
        this.student = student;
        this.program = program;
        this.timestamp = timestamp;
    }

    public Code(Student student, String program) {
        this.student = student;
        this.program = program;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Code() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student studentId) {
        this.student = studentId;
    }


    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
}
