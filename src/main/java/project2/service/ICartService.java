package project2.service;
import project2.model.Cart;

public interface ICartService {
    Cart findByIdMember(Long id_member);
}
