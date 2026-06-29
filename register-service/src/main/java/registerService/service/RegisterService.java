package registerService.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import registerService.client.VerificationClient;
import registerService.dto.RegisterRequest;
import registerService.dto.RegisterResponse;
import registerService.dto.VerifyRequest;
import registerService.dto.VerifyResponse;
import registerService.entity.User;
import registerService.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final UserRepository userRepository;
    private final VerificationClient verificationClient;

    public RegisterResponse register(RegisterRequest request) {

        VerifyRequest verifyRequest = new VerifyRequest();

        verifyRequest.setEmail(request.getEmail());
        verifyRequest.setCode(request.getVerificationCode());

        VerifyResponse response =
                verificationClient.verify(verifyRequest);

        if (!response.isVerified()) {
            throw new RuntimeException("kod sehvdir");
        }

        User user = User.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .username(request.getUsername())
                .password(request.getPassword())
                .email(request.getEmail())
                .verified(true)
                .build();

        user.setVerified(true);

        userRepository.save(user);

        return RegisterResponse.builder()
                .message("qeydiyyat ugurludur")
                .build();
    }
}
