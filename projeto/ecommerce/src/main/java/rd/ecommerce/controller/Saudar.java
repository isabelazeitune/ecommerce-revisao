package rd.ecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Saudar {

    @GetMapping("/saudar")
    public ResponseEntity<String> saudar() {
        return ResponseEntity.ok().body("Bem vindo");
    }
}