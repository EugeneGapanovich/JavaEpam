package by.epam.carrental.restservice;

import by.epam.carrental.entity.Order;
import by.epam.carrental.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/order")
public class OrderRestController {

    @Autowired
    OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getOrdersList(){
        return ResponseEntity.ok(orderService.readAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        try{
            return ResponseEntity.ok(orderService.read(id.toString()));
        } catch (IncorrectResultSizeDataAccessException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        orderService.create(order);
        return ResponseEntity.ok(order);
    }

    @PutMapping
    public ResponseEntity<Void> updateOrder(@RequestBody Order order){
        orderService.update(order);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id){
        orderService.delete(id.toString());
        return ResponseEntity.noContent().build();
    }
}
