package web.ide.devEnviroment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import web.ide.devEnviroment.model.db.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Long> {
    void deleteStudentById(Long id);

    Optional<Student> findStudentById(Long id);
    Optional<Student> findStudentByUsername(String username);

    @Query(
            "FROM Student WHERE id_supervisor = ?1"
    )
    List<Student> getStudentsBySupervisor(Long id);



}
