package web.ide.devEnviroment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.ide.devEnviroment.model.Code;

public interface CodeRepo extends JpaRepository<Code, Long> {
}
