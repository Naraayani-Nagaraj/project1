package com.sample.driveway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.driveway.model.Shortlist;
import com.sample.driveway.service.ShortlistService;

@RestController
@RequestMapping("/shortlist")
@CrossOrigin(origins = "http://localhost:4200")
public class ShortlistController 
{
    @Autowired
    ShortlistService shortlist;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "storeShort", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveCart(@RequestBody Shortlist shor)
    {
        return shortlist.storeCart(shor);
    } 
}