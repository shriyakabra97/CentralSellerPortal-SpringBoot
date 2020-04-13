package com.acms.CentralSellerPortal.Repositories;

import com.acms.CentralSellerPortal.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.acms.CentralSellerPortal.Entities.Seller;


import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findBySeller_SellerId(Long seller_id);
}