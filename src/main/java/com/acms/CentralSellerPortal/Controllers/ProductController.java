package com.acms.CentralSellerPortal.Controllers;

import com.acms.CentralSellerPortal.Entities.Product;
import com.acms.CentralSellerPortal.Entities.Seller;
import com.acms.CentralSellerPortal.Repositories.ProductRepository;
import com.acms.CentralSellerPortal.Repositories.SellerRepository;
import com.acms.CentralSellerPortal.Services.ProductService;
import com.acms.CentralSellerPortal.Services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.view.RedirectView;


import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    SellerService sellerService;


    @RequestMapping(value = "/postProduct/{s_id}", method=RequestMethod.POST)
    public RedirectView postProduct(@PathVariable(value = "s_id") Long seller_id,
                                   @RequestParam("p_name") String n ,
                                   @RequestParam("p_description") String d,
                                   @RequestParam("p_price") int p,
                                   @RequestParam("p_discount") int disc)
    {
        Product product = new Product();
        product.setProductName(n);
        product.setProductDescription(d);
        product.setPrice(p);
        product.setDiscount(disc);

        Seller seller = sellerService.findById(seller_id);

            product.setSeller(seller);
            productService.save(product);


        RedirectView rv = new RedirectView();
        String rurl="/SellerDashboard.jsp?id="+seller_id;
        rv.setUrl(rurl);
        return rv;

    }

    @RequestMapping(value = "/putProduct/{p_id}/{s_id}" , method = RequestMethod.POST)
    public RedirectView putProduct(@PathVariable(value = "p_id") Long product_id,
                                      @PathVariable(value = "s_id") Long seller_id,
                                      @RequestParam("ep_name") String n ,
                                      @RequestParam("ep_description") String d,
                                      @RequestParam("ep_price") int p,
                                      @RequestParam("ep_discount") int disc)
    {
        Product product = productService.findById(product_id);

            product.setProductName(n);
            product.setProductDescription(d);
            product.setPrice(p);
            product.setDiscount(disc);

            productService.save(product);

            RedirectView rv = new RedirectView();
            String rurl="/SellerDashboard.jsp?id="+seller_id;
            System.out.println(rurl);
            rv.setUrl(rurl);
            return rv;

    }

    @RequestMapping(value = "/deleteProduct/{p_id}/{s_id}")
    public RedirectView deleteProduct(@PathVariable(value = "p_id") Long product_id,
                                      @PathVariable(value = "s_id") Long seller_id
    ){
        productService.deleteById(product_id);

        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        String rurl = "/SellerDashboard.jsp?id="+seller_id;
        redirectView.setUrl(rurl);
        return redirectView;
    }

    @RequestMapping(value = "/getProductsForSellerId/{id}", method = RequestMethod.GET)
    public RedirectView getProductBySellerId(@PathVariable(value = "id") long seller_id, HttpSession session)
    {
        List<Product> productList = productService.findBySeller_Id(seller_id);

        session.setAttribute("productList",productList);
        RedirectView rv = new RedirectView();
        String rurl="/MyProducts.jsp?id="+seller_id;
        System.out.println(rurl);
        rv.setUrl(rurl);
        return rv;

    }
}