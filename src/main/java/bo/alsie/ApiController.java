package bo.alsie;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/api/v1")
public class ApiController {

    @GetMapping("/hello-world/{name}")
    public ResponseEntity<?> api(@PathVariable String name) {
        HashMap<String, String> response = new HashMap<>();
        response.put("status", "OK");
        response.put("message", "Hello World "+name+"!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
