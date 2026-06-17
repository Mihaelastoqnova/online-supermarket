package com.example.online_supermarket.model.entity.loyalty_card;

import com.example.online_supermarket.model.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
@Entity
@Table
public class LoyaltyCard {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String cardNumber;

    @Column(nullable = false)
    private int points;

    private LocalDateTime issuedOn;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    public LoyaltyCard(){
        this.points = 0;
        this.issuedOn = LocalDateTime.now();
    }

}
