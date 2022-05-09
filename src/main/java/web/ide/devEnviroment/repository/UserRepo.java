package web.ide.devEnviroment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import web.ide.devEnviroment.model.db.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String username);
}
