package com.acms.CentralSellerPortal.Controllers;

import com.acms.CentralSellerPortal.Entities.Ecommerce;
import com.acms.CentralSellerPortal.Entities.Product;
import com.acms.CentralSellerPortal.Repositories.EcommerceRepository;
import com.acms.CentralSellerPortal.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/ecomm")
public class EcommerceController {

    @Autowired
    EcommerceRepository ecommerceRepository;
    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value="/addecommerce")
    public RedirectView addecommerce(@RequestParam("cName") String ecommerce_name,
                                     @RequestParam("cEmailId") String ecommerce_emailId,
                                     @RequestParam("cPassword") String ecommerce_password)
    {

        Ecommerce ecommerce=new Ecommerce();
        ecommerce.setEcommName(ecommerce_name);
        ecommerce.setEcommEmailId(ecommerce_emailId);
        ecommerce.setEcommPassword(ecommerce_password);

        ecommerceRepository.save(ecommerce);
        System.out.println("inside ecomm controller after saving data in db..");
        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/index.html");
        return redirectView;
    }
    @GetMapping("/displayAllEcommerce")
    public ResponseEntity<List<Ecommerce>> getAllEcommerce() {
        System.out.println("Evaluating emmorece : ");
        List<Ecommerce> ecommerceList =ecommerceRepository.findAll();
        System.out.println("Displaying emmorece : ");
        return ResponseEntity.ok().body(ecommerceList);
    }

    @GetMapping(value = "/displayAllProducts")
    public ResponseEntity<List<Product>> getAllProduct()
    {
        List<Product> productList =productRepository.findAll();
        return ResponseEntity.ok().body(productList);
    }


}