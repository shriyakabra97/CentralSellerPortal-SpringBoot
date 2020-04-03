package com.acms.CentralSellerPortal.Controllers;


import com.acms.CentralSellerPortal.Entities.Seller;
import com.acms.CentralSellerPortal.Repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class SellerController {

    @Autowired
    SellerRepository sellerRepository;

    @GetMapping("/seller/{seller_id}")
    public Seller show(@PathVariable String seller_id){
        long seller_Id = Integer.parseInt(seller_id);
        return sellerRepository.findById(seller_Id).orElse(null);
    }

    @PostMapping("/seller")
    public Seller create(@RequestBody Map<String,String> body){
        String seller_name = body.get("seller_name");
        String seller_address = body.get("seller_address");
        String shop_name = body.get("shop_name");
        String seller_contactNo = body.get("seller_contactNo");
        String seller_emailId = body.get("seller_emailId");
        return sellerRepository.save(new Seller(seller_name, seller_address , shop_name , seller_contactNo, seller_emailId));
    }

    @PutMapping("/seller/{seller_id}")
    public Seller update(@PathVariable String seller_id, @RequestBody Map<String, String> body){
        long seller_Id = Integer.parseInt(seller_id);
        Seller seller = sellerRepository.findById(seller_Id).orElse(null);
            String seller_name = body.get("seller_name");
            String seller_address = body.get("seller_address");
            String shop_name = body.get("shop_name");
            String seller_contactNo = body.get("seller_contactNo");
            String seller_emailId = body.get("seller_emailId");
            return sellerRepository.save(seller);
        }


}














