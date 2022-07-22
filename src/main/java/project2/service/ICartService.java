package project2.service;

import project2.model.Cart;
import project2.model.Member;

public interface ICartService {
    Cart findById(Long id);
}
