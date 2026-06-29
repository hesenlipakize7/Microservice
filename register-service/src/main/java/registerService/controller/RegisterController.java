package registerService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import registerService.dto.RegisterRequest;
import registerService.dto.RegisterResponse;
import registerService.service.RegisterService;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {

    private final RegisterService registerService;

    @PostMapping
    public RegisterResponse register(@RequestBody RegisterRequest registerRequest){
        return registerService.register(registerRequest);
    }
}
