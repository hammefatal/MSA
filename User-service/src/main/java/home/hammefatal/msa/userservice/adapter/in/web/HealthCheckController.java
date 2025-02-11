package home.hammefatal.msa.userservice.adapter.in.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/user/health-check")
    public String healthCheck() {
        return "User-service is running";
    }

}
