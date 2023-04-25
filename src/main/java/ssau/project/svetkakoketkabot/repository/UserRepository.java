package ssau.project.svetkakoketkabot.repository;

import org.springframework.data.repository.CrudRepository;
import ssau.project.svetkakoketkabot.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
