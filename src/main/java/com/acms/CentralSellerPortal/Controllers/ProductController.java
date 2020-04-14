package com.acms.CentralSellerPortal.Controllers;

import com.acms.CentralSellerPortal.Entities.Product;
import com.acms.CentralSellerPortal.Entities.Seller;
import com.acms.CentralSellerPortal.Repositories.ProductRepository;
import com.acms.CentralSellerPortal.Repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.view.RedirectView;


import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
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

    @RequestMapping(value = "/displayBySellerId/{id}", method = RequestMethod.GET)
    public RedirectView getProductBySellerId(@PathVariable(value = "id") long seller_id, HttpSession session)
    {
        List<Product> productList = productRepository.findBySeller_SellerId(seller_id);
        System.out.println("getting Products");
        System.out.println(productList.get(0));
        String[][] str = new String[productList.size()][5];
        for(int i = 0; i < productList.size(); i++){

                session.setAttribute("string"+i+"0", productList.get(i).getProductId());
                session.setAttribute("string"+i+"1", productList.get(i).getProductName());
                session.setAttribute("string"+i+"2", productList.get(i).getProductDescription());
                session.setAttribute("string"+i+"3", productList.get(i).getPrice());
                session.setAttribute("string"+i+"4", productList.get(i).getDiscount());

        }
        //System.out.println((String)string[0][1]);
        //System.out.println(session.getAttribute("string00"));
        RedirectView rv = new RedirectView();
        String rurl="/SellerDashboard.jsp?id="+Long.toString(seller_id);
        System.out.println(rurl);
        rv.setUrl(rurl);
        return rv;



        //return ResponseEntity.ok().body(productList);
    }
}
