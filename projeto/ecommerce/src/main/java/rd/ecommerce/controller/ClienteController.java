package rd.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import rd.ecommerce.model.ClienteModel;
import rd.ecommerce.repository.ClienteRepository;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public ResponseEntity listar() {
        List<ClienteModel> clientes = clienteRepository.findAll();
        return ResponseEntity.ok().body("Lista de clientes: " + clientes);
    }

//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping("/clientes")
//    public ResponseEntity adicionar(@RequestBody ClienteModel clienteModel) {
//        return ResponseEntity.ok().body(clienteRepository.save(clienteModel));
//    }

    @PostMapping("/clientes")
    public ResponseEntity adicionar(@RequestBody ClienteModel clienteModel) {
        return ResponseEntity.status(201).body(clienteRepository.save(clienteModel));
    }

//    @PostMapping("/clientes")
//    public ResponseEntity<?> adicionar(@RequestBody ClienteModel clienteModel) {
//        Cliente clienteAtualizado = clienteRepository.save(cliente);
//        return new ResponseEntity<>(clienteAtualizado, HttpStatus.CREATED);
//    }

//    @GetMapping("/clientes/{id}")
//    public ResponseEntity mostrar(@PathVariable("idCliente") Long id) {
//        ClienteModel cliente = clienteRepository.findById(id).get();
//        return ResponseEntity.status(200).body(cliente);
//    }

//    @GetMapping("/clientes/{id}")
//    public ResponseEntity mostrar(@PathVariable("idCliente") Long id) {
//        Optional<ClienteModel> cliente = clienteRepository.findById(id);
//        cliente.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND), "Não encontrado");
//        return ResponseEntity.status(200).body(cliente);
//    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity mostrar(@PathVariable("idCliente") Long id) {
        Optional<ClienteModel> opt_cliente = clienteRepository.findById(id);
        ClienteModel cliente = opt_cliente.orElse(null);
        if(cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(cliente);
    }

}
