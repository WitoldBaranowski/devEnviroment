package web.ide.devEnviroment;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import web.ide.devEnviroment.repository.StudentRepo;


@SpringBootApplication
public class DevEnviromentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevEnviromentApplication.class, args);
	}

}
