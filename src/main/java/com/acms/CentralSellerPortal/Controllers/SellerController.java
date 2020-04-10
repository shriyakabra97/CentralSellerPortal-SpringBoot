package com.acms.CentralSellerPortal.Controllers;


import com.acms.CentralSellerPortal.Entities.Seller;
import com.acms.CentralSellerPortal.Exception.ResourceNotFoundException;
import com.acms.CentralSellerPortal.Repositories.SellerRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class SellerController {

    @Autowired
    SellerRepository sellerRepository;

    @RequestMapping(value="/addseller" , method=RequestMethod.POST)
    public String addseller(
            @RequestParam("s_name") String seller_name,
                               @RequestParam("s_address") String seller_address,
                               @RequestParam("s_shop") String shop_name,
                               @RequestParam("s_mail") String seller_emailId,
                               @RequestParam("s_mobile") String seller_contactNo,
                               @RequestParam("s_password") String password
                               ) {

        Seller seller=new Seller();
        seller.setSeller_name(seller_name);
        seller.setSeller_address(seller_address);
        seller.setShop_name(shop_name);
        seller.setSeller_emailId(seller_emailId);
        seller.setSeller_contactNo(seller_contactNo);
        seller.setSeller_password(password);

        sellerRepository.save(seller);
        return "updated to database";
    }

    @GetMapping("/sellers")
    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    @GetMapping("/seller/{id}")

    public ResponseEntity<Seller> getSellerById(@PathVariable(value = "id") Long seller_id)
    {
        Seller seller =sellerRepository.findById(seller_id).orElse(null);
        return ResponseEntity.ok().body(seller);
    }
}
