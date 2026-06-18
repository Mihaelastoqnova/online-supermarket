package com.example.online_supermarket.repository.basket;

import com.example.online_supermarket.model.entity.basket.BasketItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BasketItemRepository extends JpaRepository<BasketItem, UUID> {
}
