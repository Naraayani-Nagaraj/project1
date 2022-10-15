package com.sample.driveway.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sample.driveway.config.CSVHelper;
import com.sample.driveway.model.Product;
import com.sample.driveway.repository.ProductRepository;

@Service
public class CSVService 
{
    @Autowired
    ProductRepository productRepository;

    public void save(MultipartFile file)
    {
        try 
        {
			List<Product> products = CSVHelper.csvToProduct(file.getInputStream());
			productRepository.saveAll(products);
		}
		catch (IOException e) 
        {
		      throw new RuntimeException("fail to store csv data: " + e.getMessage());
		}
    }
}
