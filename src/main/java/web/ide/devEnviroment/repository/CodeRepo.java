package web.ide.devEnviroment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import web.ide.devEnviroment.model.db.Code;

import java.util.List;

public interface CodeRepo extends JpaRepository<Code, Long> {
    @Query(
            "FROM Code WHERE id_student = ?1"
    )
    List<Code> getCodeByStudent(Long id);
}
