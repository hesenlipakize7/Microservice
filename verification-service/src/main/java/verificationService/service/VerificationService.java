package verificationService.service;

import verificationService.dto.SendOtpRequest;
import verificationService.dto.VerifyRequest;
import verificationService.dto.VerifyResponse;

public interface VerificationService {

    void send(SendOtpRequest sendOtpRequest);

    VerifyResponse verify(VerifyRequest verifyRequest);
}
