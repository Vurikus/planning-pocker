package my.app.metric;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthyController {

    @GetMapping("/liveness")
    @ResponseStatus(HttpStatus.OK)
    public void liveness() {
        //if controller is up then all application is up then we can say OK
    }
}
