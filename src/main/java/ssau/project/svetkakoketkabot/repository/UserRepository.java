package ssau.project.svetkakoketkabot.repository;

import org.springframework.data.repository.CrudRepository;
import ssau.project.svetkakoketkabot.entity.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
}
