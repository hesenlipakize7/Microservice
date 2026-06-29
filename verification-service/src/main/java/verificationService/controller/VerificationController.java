package verificationService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import verificationService.dto.SendOtpRequest;
import verificationService.dto.VerifyRequest;
import verificationService.dto.VerifyResponse;
import verificationService.service.VerificationService;

@RestController
@RequestMapping("/verification")
@RequiredArgsConstructor
public class VerificationController {

    private final VerificationService verificationService;

    @PostMapping("/send")
    public void send(@RequestBody SendOtpRequest request) {

        verificationService.send(request);
    }

    @PostMapping("/verify")
    public VerifyResponse verify(@RequestBody VerifyRequest request) {

        return verificationService.verify(request);
    }
}
