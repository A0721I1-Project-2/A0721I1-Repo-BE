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

    @Query(value = "SELECT p FROM Product p WHERE p.endDate between ?1 and ?2 and p.biddingStatus.idBiddingStatus= ?3")
    List<Product> findProductByEndDateAndBiddingStatus(String statsBegin, String statsEnd,  long biddingStatus);

    @Query(value = "SELECT * FROM Product  WHERE MONTH(end_date)=?1 and id_bidding_status= ?2", nativeQuery = true)
    List<Product> findProductByCurrentMonthAndBiddingStatus(int currentMonth, long biddingStatus);
}
