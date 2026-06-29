package verificationService.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import verificationService.dto.SendOtpRequest;
import verificationService.dto.VerifyRequest;
import verificationService.dto.VerifyResponse;
import verificationService.model.entity.VerificationCode;
import verificationService.repository.VerificationRepository;
import verificationService.service.VerificationService;

@Service
@RequiredArgsConstructor
public class VerificationServiceImpl implements VerificationService {

    private final VerificationRepository verificationRepository;


    @Override
    public void send(SendOtpRequest sendOtpRequest) {

        String code = String.valueOf((int) (Math.random() * 900000) + 100000);

        VerificationCode verificationCode = VerificationCode.builder()
                .email(sendOtpRequest.getEmail())
                .code(code)
                .verified(false)
                .build();
        verificationRepository.save(verificationCode);
        System.out.println(" OTP code : " + code);


    }

    @Override
    public VerifyResponse verify(VerifyRequest verifyRequest) {
        VerificationCode verificationCode = verificationRepository.findByEmail(verifyRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Verification code not found"));
        if (verificationCode.getCode().equals(verifyRequest.getCode())) {
            verificationCode.setVerified(true);
            verificationRepository.save(verificationCode);
            return VerifyResponse.builder()
                    .verified(true)
                    .build();
        }
        return VerifyResponse.builder()
                .verified(false)
                .build();
    }
}
