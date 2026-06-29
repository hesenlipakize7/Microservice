package registerService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import registerService.dto.VerifyRequest;
import registerService.dto.VerifyResponse;

@FeignClient(
        name = "verification-service",
        url = "http://localhost:8080",
        path = "verification"
)
public interface VerificationClient {

    @PostMapping("/verify")
    VerifyResponse verify(@RequestBody VerifyRequest request);

}
