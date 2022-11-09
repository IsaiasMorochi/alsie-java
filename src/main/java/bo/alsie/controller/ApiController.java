package bo.alsie.controller;

import bo.alsie.service.ApiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class ApiController {

    private final ApiService service;

    public ApiController(ApiService service) {
        this.service = service;
    }

    @GetMapping("/hello-world/{name}")
    public ResponseEntity<?> api(@PathVariable String name) {
        var response = service.createMessage(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
