package com.sample.driveway.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.driveway.model.Product;
import com.sample.driveway.repository.ProductRepository;

@Service
public class ProductService 
{
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() 
    {
		return productRepository.findAll();
	}

    public String storeProduct(Product product) 
    {
		if (productRepository.existsById(product.getPid())) 
        {
			return "Car Id Should Be Unique";
		} 
        else 
        {
			productRepository.save(product);
			return "Car details Stored Successfully";
		}
	}

    public String updateProductPrice(Product product) 
    {
		if (productRepository.existsById(product.getPid())) 
        {
			Product pp = productRepository.getReferenceById(product.getPid());
			pp.setPrice(product.getPrice());
			productRepository.saveAndFlush(pp);
			return "Car Price Updated Successfully";
		} 
        else 
        {
			return "No product Found";
		}
	}

    public String deleteProduct(int pid) 
    {
		if (!productRepository.existsById(pid)) 
        {
			return "Car Details Not Present";
		} 
        else 
        {
			productRepository.deleteById(pid);
			return "Car details Deleted Successfully";
		}
	}

	public List<Product> findProductUsingPrice(float price) 
    {
		return productRepository.getProductByPrice(price);
	}
}
