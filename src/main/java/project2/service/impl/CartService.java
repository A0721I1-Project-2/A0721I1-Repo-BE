package project2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project2.model.Cart;
import project2.repository.ICartRepository;
import project2.service.ICartService;
@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository iCartRepository;

}
