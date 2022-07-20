package project2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;
import project2.dto.TransactionDTO;
import project2.model.Product;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {


    // BachLT
    @Query(value = "SELECT p FROM Product p WHERE p.endDate between ?1 and ?2 and p.biddingStatus.idBiddingStatus= ?3 and p.flagDelete = 0")
    List<Product> findProductByEndDateAndBiddingStatus(String statsBegin, String statsEnd, long biddingStatus);

    // BachLT
    @Query(value = "SELECT * FROM Product  WHERE MONTH(end_date)=?1 and id_bidding_status= ?2 and product.flag_delete = 0", nativeQuery = true)
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
            "where product.name_product like %?1% and product.id_product_type = ?2 and member.name_member like %?3% and product.initial_price < ?4 and product.initial_price > ?5 " +
            "and product.id_bidding_status = ?6 and product.flag_delete = 0",
            countQuery = "select count(id_product)from product " +
                    "left join biddingstatus on product.id_bidding_status = biddingstatus.id_bidding_status left join typeproduct on product.id_product_type = typeproduct.id_product_type " +
                    "left join approvalstatus on product.id_approval_status = approvalstatus.id_approval_status left join member on product.id_member = member.id_member " +
                    "where product.name_product like %?1% and product.id_product_type = ?2 and member.name_member like %?3% and product.initial_price < ?4 and product.initial_price > ?5 " +
                    "and product.id_bidding_status = ?6 and product.flag_delete = 0",
            nativeQuery = true)
    Page<Product> findAllProductByNameTypeSellerPriceStatus(String name, String typeProduct, String sellerName, String maxPrice, String minPrice, String BiddingStatus, Pageable pageable);

    //VinhTQ
    @Query(value = "select * from product " +
            "join product_member on product_member.id_product = product.id_product " +
            "join member on member.id_member = product_member.id_member " +
            "where product.id_product =?1", nativeQuery = true)
    Product findProductByIdForProductDetail(long id);

    //HauLST - List sp đang đấu giá, và sắp xếp theo thời gian còn lại từ ít nhất -> nhiều nhất
    @Query(value = "select * from Product inner join TypeProduct on Product.id_product_type = TypeProduct.id_product_type \n" +
            " inner join BiddingStatus on Product.id_bidding_status = BiddingStatus.id_bidding_status \n" +
            " inner join ApprovalStatus on Product.id_approval_status = ApprovalStatus.id_approval_status \n" +
            " where BiddingStatus.name_bidding_status= \"auction\" and ApprovalStatus.name_approval_status = \"posted\" and (Product.end_date > now()) \n" +
            " order by Product.end_date  asc", nativeQuery = true)
    List<Product> findAllProductAuction();

    //HauLST - List sp đấu giá đã kết thúc ( có thể thành công hoặc thất bại ), và sắp xếp theo thời gian tạo từ mới nhất -> cũ nhất
    @Query(value = " select * from Product inner join TypeProduct on Product.id_product_type = TypeProduct.id_product_type \n" +
            " inner join BiddingStatus on Product.id_bidding_status = BiddingStatus.id_bidding_status \n" +
            " inner join ApprovalStatus on Product.id_approval_status = ApprovalStatus.id_approval_status\n" +
            " where ApprovalStatus.name_approval_status = \"posted\"\n" +
            " and (Product.end_date <now()) \n" +
            " order by Product.end_date desc", nativeQuery = true)
    List<Product> findAllProductFinishedAuction();

    //HauLST - List sp đang đấu giá và theo từng category, và có sắp xếp theo thời gian tạo từ mới nhất -> cũ nhất
    @Query(value = "select * from Product inner join TypeProduct on Product.id_product_type = TypeProduct.id_product_type \n" +
            " inner join BiddingStatus on Product.id_bidding_status = BiddingStatus.id_bidding_status \n" +
//            " inner join ImageProduct on Product.id_product = ImageProduct.id_product\n" +
            " inner join ApprovalStatus on Product.id_approval_status = ApprovalStatus.id_approval_status \n" +
            " where BiddingStatus.name_bidding_status= \"auction\" \n" +
            " and ApprovalStatus.name_approval_status = \"posted\"\n" +
            " and TypeProduct.name_product_type like %?1% \n" +
            " and (Product.end_date > now()) \n" +
            " order by Product.end_date asc", nativeQuery = true)
    List<Product> gettAllProductAuntionAndTypeProduct(String nameTypeProduct);

    //HauLST - Search sp theo nameProduct, typeProduct, prices range
    @Query(value = "select * from Product \n" +
            "inner join TypeProduct on Product.id_product_type = TypeProduct.id_product_type \n" +
            "inner join BiddingStatus on Product.id_bidding_status = BiddingStatus.id_bidding_status \n" +
            "inner join ApprovalStatus on Product.id_approval_status = ApprovalStatus.id_approval_status\n" +
            "where BiddingStatus.name_bidding_status= \"auction\" \n" +
            "and ApprovalStatus.name_approval_status = \"posted\"\n" +
            "and Product.name_product like %?1% \n" +
            "and TypeProduct.name_product_type like %?2% \n" +
            "and (Product.final_price between ?3 and ?4)\n" +
            "order by Product.end_date asc", nativeQuery = true)
    List<Product> searchProductByNameByTypeProductByPrice(String nameProduct, String nameTypeProduct, Double min, Double max);

    //HauLST - Search sp theo nameProduct, typeProduct, prices range>250
    @Query(value = "select * from Product \n" +
            "inner join TypeProduct on Product.id_product_type = TypeProduct.id_product_type \n" +
            "inner join BiddingStatus on Product.id_bidding_status = BiddingStatus.id_bidding_status \n" +
            "inner join ApprovalStatus on Product.id_approval_status = ApprovalStatus.id_approval_status\n" +
            "where BiddingStatus.name_bidding_status= \"auction\" \n" +
            "and ApprovalStatus.name_approval_status = \"posted\" and (Product.end_date > now()) \n" +
            "and Product.name_product like %?1% \n" +
            "and TypeProduct.name_product_type like %?2% \n" +
            "and (Product.final_price >?3)\n" +
            "order by Product.end_date asc", nativeQuery = true)
    List<Product> searchProductPricesOver250(String nameProduct, String nameTypeProduct, Double min);


}
