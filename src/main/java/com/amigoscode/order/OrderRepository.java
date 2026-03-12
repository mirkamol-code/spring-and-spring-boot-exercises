package com.amigoscode.order;

import com.amigoscode.customer.Customer;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// TODO: 12 - Create the OrderRepository class:
//  - Annotate with @Repository
//  - Add a private List<Order> field initialized with sample orders (use ArrayList)
//  - Add a private long nextId field starting at 4
//  - Implement these methods:
//    List<Order> findAll()
//    Optional<Order> findById(Long id)
//    List<Order> findByStatus(String status)
//    Order save(Order order) — sets the id and adds to the list
//    void update(Order order) — finds by id and updates fields
//    boolean deleteById(Long id) — removes from list
//  Hint: look at CustomerRepository for reference
@Repository
public class OrderRepository {
    private final List<Order> orders = new ArrayList<>(List.of(
            new Order(
                    1L,
                    "Laptop",
                    "PENDING",
                    999.99,
                    "john@mail.com",
                    LocalDate.now(),
                    "rush"),
            new Order(2L,
                    "Phone",
                    "NOT PENDING",
                    8349.99,
                    "tom@mail.com",
                    LocalDate.now(),
                    "slow"),
            new Order(3L,
                    "Ipad",
                    "PENDING",
                    7349.99,
                    "jim@mail.com",
                    LocalDate.now(),
                    "norm")
    ));

    private Long nextId = 4L;
    public List<Order> findAll() {
        return orders;
    }

    public Optional<Order> findById(Long id) {
        return orders.stream()
                .filter(order -> order.getId().equals(id))
                .findFirst();
    }

    public Order save(Order order) {
        order.setId(nextId++);
        orders.add(order);
        return order;
    }

    public void update(Order order) {
        findById(order.getId()).ifPresent(existing -> {
            existing.setDescription(order.getDescription());
            existing.setStatus(order.getStatus());
            existing.setTotalAmount(order.getTotalAmount());
            existing.setInternalNotes(order.getInternalNotes());
        });
    }

    public boolean deleteById(Long id) {
        return orders.removeIf(c -> c.getId().equals(id));
    }

}