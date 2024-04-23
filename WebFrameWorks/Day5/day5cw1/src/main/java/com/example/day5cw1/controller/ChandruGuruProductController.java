package com.example.day5cw1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.day5cw1.model.ChandruGuruProduct;
import com.example.day5cw1.service.ChandruGuruProductService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class ChandruGuruProductController {
    public ChandruGuruProductService productService;
    public ChandruGuruProductController(ChandruGuruProductService productService)
    {
        this.productService = productService;
    }
    @PostMapping("/api/product")
    public ResponseEntity<ChandruGuruProduct> postMethodName(@RequestBody ChandruGuruProduct product) {
        if(productService.saveProduct(product) == true)
        {
            return new ResponseEntity<>(product,HttpStatus.CREATED);
        }
        
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/api/product/{productId}")
    public ResponseEntity<ChandruGuruProduct> putMethodName(@PathVariable("productId") int id, @RequestBody ChandruGuruProduct product) {
        if(productService.updateDetails(id,product) == true)
        {
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("api/product/{productId}")
    public ResponseEntity<ChandruGuruProduct> delete(@PathVariable("productId") int id,@RequestBody ChandruGuruProduct product)
    {
        if(productService.deleteProduct(id) == true)
        {
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
}
