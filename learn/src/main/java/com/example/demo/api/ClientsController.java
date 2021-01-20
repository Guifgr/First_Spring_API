package com.example.demo.api;

import com.example.demo.domain.repository.ClientRepository;
import com.example.demo.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client insertClient(@RequestBody @Valid Client client){
        return clientRepository.save(client);
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
