package com.acms.CentralSellerPortal.Controllers;


import com.acms.CentralSellerPortal.Entities.Seller;
import com.acms.CentralSellerPortal.Repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class SellerController {

    @Autowired
    SellerRepository sellerRepository;

    @RequestMapping(value="/addseller" , method=RequestMethod.POST)
    public RedirectView addseller(
            @RequestParam("s_name") String seller_name,
                               @RequestParam("s_address") String seller_address,
                               @RequestParam("s_shop") String shop_name,
                               @RequestParam("s_mail") String seller_emailId,
                               @RequestParam("s_mobile") String seller_contactNo,
                               @RequestParam("s_password") String password
                               ) {

  
        Seller seller=new Seller();
        seller.setSellerName(seller_name);
        seller.setSellerAddress(seller_address);
        seller.setShopName(shop_name);
        seller.setSellerEmailId(seller_emailId);
        seller.setSellerContactNo(seller_contactNo);
        seller.setSellerPassword(password);

        sellerRepository.save(seller);
        System.out.println("Successfully SignedUp,Please LOGIN!");
        return new RedirectView("/");
    }
    //ResponseEntity<Seller>

    @GetMapping("/sellers")
    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    @RequestMapping(value="/viewSeller/{id}" , method=RequestMethod.GET)
 public Seller getSellerById(@PathVariable(value = "id") Long seller_id)
   // public ResponseEntity<Seller>   getSellerById(@PathVariable(value = "id") Long seller_id)

    {
        Seller seller =sellerRepository.findById(seller_id).orElse(null);
        //return ResponseEntity.ok().body(seller);
        return seller;
    }

    @RequestMapping(value="/UpdateSeller/{id}" , method=RequestMethod.POST)
    public RedirectView updateUser(
            @PathVariable(value = "id") Long seller_id, @RequestParam("s_name") String seller_name,
            @RequestParam("s_address") String seller_address,
            @RequestParam("s_shop") String shop_name,
            @RequestParam("s_mail") String seller_emailId,
            @RequestParam("s_mobile") String seller_contactNo,
            @RequestParam("s_password") String password)
    {
        Seller seller =sellerRepository.findById(seller_id).orElse(null);
System.out.println("hi................................");
        seller.setSellerName(seller_name);
        seller.setSellerAddress(seller_address);
        seller.setShopName(shop_name);
        seller.setSellerEmailId(seller_emailId);
        seller.setSellerContactNo(seller_contactNo);
        seller.setSellerPassword(password);

        sellerRepository.save(seller);
        RedirectView rv = new RedirectView();
        String rurl="/Sellerdashboard.jsp?id="+Long.toString(seller.getSellerId());
        rv.setUrl(rurl);
        return rv;
    }
}
