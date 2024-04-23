package com.example.day5cw1.service;

import org.springframework.stereotype.Service;

import com.example.day5cw1.model.ChandruGuruProduct;
import com.example.day5cw1.repository.ChandruGuruProductRepo;

@Service
public class ChandruGuruProductService {
    public ChandruGuruProductRepo productRepo;
    public ChandruGuruProductService(ChandruGuruProductRepo productRepo)
    {
        this.productRepo = productRepo;
    }
    public boolean saveProduct(ChandruGuruProduct product)
    {
        try
        {
            productRepo.save(product);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean updateDetails(int id,ChandruGuruProduct product)
    {
        if(this.getProductById(id)==null)
        {
            return false;
        }
        try{
            productRepo.save(product);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteProduct(int id)
    {
        if(this.getProductById(id) == null)
        {
            return false;
        }
        productRepo.deleteById(id);
        return true;
    }
    public ChandruGuruProduct getProductById(int id)
    {
        return productRepo.findById(id).orElse(null);
    }
}
