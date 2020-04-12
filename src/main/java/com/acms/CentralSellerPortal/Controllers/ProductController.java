package com.acms.CentralSellerPortal.Controllers;

import com.acms.CentralSellerPortal.Entities.Product;
import com.acms.CentralSellerPortal.Entities.Seller;
import com.acms.CentralSellerPortal.Repositories.ProductRepository;
import com.acms.CentralSellerPortal.Repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    //@Qualifier("productRepository")
    ProductRepository productRepository ;
    @Autowired
   // @Qualifier("sellerRepository")
    SellerRepository sellerRepository;


    @GetMapping(value = "/add")
    public String addProduct(@RequestParam Long  sellerId, @RequestParam String n , @RequestParam String d,
                             @RequestParam int p, @RequestParam int disc)
    {
        Product product = new Product();
        product.setProductName(n);
        product.setProductDescription(d);
        product.setPrice(p);
        product.setDiscount(disc);

        Optional<Seller> optionalSeller = sellerRepository.findById(sellerId);
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
            product.setProductName(n);
            product.setProductDescription(d);
            product.setPrice(p);
            product.setDiscount(disc);

            productRepository.save(product);
            return "updated";
        }
        else
            return "error updating";
    }

    @GetMapping(value = "/displayAll")
    public ResponseEntity<List<Product>> getAllProduct()
    {
        List<Product> productList =productRepository.findAll();
        return ResponseEntity.ok().body(productList);
    }


    @GetMapping(value = "/displayById")
    public ResponseEntity<Product> getProductById(@RequestParam Long  product_id)
    {
        Product product =productRepository.findById(product_id).orElse(null);
        return ResponseEntity.ok().body(product);
    }

    @GetMapping(value = "/displayBySellerId")
    public List<Product> getProductBySellerId(@RequestParam Long  seller_id)
    {
        List<Product> productList = productRepository.findBySeller_SellerId(seller_id);
        return productList;
        //return ResponseEntity.ok().body(productList);
    }
}
