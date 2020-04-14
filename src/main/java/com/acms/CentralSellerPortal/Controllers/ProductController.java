package com.acms.CentralSellerPortal.Controllers;

import com.acms.CentralSellerPortal.Entities.Product;
import com.acms.CentralSellerPortal.Entities.Seller;
import com.acms.CentralSellerPortal.Repositories.ProductRepository;
import com.acms.CentralSellerPortal.Repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
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


    @RequestMapping(value = "/add/{id}",method=RequestMethod.POST)
    public String addProduct(@PathVariable(value = "id")Long  sellerId, @RequestParam String n , @RequestParam String d,
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

    @GetMapping(value = "/displayBySellerId/{id}")
    public RedirectView getProductBySellerId(@RequestParam Long  seller_id)
    {
        List<Product> productList = productRepository.findBySeller_SellerId(seller_id);
        System.out.println("Getting your PRODUCT details seller..please wait!!");
        //System.out.println(seller_id);
        Seller seller = sellerRepository.findById(seller_id).orElse(null);
        System.out.println(productList);
        session.setAttribute("productList",productList);
        System.out.println(session.getAttribute("productList"));
        RedirectView rv = new RedirectView();
        String rurl="/Sellerdashboard.jsp?id="+Long.toString(seller_id);
        rv.setUrl(rurl);
        return rv;
        //return productList;
        //return ResponseEntity.ok().body(productList);
    }
}
