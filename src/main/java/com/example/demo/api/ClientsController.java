package com.example.demo.api;

import com.example.demo.domain.repository.ClientRepository;
import com.example.demo.models.Client;
import com.example.demo.models.ValidCpf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public List<Client> clients(){
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> searchClient(@PathVariable @Valid Long id){
        Optional<Client> client = clientRepository.findById(id);

        if(client.isPresent()){
            return ResponseEntity.ok(client.get());
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<Client> searchClientByEmail(@PathVariable @Valid String email){
        Optional<Client> client = Optional.ofNullable(clientRepository.findByEmail(email));

        if(client.isPresent()){
            return ResponseEntity.ok(client.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<String> insertClient(@RequestBody @Valid Client client){
        var validCpf = new ValidCpf();
        validCpf.setCpfNumber(client.getCpf());
        System.out.println(client.getCpf());
        validCpf.validCpf(validCpf);

        System.out.println(validCpf.isValid());

        if(validCpf.isValid()){
            clientRepository.save(client);
            return ResponseEntity.created(URI.create("")).build();
        }
            return ResponseEntity.badRequest().body("invalid CPF");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client>  updateClient(@PathVariable @Valid Long id,@Valid @RequestBody Client client){
        if(!clientRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        client.setId(id);
        client = clientRepository.save(client);
        return ResponseEntity.ok().body(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@Valid @PathVariable long id){
        if(!clientRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        clientRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
