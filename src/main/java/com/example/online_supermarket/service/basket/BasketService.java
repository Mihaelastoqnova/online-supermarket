package com.example.online_supermarket.service.basket;

import com.example.online_supermarket.model.entity.basket.Basket;
import com.example.online_supermarket.model.entity.user.User;
import com.example.online_supermarket.repository.basket.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BasketService {

    private final BasketRepository basketRepository;

    @Autowired
    public BasketService(BasketRepository basketRepository){
        this.basketRepository = basketRepository;
    }

    public void createBasketForUser(User userEntity) {
        Basket buildedBasket = Basket.builder()
                .lastUpdatedOn(LocalDateTime.now())
                .user(userEntity)
                .build();

        basketRepository.save(buildedBasket);
    }
}
