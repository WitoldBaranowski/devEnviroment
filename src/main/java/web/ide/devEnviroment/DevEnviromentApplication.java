package web.ide.devEnviroment;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import web.ide.devEnviroment.repository.StudentRepo;


@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = StudentRepo.class)
public class DevEnviromentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevEnviromentApplication.class, args);
	}

}
