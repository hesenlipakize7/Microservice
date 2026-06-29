package verificationService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import verificationService.model.entity.VerificationCode;

import java.util.Optional;

public interface VerificationRepository extends JpaRepository<VerificationCode,Long> {

    Optional<VerificationCode> findByEmail(String email);

}
