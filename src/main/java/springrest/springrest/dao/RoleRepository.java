package springrest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springrest.springrest.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {

}