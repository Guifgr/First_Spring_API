package com.example.demo.api;

import com.example.demo.models.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ApiController {
    @GetMapping("/clients")
    public List<Client> Listar(){
        Client client1 = new Client();
        client1.setId(1);
        client1.setName("Yan");
        client1.setEmail("yanandrey88@gmail.com");
        client1.setPhone("11 99999-9999");
        client1.setPassword("************");

        Client client2 = new Client();
        client2.setId(2);
        client2.setName("Mauro");
        client2.setEmail("mauromanso@gmail.com");
        client2.setPhone("11 99999-9999");
        client2.setPassword("************");

        Client client3 = new Client();
        client3.setId(3);
        client3.setName("Carl Johnson");
        client3.setEmail("CJ@rockstar.com");
        client3.setPhone("1-800-BEAHERO");
        client3.setPassword("************");


        return Arrays.asList(client1, client2, client3);
    }
}
