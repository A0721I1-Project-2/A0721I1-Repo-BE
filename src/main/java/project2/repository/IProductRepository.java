package project2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project2.model.Product;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {


    // select all from product - BachLT

    @Query(value = "SELECT p FROM Product p WHERE p.endDate between ?1 and ?2 and p.biddingStatus.idBiddingStatus= ?3")
    List<Product> findProductByEndDateAndBiddingStatus(String statsBegin, String statsEnd, long biddingStatus);

    @Query(value = "SELECT * FROM Product  WHERE MONTH(end_date)=?1 and id_bidding_status= ?2", nativeQuery = true)
    List<Product> findProductByCurrentMonthAndBiddingStatus(int currentMonth, long biddingStatus);

    //HieuDV
    @Query(value = "select * from product " +
            "left join biddingstatus on product.id_bidding_status = biddingstatus.id_bidding_status left join typeproduct on product.id_product_type = typeproduct.id_product_type " +
            "left join approvalstatus on product.id_approval_status = approvalstatus.id_approval_status left join member on product.id_member = member.id_member " +
            "left join cart on product.id_cart = cart.id_cart where product.flag_delete = 0",
            nativeQuery = true)
    List<Product> findAllNotDeletedYet();

    //HieuDV
    @Query(value = "select * from product " +
            "left join biddingstatus on product.id_bidding_status = biddingstatus.id_bidding_status left join typeproduct on product.id_product_type = typeproduct.id_product_type " +
            "left join approvalstatus on product.id_approval_status = approvalstatus.id_approval_status left join member on product.id_member = member.id_member " +
            "left join cart on product.id_cart = cart.id_cart where product.flag_delete = 0",
            countQuery = "select count(id_product) from product " +
                    "left join biddingstatus on product.id_bidding_status = biddingstatus.id_bidding_status left join typeproduct on product.id_product_type = typeproduct.id_product_type " +
                    "left join approvalstatus on product.id_approval_status = approvalstatus.id_approval_status left join member on product.id_member = member.id_member where product.flag_delete = 0",
            nativeQuery = true)
    Page<Product> findAllNotDeletedYet(Pageable pageable);

    //HieuDV
    @Query(value = "select * from product " +
            "left join biddingstatus on product.id_bidding_status = biddingstatus.id_bidding_status left join typeproduct on product.id_product_type = typeproduct.id_product_type " +
            "left join approvalstatus on product.id_approval_status = approvalstatus.id_approval_status left join member on product.id_member = member.id_member " +
            "left join cart on product.id_cart = cart.id_cart where product.id_product= ?1 and product.flag_delete = 0",
            nativeQuery = true)
    Product findProductByIdProduct(Long id);

    //HieuDV
    @Query(value = "select * from product " +
            "left join biddingstatus on product.id_bidding_status = biddingstatus.id_bidding_status left join typeproduct on product.id_product_type = typeproduct.id_product_type " +
            "left join approvalstatus on product.id_approval_status = approvalstatus.id_approval_status left join member on product.id_member = member.id_member " +
            "where Product.name_product like %?1% and Product.id_product_type = ?2 and Member.name_member like %?3% and Product.initial_price < ?4 and Product.initial_price > ?5 " +
            "and Product.id_bidding_status = ?6 and product.flag_delete = 0",
            nativeQuery = true)
    List<Product> findAllProductByNameTypeSellerPriceStatus(String name, String typeProduct, String sellerName, String maxPrice, String minPrice, String BiddingStatus);

    //HieuDV
    @Query(value = "select * from product " +
            "left join biddingstatus on product.id_bidding_status = biddingstatus.id_bidding_status left join typeproduct on product.id_product_type = typeproduct.id_product_type " +
            "left join approvalstatus on product.id_approval_status = approvalstatus.id_approval_status left join member on product.id_member = member.id_member " +
            "where product.name_product like %?1% and typeproduct.name_product_type like %?2% and member.name_member like %?3% and product.initial_price < ?4 and product.initial_price > ?5 " +
            "and biddingstatus.name_bidding_status like %?6% and product.flag_delete = 0",
            countQuery = "select count(id_product)from product " +
                    "left join biddingstatus on product.id_bidding_status = biddingstatus.id_bidding_status left join typeproduct on product.id_product_type = typeproduct.id_product_type " +
                    "left join approvalstatus on product.id_approval_status = approvalstatus.id_approval_status left join member on product.id_member = member.id_member " +
                    "where product.name_product like %?1% and typeproduct.name_product_type like %?2% and member.name_member like %?3% and product.initial_price < ?4 and product.initial_price > ?5 " +
                    "and biddingstatus.name_bidding_status like %?6% and product.flag_delete = 0",
            nativeQuery = true)
    Page<Product> findAllProductByNameTypeSellerPriceStatus(String name, String typeProduct, String sellerName, String maxPrice, String minPrice, String BiddingStatus, Pageable pageable);






}
