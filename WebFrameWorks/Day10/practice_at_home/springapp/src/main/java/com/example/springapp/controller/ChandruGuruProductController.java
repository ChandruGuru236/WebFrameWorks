package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.ChandruGuruProduct;
import com.example.springapp.service.ChandruGuruProductService;

@RestController
@RequestMapping("/api")
public class ChandruGuruProductController {

    @Autowired
    private ChandruGuruProductService productService;

    @PostMapping("/product")
    public ResponseEntity<ChandruGuruProduct> save(@RequestBody ChandruGuruProduct product) {
        if(productService.saveProduct(product))
            return new ResponseEntity<ChandruGuruProduct>(product, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/product/bycategory/{category}")
    public ResponseEntity<List<ChandruGuruProduct>> findByCategory(@PathVariable String category) {
        
        List<ChandruGuruProduct> products = productService.findByCategoryList(category);
        if(products.size() > 0)
            return new ResponseEntity<>(products, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/product/{productId}/{quantityInStock}")
    public ResponseEntity<ChandruGuruProduct> update(@PathVariable int productId, @PathVariable int quantityInStock) {
        ChandruGuruProduct product = productService.updateProduct(productId, quantityInStock);
        if(product != null && product.getQuantityInStock() == quantityInStock)
            return new ResponseEntity<>(product, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<String> delete(@PathVariable int productId) {
        ChandruGuruProduct product = productService.deleteProduct(productId);
        if(product == null)
            return new ResponseEntity<>("Product deteled successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}