package project2.service;
import project2.model.Cart;

import project2.model.Cart;
import project2.model.Member;

public interface ICartService {
    Cart findByIdMember(Long id_member);
    void createCart(Cart cart);
    void updateCart(Cart cart);
    Cart findById(Long id);
}
