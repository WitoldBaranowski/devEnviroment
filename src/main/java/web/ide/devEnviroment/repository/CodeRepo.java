package web.ide.devEnviroment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import web.ide.devEnviroment.model.Code;
import web.ide.devEnviroment.model.Student;

import java.util.List;
import java.util.Optional;

public interface CodeRepo extends JpaRepository<Code, Long> {
    @Query(
            "FROM Code WHERE id_student = ?1"
    )
    List<Code> getCodeByStudent(Long id);
}
