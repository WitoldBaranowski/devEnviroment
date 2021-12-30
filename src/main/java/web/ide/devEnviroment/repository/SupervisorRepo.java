package web.ide.devEnviroment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.ide.devEnviroment.model.Supervisor;

public interface SupervisorRepo extends JpaRepository<Supervisor, Long> {
    Supervisor findSupervisorById(Long id);
}
