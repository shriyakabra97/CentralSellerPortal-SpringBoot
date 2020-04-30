package com.acms.CentralSellerPortal.Repositories;

import com.acms.CentralSellerPortal.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.acms.CentralSellerPortal.Entities.Seller;


import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    @Query(value="select * from product p where p.seller_id=seller_id",nativeQuery = true)
    List<Product> findBySeller_Id(Long seller_id);
}