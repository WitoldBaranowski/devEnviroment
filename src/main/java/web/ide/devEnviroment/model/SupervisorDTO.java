package web.ide.devEnviroment.model;

public class SupervisorDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Boolean isLocal;

    public SupervisorDTO(Long id, String username, String email, String password, Boolean isLocal) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.isLocal = isLocal;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getLocal() {
        return isLocal;
    }

    public void setLocal(Boolean local) {
        isLocal = local;
    }
}
