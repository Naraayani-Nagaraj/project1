package com.sample.driveway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.driveway.model.Shortlist;
import com.sample.driveway.repository.ShortlistRepository;

@Service
public class ShortlistService 
{
    @Autowired
    ShortlistRepository shortlistRepository;

    public String storeCart(Shortlist lis) 
    {
		if(shortlistRepository.existsById(lis.getCid())) 
        {
			return "Already present!";
		}
		else 
        {
			shortlistRepository.save(lis);
			return "saved successfully!";
		}
		
	}
}
