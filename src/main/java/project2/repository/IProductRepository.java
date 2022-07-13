package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project2.model.Product;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    // select all from product - BachLT
    // countQuery="SELECT count(ALL) from Product",
//    @Query(value="SELECT id_product,code_product,create_day,initial_price," +
//            "final_price,increment_price,name_product,product_description," +
//            "start_date,end_date,remaining_time," +
//            "name_approval_status,name_bidding_status,name_product_type AS p FROM Product " +
//            "INNER JOIN approvalstatus on Product.id_approval_status=approvalstatus.id_approval_status " +
//            "INNER JOIN biddingstatus on Product.id_bidding_status=biddingstatus.id_bidding_status" +
//            "INNER JOIN typeproduct on Product.id_product_type=typeproduct.id_product_type" +
//            "WHERE end_date BETWEEN ?1 AND ?2"
//    , nativeQuery=true)
    @Query(value="select p from Product p where p.endDate between ?1 and ?2")
    List<Product> findProductByEndDateAndBiddingStatus(String statsBegin,String statsEnd);

}
