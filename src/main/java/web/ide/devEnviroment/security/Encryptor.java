package web.ide.devEnviroment.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encryptor {
    public String enctrypt(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
