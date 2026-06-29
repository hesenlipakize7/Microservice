package registerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import registerService.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
