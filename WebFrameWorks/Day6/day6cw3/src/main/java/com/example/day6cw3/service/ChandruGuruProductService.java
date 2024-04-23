package com.example.day6cw3.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.day6cw3.model.ChandruGuruProduct;
import com.example.day6cw3.repository.ChandruGuruProductRepo;

@Service
public class ChandruGuruProductService {
    public ChandruGuruProductRepo productRepo;
    public ChandruGuruProductService(ChandruGuruProductRepo productRepo)
    {
        this.productRepo = productRepo;
    }
    public boolean postProduct(ChandruGuruProduct product)
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
    public List<ChandruGuruProduct> pagination(int offset,int size)
    {
        return productRepo.findAll(PageRequest.of(offset, size)).getContent();
    }
    public List<ChandruGuruProduct> sortPagination(int offset,int size,String field)
    {
        return productRepo.findAll(PageRequest.of(offset, size, Sort.by(field))).getContent();
    }
    public ChandruGuruProduct getProductById(int id)
    {
        return productRepo.findById(id).orElse(null);
    }
}
