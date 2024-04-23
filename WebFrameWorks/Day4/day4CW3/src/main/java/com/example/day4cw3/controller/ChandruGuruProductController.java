package com.example.day4cw3.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.day4cw3.model.ChandruGuruProduct;
import com.example.day4cw3.services.ChandruGuruProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class ChandruGuruProductController {
    public ChandruGuruProductService productService;
    public ChandruGuruProductController(ChandruGuruProductService productService)
    {
        this.productService=productService;
    }
    @PostMapping("/api/product")
    public ResponseEntity<ChandruGuruProduct> postMethodName(@RequestBody ChandruGuruProduct product) {
        if(productService.saveProduct(product))
        {
            return new ResponseEntity<>(product,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * @return
     */
    @SuppressWarnings("null")
    @GetMapping("/api/product")
    public ResponseEntity<List<ChandruGuruProduct>> getMethodName() {
        List<ChandruGuruProduct> list =  productService.getProducts();
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @GetMapping("/api/product/{productId}")
    public ResponseEntity<ChandruGuruProduct> getMethodName(@PathVariable("productId") int id) {
        ChandruGuruProduct p =  productService.getProductById(id);
        if(p==null)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
    
}
