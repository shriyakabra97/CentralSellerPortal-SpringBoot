package com.acms.CentralSellerPortal.Repositories;

import com.acms.CentralSellerPortal.Entities.Seller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("sellerRepository")
public interface SellerRepository extends CrudRepository<Seller, Integer> {
}
