package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project2.model.Product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project2.model.Product;
import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    // QuangNV write method get product in cart
    @Query(value = "select product.id_product, product.code_product, product.create_day, product.end_date, product.final_price, product.increment_price, product.initial_price, product.flag_delete " +
            ",product.name_product, product.product_description, product.remaining_time, product.start_date, product.id_approval_status, product.id_bidding_status, product.id_bidding_status" +
            ", product.id_cart ,product.id_product_type" +
            " from product inner join cart on product.id_cart = cart.id_cart " +
            "inner join member on member.id_member = cart.id_member " +
            "where product.flag_delete = 0 and cart.id_member = ?1", nativeQuery = true)
    List<Product> getProductInCart(int i);
}
