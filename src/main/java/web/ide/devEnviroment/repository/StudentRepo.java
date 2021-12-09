package web.ide.devEnviroment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.ide.devEnviroment.model.Student;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Long> {
    void deleteStudentById(Long id);

    Optional<Student> findStudentById(Long id);
    Optional<Student> findStudentByUsername(String username);
}
