package springrest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springrest.springrest.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}