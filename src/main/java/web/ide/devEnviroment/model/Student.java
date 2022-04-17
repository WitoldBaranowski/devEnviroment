package web.ide.devEnviroment.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String username;
    private String email;

    @ManyToOne
    @JoinColumn(name="id_supervisor", referencedColumnName = "id", nullable = false)
    private Supervisor supervisor;


    public Student(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public Student(String username, String email, Supervisor supervisor) {
        this.username = username;
        this.email = email;
        this.supervisor = supervisor;
    }

    public Student(Long id) {
        this.id = id;
    }

    public Student() {

    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
