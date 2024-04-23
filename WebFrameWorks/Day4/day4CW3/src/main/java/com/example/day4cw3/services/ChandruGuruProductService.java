package com.example.day4cw3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.day4cw3.model.ChandruGuruProduct;
import com.example.day4cw3.repository.ChandruGuruProductRepo;

@Service
public class ChandruGuruProductService {
    public ChandruGuruProductRepo productRepo;
    public ChandruGuruProductService(ChandruGuruProductRepo productRepo)
    {
        this.productRepo=productRepo;
    }
    public boolean saveProduct(ChandruGuruProduct product)
    {
        try{
            productRepo.save(product);

        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<ChandruGuruProduct> getProducts()
    {
        return productRepo.findAll();
    }
    public ChandruGuruProduct getProductById(int id)
    {
        Optional<ChandruGuruProduct> obj = productRepo.findById(id);
        return obj.orElse(new ChandruGuruProduct());
    }
}
