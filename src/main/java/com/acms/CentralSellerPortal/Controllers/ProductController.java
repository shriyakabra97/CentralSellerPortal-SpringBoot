package com.acms.CentralSellerPortal.Controllers;

import com.acms.CentralSellerPortal.Entities.Product;
import com.acms.CentralSellerPortal.Entities.Seller;
import com.acms.CentralSellerPortal.Repositories.ProductRepository;
import com.acms.CentralSellerPortal.Repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository ;
    @Autowired
    SellerRepository sellerRepository;

    @GetMapping(value = "/add")
    public String addProduct(@RequestParam Long  sellerId, @RequestParam String n , @RequestParam String d,
                             @RequestParam int p, @RequestParam int disc)
    {
        Product product = new Product();
        product.setProduct_name(n);
        product.setProduct_description(d);
        product.setPrice(p);
        product.setDiscount(disc);

        Optional<Seller> optionalSeller = sellerRepository.findById(Math.toIntExact(sellerId));
        if(optionalSeller.isPresent()) {
            Seller seller = optionalSeller.get();
            product.setSeller(seller);
            productRepository.save(product);
            return "Saved";
        }
        else
             return "unsuccessful";
    }

    @GetMapping(value = "/update")
    public String updateProduct(@RequestParam Long  productId, @RequestParam String n , @RequestParam String d,
                                @RequestParam int p, @RequestParam int disc)
    {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setProduct_name(n);
            product.setProduct_description(d);
            product.setPrice(p);
            product.setDiscount(disc);

            productRepository.save(product);
            return "updated";
        }
        else
            return "error updating";
    }
}
