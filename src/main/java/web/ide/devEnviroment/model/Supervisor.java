package web.ide.devEnviroment.model;

import javax.persistence.*;

@Entity
@Table(name="supervisor")
public class Supervisor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String username;
    private String email;
    private String password;
    private Boolean isLocal;

    public Supervisor(String username, String email, String password, Boolean isLocal) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.isLocal = isLocal;
    }

    public Supervisor() {

    }

    public Boolean getLocal() {
        return isLocal;
    }

    public void setLocal(Boolean local) {
        isLocal = local;
    }

    public Long getId() {
        return id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}