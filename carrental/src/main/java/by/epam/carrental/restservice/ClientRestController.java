package by.epam.carrental.restservice;

import by.epam.carrental.entity.Client;
import by.epam.carrental.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/client")
public class ClientRestController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getClientsList(){
        return ResponseEntity.ok(clientService.readAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id){
        try{
            return ResponseEntity.ok(clientService.read(id.toString()));
        } catch (IncorrectResultSizeDataAccessException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        clientService.create(client);
        return ResponseEntity.ok(client);
    }

    @PutMapping
    public ResponseEntity<Void> updateClient(@RequestBody Client client){
        clientService.update(client);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id){
        clientService.delete(id.toString());
        return ResponseEntity.noContent().build();
    }

}
