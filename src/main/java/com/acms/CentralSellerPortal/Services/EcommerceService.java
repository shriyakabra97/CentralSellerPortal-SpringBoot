package com.acms.CentralSellerPortal.Services;

import com.acms.CentralSellerPortal.Entities.Ecommerce;
import com.acms.CentralSellerPortal.Repositories.EcommerceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EcommerceService {

    @Autowired
    EcommerceRepository ecommerceRepository;



    public void save(Ecommerce ecommerce)
    {
        ecommerceRepository.save(ecommerce);
    }
}
