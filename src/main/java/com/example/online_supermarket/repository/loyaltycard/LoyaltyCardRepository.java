package com.example.online_supermarket.repository.loyaltycard;

import com.example.online_supermarket.model.entity.loyaltycard.LoyaltyCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LoyaltyCardRepository extends JpaRepository<LoyaltyCard, UUID> {
}
