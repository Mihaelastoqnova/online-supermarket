package com.example.online_supermarket.model.entity.order;

import com.example.online_supermarket.model.entity.user.User;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private LocalDateTime orderedOn;

    @Column(nullable = false)
    private BigDecimal totalPrice;

    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
