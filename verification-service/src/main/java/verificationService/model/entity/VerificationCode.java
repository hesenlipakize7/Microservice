package verificationService.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "verification_codes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VerificationCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String code;
    private boolean verified;
}
